package aluno.Matheus.Peluso.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aluno.Matheus.Peluso.dtos.TurmaRequestDto;
import aluno.Matheus.Peluso.dtos.TurmaResponseDto;
import aluno.Matheus.Peluso.entities.Turma;
import aluno.Matheus.Peluso.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository turmaRepostory;
	
	public TurmaResponseDto cadastrarTurma(TurmaRequestDto dto) {
		
		var turma = new Turma();
		turma.setId(UUID.randomUUID());
		turma.setMateria(dto.getMateria());
		turma.setNumero(dto.getNumero());
		turma.setAnoLetivo(dto.getAnoLetivo());
		turma.setNivel(dto.getNivel());
		
		 if(turmaRepostory.existsByNumero(turma.getNumero())) {
			 throw new IllegalArgumentException("O numero da turma informado já está cadatrado , tente outro!");
		 }
		
		 turmaRepostory.save(turma);
		//response
		var response = new TurmaResponseDto();
		response.setId(turma.getId());
		response.setMateria(turma.getMateria());
		response.setNumero(turma.getNumero());
		response.setAnoLetivo(turma.getAnoLetivo());
		response.setNivel(turma.getNivel().toString());
		response.setMensagem("Turma cadastrada com sucesso!");
		
		return response;
	}
	
	public TurmaResponseDto editarTurma(UUID id, TurmaRequestDto dto) {
		
		var turmaExistente = turmaRepostory.findById(id).orElse(null);
		
		if(turmaExistente == null) {
			throw new IllegalArgumentException("Turma não encontrada.");
		}
		
		// Verifica se já existe outra turma com o mesmo número
	    if (turmaRepostory.existsByNumeroAndIdNot(dto.getNumero(), id)) {
	        throw new IllegalArgumentException("Já existe uma turma cadastrada com esse número. Tente outro.");
	    }
		
		turmaExistente.setNumero(dto.getNumero());
		turmaExistente.setMateria(dto.getMateria());
		turmaExistente.setAnoLetivo(dto.getAnoLetivo());
		turmaExistente.setNivel(dto.getNivel());
		
		turmaRepostory.save(turmaExistente);
		
		var response = new TurmaResponseDto();
		response.setId(turmaExistente.getId());
		response.setNumero(turmaExistente.getNumero());
		response.setMateria(turmaExistente.getMateria());
		response.setAnoLetivo(turmaExistente.getAnoLetivo());
		response.setNivel(turmaExistente.getNivel().toString());
		response.setMensagem("Turma editada com sucesso.");
		
		return response;
	}
	
	public String deletarTurma(UUID id){
		
		var turma = turmaRepostory.findById(id);
		
		if(!turma.isPresent()) {
			throw new IllegalArgumentException("Turma não encontrada, verifique o Id informado.");
		}
		
		turmaRepostory.deleteById(id);
		return "Turma excluida com sucesso.";
	}
}
