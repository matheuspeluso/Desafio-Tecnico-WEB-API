package aluno.Matheus.Peluso.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aluno.Matheus.Peluso.domain.models.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno , UUID> {

}
