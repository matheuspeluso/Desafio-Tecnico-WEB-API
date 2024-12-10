package aluno.Matheus.Peluso.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class AlunoMatriculaRequestDto {
	private UUID alunoId;
    private UUID turmaId;
}
