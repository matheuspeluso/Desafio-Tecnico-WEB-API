package aluno.Matheus.Peluso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aluno.Matheus.Peluso.dtos.AlunoRequestDto;
import aluno.Matheus.Peluso.dtos.AlunoResponseDto;
import aluno.Matheus.Peluso.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired 
	AlunoRepository alunoRepository;
	
	public AlunoResponseDto cadastrarAluno(AlunoRequestDto dto) {
		return null;
	}
	
}
