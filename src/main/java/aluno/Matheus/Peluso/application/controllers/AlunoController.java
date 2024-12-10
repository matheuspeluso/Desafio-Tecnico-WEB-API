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
import aluno.Matheus.Peluso.domain.models.dtos.AlunoMatriculaRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoResponseDto;
import aluno.Matheus.Peluso.domain.models.dtos.AlunoResponseGetDto;
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
	public AlunoResponseDto editar(@PathVariable @Valid UUID id, @RequestBody AlunoRequestDto dto) {
		return alunoService.editarAluno(id, dto);
	}
	
	@DeleteMapping("/deletar/{id}")
	public AlunoResponseDto deletar(@PathVariable UUID id) {
		return alunoService.deletarAluno(id);
	}
	
	@GetMapping("/consultar")
	public List<AlunoResponseGetDto> consultar() {
		return alunoService.consultarTodosAlunos();
		
	}
	
	@GetMapping("/consultar/{id}")
	public AlunoResponseGetDto consultarPorId(@PathVariable UUID id) {
		return alunoService.consultarAlunoPorId(id);
	}
	
	@PutMapping("/matricular-aluno")
	public String matricularAluno(@RequestBody AlunoMatriculaRequestDto dto) {
		return alunoService.matricularAlunoEmTurma(dto.getAlunoId(),dto.getTurmaId());
	}
	
	@PutMapping("/desmatricular-aluno")
	public String desmatricularAluno(@RequestBody AlunoMatriculaRequestDto dto) {
		return alunoService.desmatricularAlunoDeTurma(dto.getAlunoId(),dto.getTurmaId());
	}
	
}
