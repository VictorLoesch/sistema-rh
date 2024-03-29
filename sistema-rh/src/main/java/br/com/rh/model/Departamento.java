package br.com.rh.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Usuarios> funcionarios;
	
	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Usuarios responsavel;
	
	
// ------------------------------------- Construtores --------------------------------------------	
	
	public Departamento() {}


	public Departamento(String nome, List<Usuarios> funcionarios, Usuarios responsavel) {
		super();
		this.nome = nome;
		this.funcionarios = funcionarios;
		this.responsavel = responsavel;
	}


// ------------------------------------- Geters e seters  --------------------------------------------	
	
	
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

	public List<Usuarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Usuarios> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Usuarios getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuarios responsavel) {
		this.responsavel = responsavel;
	}

	
// ------------------------------------- Equals e hashCode --------------------------------------------	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(funcionarios, id, nome, responsavel);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(funcionarios, other.funcionarios) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(responsavel, other.responsavel);
	}
	
	
	
// ------------------------------------- Metodos auxiliares --------------------------------------------	
	
	//Método para saber quantos funcionários um departamento tem
	public int qtdFuncionarios() {
		return this.funcionarios.size();
	}


	

	
	
	
	
	
	
	
	
	
	
	
}
