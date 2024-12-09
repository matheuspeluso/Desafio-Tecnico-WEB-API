package aluno.Matheus.Peluso.domain.contracts.services;

import java.util.List;
import java.util.UUID;

import aluno.Matheus.Peluso.domain.models.dtos.AlunoRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoResponseDto;

public interface AlunoService {

	public AlunoResponseDto cadastrarAluno(AlunoRequestDto dto, UUID turmaId);
	
	public AlunoResponseDto editarAluno(UUID id, AlunoRequestDto dto);
	
	public AlunoResponseDto deletarAluno(UUID id);
	
	public List<AlunoResponseDto> consultarTodosAlunos();
	
	public AlunoResponseDto consultarAlunoPorId();
	
	public String matricularAlunoEmTurma(UUID alunoId, UUID turmaId);

    public String desmatricularAlunoDeTurma(UUID alunoId, UUID turmaId);
	
}
