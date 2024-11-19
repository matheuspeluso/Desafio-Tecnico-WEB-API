package aluno.Matheus.Peluso.dtos;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class TurmaResponseDto {
	private UUID id;
	private String numero;
	private String anoLetivo;
	private String nivel;
	
}
