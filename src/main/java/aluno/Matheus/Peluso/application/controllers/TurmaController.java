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

import aluno.Matheus.Peluso.domain.contracts.services.TurmaService;
import aluno.Matheus.Peluso.domain.models.dtos.TurmaRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.TurmaResponseDto;
import aluno.Matheus.Peluso.domain.models.dtos.TurmaResponseGetDto;
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
	public TurmaResponseDto deletar(@PathVariable UUID id) {
		return turmaService.deletarTurma(id);
	}
	
	@GetMapping("/consultar")
	public List<TurmaResponseGetDto> consultar() {
		return turmaService.consultarTodasTurmas();
	}
	
	@GetMapping("/consultar/{id}")
	public TurmaResponseGetDto consultarPorId(@PathVariable UUID id) {
		return turmaService.consultarTurmaPorId(id);
	}

}
