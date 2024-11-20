package aluno.Matheus.Peluso.dtos;

import aluno.Matheus.Peluso.enums.Nivel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TurmaRequestDto {
	
	@Size(min = 1, max = 10, message = "Por favor, informe o numero da turma de 1 a 8 caracteres.")
	@NotEmpty(message = "Por favor, informe o numero da turma.")
	private String numero;
	
	@Size(min = 4 , max = 50, message = "Por favor, informe o nome da matéria com no minimo 4 caracteres e no maximo 50.")
	@NotEmpty(message = "Por favor, informe a materia.")
	private String materia;
	
	@Size(min = 4, max = 4, message = "Por favor, informe o ano letivo com 4 digitos.")
	@NotEmpty(message = "Por favor, informe o ano letivo.")
	private String anoLetivo;
	
	@Pattern(regexp = "^(BASICO|INTERMEDIARIO|AVANCADO)$",message = "Por favor, informe o nivel do curso com um desses valores : BASICO, INTERMEDIARIO, AVANCADO .")
	@NotEmpty(message = "Por favor, informe o nivel do curso, BASICO, INTERMEDIARIO, AVANCADO")
	private Nivel nivel;
}
