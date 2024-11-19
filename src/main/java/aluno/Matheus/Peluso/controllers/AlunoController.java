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

import aluno.Matheus.Peluso.dtos.AlunoRequestDto;
import aluno.Matheus.Peluso.entities.Aluno;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
	
	@PostMapping("cadastrar")
	public void cadastrar(@RequestBody @Valid AlunoRequestDto dto) {
		//TODO
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
	
	

}
