package aluno.Matheus.Peluso.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aluno.Matheus.Peluso.dtos.TurmaRequestDto;
import aluno.Matheus.Peluso.entities.Turma;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody @Valid TurmaRequestDto dto) {
		//TODO
	}
	
	@PutMapping("/editar/{id}")
	public void editar(@PathVariable @Valid UUID id, TurmaRequestDto dto) {
		//TODO
	}
	
	@DeleteMapping("/deletar/{id}")
	public void deletar(@PathVariable UUID id) {
		//TODO
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
