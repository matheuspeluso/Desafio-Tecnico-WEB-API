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
}
