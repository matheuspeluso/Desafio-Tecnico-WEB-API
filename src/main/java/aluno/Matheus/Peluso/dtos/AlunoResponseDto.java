package aluno.Matheus.Peluso.dtos;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class AlunoResponseDto {
	private UUID ID;
	private String nome;
	private String cpf;
	private String email;
	
}
