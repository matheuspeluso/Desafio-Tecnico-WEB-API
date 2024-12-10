package aluno.Matheus.Peluso.domain.contracts.services;

import java.util.List;
import java.util.UUID;

import aluno.Matheus.Peluso.domain.models.dtos.AlunoRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoResponseDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoResponseGetDto;

public interface AlunoService {

	public AlunoResponseDto cadastrarAluno(AlunoRequestDto dto, UUID turmaId);
	
	public AlunoResponseDto editarAluno(UUID id, AlunoRequestDto dto);
	
	public AlunoResponseDto deletarAluno(UUID id);
	
	public List<AlunoResponseGetDto> consultarTodosAlunos();
	
	public AlunoResponseGetDto consultarAlunoPorId(UUID id);
	
	public String matricularAlunoEmTurma(UUID alunoId, UUID turmaId);

    public String desmatricularAlunoDeTurma(UUID alunoId, UUID turmaId);
	
}
