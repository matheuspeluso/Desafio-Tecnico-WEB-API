package aluno.Matheus.Peluso.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aluno.Matheus.Peluso.domain.models.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository <Turma, UUID>{
	
	//verifica se o numero da turma ja existe para não cadastrar turma com numeros iguais
	@Query("SELECT COUNT(t) > 0 FROM Turma t WHERE t.numero = :numero")
	boolean existsByNumero(@Param("numero") String numero);
	
	//verifica se o id que está cadastrando o numero  é o mesmo do numero / para usar no put
	@Query("SELECT COUNT(t) > 0 FROM Turma t WHERE t.numero = :numero AND t.id <> :id")
	boolean existsByNumeroAndIdNot(@Param("numero") String numero, @Param("id") UUID id);
	
	 // Verifica se há algum aluno matriculado em uma turma com id informado
    @Query("SELECT COUNT(a) > 0 FROM Aluno a JOIN a.turmas t WHERE t.id = :turmaId")
    boolean existeAlunoMatriculadoNaTurma(UUID turmaId);

}
