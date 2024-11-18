package aluno.Matheus.Peluso.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_aluno")
public class Aluno {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "cpf", length = 20, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@ManyToMany
	@JoinTable(
			name = "tb_aluno_turma",
			joinColumns = @JoinColumn(name = "aluno_id",nullable = false),
			inverseJoinColumns = @JoinColumn(name = "turma_id",nullable = false)
		)
	private List<Turma> turmas = new ArrayList<>();
}
