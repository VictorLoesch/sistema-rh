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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Usuario> funcionarios;
	
	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Usuario responsavel;
	
	
// ------------------------------------- Metodos auxiliares --------------------------------------------	
	
	//Método para saber quantos funcionários um departamento tem
	public int qtdFuncionarios() {
		return this.funcionarios.size();
	}


	

	
	
	
	
	
	
	
	
	
	
	
}
