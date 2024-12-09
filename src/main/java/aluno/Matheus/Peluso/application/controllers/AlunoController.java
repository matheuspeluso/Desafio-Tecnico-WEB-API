package aluno.Matheus.Peluso.application.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aluno.Matheus.Peluso.domain.contracts.services.AlunoService;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoResponseDto;
import aluno.Matheus.Peluso.domain.models.entities.Aluno;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	@Autowired AlunoService alunoService;
	
	@PostMapping("cadastrar")
	public AlunoResponseDto cadastrar(@RequestBody @Valid AlunoRequestDto dto, UUID turmaId) {
		return alunoService.cadastrarAluno(dto, turmaId);
	}
	
	@PutMapping("/editar/{id}")
	public void editar(@PathVariable @Valid UUID id, @RequestBody AlunoRequestDto dto) {
		//TODO
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable UUID id) {
		//TODO
	}
	
	@GetMapping("/consultar")
	public List<Aluno> consultar() {
		return null;
		//TODO
	}
	
	@GetMapping("/consultar/{id}")
	public void consultarPorId(@PathVariable UUID id) {
		//TODO
	}
	
	@PutMapping("matricularAluno")
	public String MatricularAluno(UUID idAluno, UUID idTurma) {
		return alunoService.matricularAlunoEmTurma(idAluno, idTurma);
	}
	
	

}
