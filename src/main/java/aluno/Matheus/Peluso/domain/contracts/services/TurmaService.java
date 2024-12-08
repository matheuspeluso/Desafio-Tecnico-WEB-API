package aluno.Matheus.Peluso.domain.contracts.services;

import java.util.List;
import java.util.UUID;

import aluno.Matheus.Peluso.domain.models.dtos.TurmaRequestDto;
import aluno.Matheus.Peluso.domain.models.dtos.TurmaResponseDto;

public interface TurmaService {
	
	public TurmaResponseDto cadastrarTurma(TurmaRequestDto dto);
	
	public TurmaResponseDto editarTurma(UUID id, TurmaRequestDto dto);
	
	public TurmaResponseDto deletarTurma(UUID id);
	
	public List<TurmaResponseDto> consultarTodasTurmas();
	
	public TurmaResponseDto consultarTurmaPorId(UUID id);
}
