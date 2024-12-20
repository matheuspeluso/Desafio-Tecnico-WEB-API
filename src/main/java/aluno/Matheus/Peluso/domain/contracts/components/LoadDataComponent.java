package aluno.Matheus.Peluso.domain.contracts.components;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import aluno.Matheus.Peluso.domain.models.entities.Aluno;
import aluno.Matheus.Peluso.domain.models.entities.Turma;
import aluno.Matheus.Peluso.domain.models.enums.Nivel;
import aluno.Matheus.Peluso.infrastructure.repositories.AlunoRepository;
import aluno.Matheus.Peluso.infrastructure.repositories.TurmaRepository;

@Component
public class LoadDataComponent implements ApplicationRunner{
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		var turmaCadastro = new Turma();
		turmaCadastro.setId(UUID.fromString("cb852aaf-f90b-4d5f-94f7-f50680e8dc51"));
		turmaCadastro.setMateria("Java Web Developer");
		turmaCadastro.setNumero("01");
		turmaCadastro.setAnoLetivo("2024");
		turmaCadastro.setNivel(Nivel.AVANCADO);
		
		var alunoCadastro = new Aluno();
		alunoCadastro.setId(UUID.fromString("1af39445-7d84-4373-a992-351e88914272"));
		alunoCadastro.setNome("Matheus Peluso");
		alunoCadastro.setCpf("789.412.050-26");
		alunoCadastro.setEmail("matheuspeluso17@gmail.com");
		
		
		turmaRepository.save(turmaCadastro);
		alunoRepository.save(alunoCadastro);
	}

}
