package aluno.Matheus.Peluso.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import aluno.Matheus.Peluso.domain.models.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno , UUID> {
	
	/*validação para saber se aluno ja esta matriculado em uma turma para
	 * evitar duplicidade
	 */
	
	@Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM Aluno a JOIN a.turmas at WHERE a.id = :alunoId AND at.id = :turmaId) THEN true ELSE false END")
	boolean existsAlunoInTurma(UUID alunoId, UUID turmaId);

	@Query("SELECT COUNT(at) FROM Aluno a JOIN a.turmas at WHERE a.id = :alunoId")
	int contarTurmasDoAluno(UUID alunoId);


}
