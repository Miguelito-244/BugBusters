package br.edu.ifpb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.academico.entity.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{
	boolean existsByEmail(String email);
}
