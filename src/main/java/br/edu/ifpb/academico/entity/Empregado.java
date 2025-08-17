package br.edu.ifpb.academico.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_EMPREGADO")
public class Empregado {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "O nome do empregado é obrigatório")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "o email do empregado é obrigatória")
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank(message = "O cargo do empregado é obrigatório")
	@Column(nullable = false)
	private String cargo;
	
	//@NotBlank(message = "O salario do empregado é obrigatório")
	@Column(nullable = false)
	private float salario;
	
	//@NotBlank(message = "A data de admissão do empregado é obrigatória")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "admicao", nullable = false)
	private Date dataAdmissao;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
}
