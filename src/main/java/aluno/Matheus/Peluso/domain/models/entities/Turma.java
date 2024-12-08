package aluno.Matheus.Peluso.domain.models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import aluno.Matheus.Peluso.domain.models.enums.Nivel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_turma")
public class Turma {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "materia",length = 50, nullable = false)
	private String materia;
	
	@Column(name = "numero", length = 10, nullable = false)
	private String numero;
	
	@Column(name = "ano_letivo", length = 4, nullable = false)
	private String anoLetivo;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "nivel", nullable = false)
	private Nivel nivel;
	
	@ManyToMany(mappedBy = "turmas")
	private List<Aluno> alunos = new ArrayList<>();
	
}
