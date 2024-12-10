package aluno.Matheus.Peluso.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aluno.Matheus.Peluso.domain.contracts.services.TurmaService;
import aluno.Matheus.Peluso.domain.models.dtos.TurmaRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.TurmaResponseDto;
import aluno.Matheus.Peluso.domain.models.dtos.TurmaResponseGetDto;
import aluno.Matheus.Peluso.domain.models.entities.Turma;
import aluno.Matheus.Peluso.infrastructure.repositories.TurmaRepository;
import jakarta.transaction.Transactional;


@Service
public class TurmaServiceImpl implements TurmaService {
	
	@Autowired TurmaRepository turmaRepository;
	
	
	
	public TurmaResponseDto cadastrarTurma(TurmaRequestDto dto) {
		
		var turma = new Turma();
		turma.setId(UUID.randomUUID());
		turma.setMateria(dto.getMateria());
		turma.setNumero(dto.getNumero());
		turma.setAnoLetivo(dto.getAnoLetivo());
		turma.setNivel(dto.getNivel());
		
		 if(turmaRepository.existsByNumero(turma.getNumero())) {
			 throw new IllegalArgumentException("O numero da turma informado já está cadatrado , tente outro!");
		 }
		
		 turmaRepository.save(turma);
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
		
		var turmaExistente = turmaRepository.findById(id).orElse(null);
		
		if(turmaExistente == null) {
			throw new IllegalArgumentException("Turma não encontrada.");
		}
		
		// Verifica se já existe outra turma com o mesmo número
	    if (turmaRepository.existsByNumeroAndIdNot(dto.getNumero(), id)) {
	        throw new IllegalArgumentException("Já existe uma turma cadastrada com esse número. Tente outro.");
	    }
		
		turmaExistente.setNumero(dto.getNumero());
		turmaExistente.setMateria(dto.getMateria());
		turmaExistente.setAnoLetivo(dto.getAnoLetivo());
		turmaExistente.setNivel(dto.getNivel());
		
		turmaRepository.save(turmaExistente);
		
		var response = new TurmaResponseDto();
		response.setId(turmaExistente.getId());
		response.setNumero(turmaExistente.getNumero());
		response.setMateria(turmaExistente.getMateria());
		response.setAnoLetivo(turmaExistente.getAnoLetivo());
		response.setNivel(turmaExistente.getNivel().toString());
		response.setMensagem("Turma editada com sucesso.");
		
		return response;
	}
	
	public TurmaResponseDto deletarTurma(UUID id){
		
		var turmaExistente = turmaRepository.findById(id)
		        .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada, verifique o Id informado."));

		// Verifica se a turma possui alunos matriculados
	    if(ExisteAlunoNaTurma(id)) {
	    	throw new IllegalArgumentException("Não é possível excluir turma. Ela possui alunos matriculados.");
	    }
		
		turmaRepository.deleteById(id);
		
		var response = new TurmaResponseDto();
		response.setId(turmaExistente.getId());
		response.setNumero(turmaExistente.getNumero());
		response.setMateria(turmaExistente.getMateria());
		response.setAnoLetivo(turmaExistente.getAnoLetivo());
		response.setNivel(turmaExistente.getNivel().toString());
		response.setMensagem("Turma excluida com sucesso.");
		
		return response;
	}
	
	public List<TurmaResponseGetDto> consultarTodasTurmas(){
		List<Turma> turmas = turmaRepository.findAll();
		
		//convertendo para dto
		List<TurmaResponseGetDto> responseList = new ArrayList<TurmaResponseGetDto>();

		
		for(Turma turma : turmas) {
			var response = new TurmaResponseGetDto();
            response.setId(turma.getId());
            response.setMateria(turma.getMateria());
            response.setNumero(turma.getNumero());
            response.setAnoLetivo(turma.getAnoLetivo());
            response.setNivel(turma.getNivel().toString());
            
            responseList.add(response);
		}
		return responseList;
	}
	
	public TurmaResponseGetDto consultarTurmaPorId(UUID id) {
		var turma = turmaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Turma não encontrada. Verifique o Id."));
		
		// Conversão para DTO
        var response = new TurmaResponseGetDto();
        response.setId(turma.getId());
        response.setMateria(turma.getMateria());
        response.setNumero(turma.getNumero());
        response.setAnoLetivo(turma.getAnoLetivo());
        response.setNivel(turma.getNivel().toString());
        
        return response;
	}
	
	@Transactional
	public boolean ExisteAlunoNaTurma(UUID idTurma) {
		return turmaRepository.existeAlunoMatriculadoNaTurma(idTurma);
	}
	
}
