package aluno.Matheus.Peluso.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aluno.Matheus.Peluso.domain.models.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository <Turma, UUID>{
	
	@Query("SELECT COUNT(t) > 0 FROM Turma t WHERE t.numero = :numero")
	boolean existsByNumero(@Param("numero") String numero);
	
	@Query("SELECT COUNT(t) > 0 FROM Turma t WHERE t.numero = :numero AND t.id <> :id")
	boolean existsByNumeroAndIdNot(@Param("numero") String numero, @Param("id") UUID id);


	


}
