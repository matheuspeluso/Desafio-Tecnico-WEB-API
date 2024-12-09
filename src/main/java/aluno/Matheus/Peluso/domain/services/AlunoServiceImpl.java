package aluno.Matheus.Peluso.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aluno.Matheus.Peluso.domain.contracts.services.AlunoService;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoResponseDto;
import aluno.Matheus.Peluso.domain.models.entities.Aluno;
import aluno.Matheus.Peluso.domain.models.entities.Turma;
import aluno.Matheus.Peluso.infrastructure.repositories.AlunoRepository;
import aluno.Matheus.Peluso.infrastructure.repositories.TurmaRepository;
import jakarta.transaction.Transactional;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired AlunoRepository alunoRepository;
	@Autowired TurmaRepository turmaRepository;
	
	@Override
	public AlunoResponseDto cadastrarAluno(AlunoRequestDto dto, UUID turmaId) {
		
		Aluno aluno = new Aluno();
		aluno.setId(UUID.randomUUID());
		aluno.setNome(dto.getNome());
		aluno.setEmail(dto.getEmail());
		aluno.setCpf(dto.getCpf());
		
		if(turmaId !=null) {
			Turma turma = turmaRepository.findById(turmaId)
					.orElseThrow(() -> new IllegalArgumentException
							("Turma não encontrada. Verifique o Id."));
			
			aluno.getTurmas().add(turma);
			turma.getAlunos().add(aluno);
			
		}
		
		alunoRepository.save(aluno);
		
		//dto de resposta
		var response = new AlunoResponseDto();
		response.setID(aluno.getId());
		response.setNome(aluno.getNome());
		response.setEmail(aluno.getEmail());
		response.setCpf(aluno.getCpf());
		response.setMensagem("Aluno Cadastrado com sucesso!");
		
		return response;
	}

	@Override
	public AlunoResponseDto editarAluno(UUID id, AlunoRequestDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlunoResponseDto deletarAluno(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlunoResponseDto> consultarTodosAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlunoResponseDto consultarAlunoPorId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String matricularAlunoEmTurma(UUID alunoId, UUID turmaId) {
		//verificando a existencia de aluno
		Aluno aluno = alunoRepository.findById(alunoId)
				.orElseThrow(()-> new IllegalArgumentException
						("Aluno não encontrada. Verifique o Id informado."));
		//verificando a existencia de turma
		Turma turma = turmaRepository.findById(turmaId)
				.orElseThrow(() -> new IllegalArgumentException
						("Turma não encontrada. Verifique o Id informado."));
		
		
		if (verificarAlunoNaTurma(alunoId, turmaId)) {
		    throw new IllegalArgumentException("Não foi possível matricular este aluno. Pois ele já está matriculado nesta turma.");
		}
		
		if(CadastradoEmMaisDe4Turmas(alunoId)) {
			throw new IllegalArgumentException
			("Não foi possível matricular este aluno. Pois ele já está matriculado em mais de 4 turmas.");
		}
		
		//adicionando o aluno à turma
		turma.getAlunos().add(aluno);
		
		//adicionando a turma ao aluno
		aluno.getTurmas().add(turma);
		
		//salvar as alterações no banco de dados
		turmaRepository.save(turma);
		alunoRepository.save(aluno);
		
		return "Aluno matriculado com sucesso!";
	}

	@Override
	public String desmatricularAlunoDeTurma(UUID alunoId, UUID turmaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public boolean verificarAlunoNaTurma(UUID alunoId, UUID turmaId) {
	    return alunoRepository.existsAlunoInTurma(alunoId, turmaId);
	}
	
	@Transactional
	public boolean CadastradoEmMaisDe4Turmas(UUID alunoId) {
		var value = alunoRepository.contarTurmasDoAluno(alunoId);
		if(value >= 4) {
			return true;
		}
		return false;
	}


}
