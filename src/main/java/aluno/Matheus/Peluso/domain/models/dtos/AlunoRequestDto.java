package aluno.Matheus.Peluso.domain.models.dtos;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoRequestDto {
 
	@Size(min = 8, max = 100, message = "Por favor, informe o nome de 8 a 100 caracteres.")
	@NotEmpty(message = "Por favor, informe o nome do aluno.")
	private String nome;
	
	@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$|^\\d{11}$\r\n", 
			message = "Por favor, informe um cpf válido.")
	@NotEmpty(message = "Por favor, informe o cpf do aluno.")
	private String cpf;
	
	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotEmpty(message = "Por favor, informe o email do aluno.")
	private String email;
	
	@NotEmpty(message = "Por favor, informe pelo menos uma turma.")
    private List<UUID> turmas;
}
