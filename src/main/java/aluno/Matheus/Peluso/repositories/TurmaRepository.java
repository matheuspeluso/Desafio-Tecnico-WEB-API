package aluno.Matheus.Peluso.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aluno.Matheus.Peluso.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository <Turma, UUID>{
	
	@Query("SELECT COUNT(t) > 0 FROM Turma t WHERE t.numero = :numero")
	boolean existsByNumero(@Param("numero") String numero);


}
