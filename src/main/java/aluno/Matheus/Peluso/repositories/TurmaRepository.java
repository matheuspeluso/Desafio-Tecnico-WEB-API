package aluno.Matheus.Peluso.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluno.Matheus.Peluso.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository <Turma, UUID>{

}
