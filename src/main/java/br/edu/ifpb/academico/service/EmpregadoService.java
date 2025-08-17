package br.edu.ifpb.academico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.academico.entity.Empregado;
import br.edu.ifpb.academico.repository.EmpregadoRepository;

@Service
public class EmpregadoService {

	@Autowired
	protected EmpregadoRepository empregadoRepository;
	
	public Empregado save(Empregado empregado) {
		return empregadoRepository.save(empregado);
	}
	
	public List<Empregado> findAll() {
		return empregadoRepository.findAll();
	}
	
	public Empregado findById(Long id) {
		return empregadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Empregado não encontrado com o id: " + id));
	}
	
	public void deleteById(Long id) {
		if (!empregadoRepository.existsById(id)) {
			throw new RuntimeException("Empregado não encontrado com o id: " + id);
		}
		empregadoRepository.deleteById(id);
	}
	
	public boolean existsByEmail(String email) {
		return empregadoRepository.existsByEmail(email);
	}
}
