package aluno.Matheus.Peluso.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class TurmaResponseDto {
	private UUID id;
	private String materia;
	private String numero;
	private String anoLetivo;
	private String nivel;
	private String mensagem;
	
}
