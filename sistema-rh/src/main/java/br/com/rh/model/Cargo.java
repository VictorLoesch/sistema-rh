package br.com.rh.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "Cargo inválido")
	@Size(min = 2, max = 50, message = "Cargo inválido")
	@Column(nullable = false,length = 50,unique = true)
	private String nome;
	
	@Size(min = 0,max = 200,message = "Número máximo de caracteres atingidos")
	@Column(length = 200)
	private String descricao;

	
// ------------------------------------- Construtores --------------------------------------------		

	
	
	
	public Cargo(@NotBlank(message = "Cargo inválido") @Size(min = 2, max = 50, message = "Cargo inválido") String nome,
			@Size(min = 0, max = 200, message = "Número máximo de caracteres atingidos") String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	
	public Cargo() {}


	
// ------------------------------------- Geters e seters --------------------------------------------

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
// ------------------------------------- Equals e hashCode --------------------------------------------	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}
	
	
	
	
}
