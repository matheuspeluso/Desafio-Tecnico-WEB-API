package aluno.Matheus.Peluso.controllers;

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

import aluno.Matheus.Peluso.dtos.TurmaRequestDto;
import aluno.Matheus.Peluso.dtos.TurmaResponseDto;
import aluno.Matheus.Peluso.entities.Turma;
import aluno.Matheus.Peluso.services.TurmaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	
	@Autowired
	TurmaService turmaService;
	
	@PostMapping("/cadastrar")
	public TurmaResponseDto cadastrar(@RequestBody @Valid TurmaRequestDto dto) {
		return turmaService.cadastrarTurma(dto);
	}
	
	@PutMapping("/editar/{id}")
	public TurmaResponseDto editar(@PathVariable @Valid UUID id, TurmaRequestDto dto) {
		return turmaService.editarTurma(id, dto);
	}
	
	@DeleteMapping("/deletar/{id}")
	public String deletar(@PathVariable UUID id) {
		return turmaService.deletarTurma(id);
	}
	
	@GetMapping("/consultar")
	public List<Turma> consultar() {
		return null;
	}
	
	@GetMapping("/consultar/{id}")
	public Turma consultarPorId(@PathVariable UUID id) {
		return null;
	}

}
