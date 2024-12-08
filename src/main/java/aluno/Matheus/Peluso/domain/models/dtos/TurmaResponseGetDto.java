package aluno.Matheus.Peluso.domain.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class TurmaResponseGetDto {
	private UUID id;
	private String materia;
	private String numero;
	private String anoLetivo;
	private String nivel;
}
