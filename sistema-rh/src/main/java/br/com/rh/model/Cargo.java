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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//@NotBlank(message = "Cargo inválido")
	//@Size(min = 2, max = 50, message = "Cargo inválido")
	//@Column(nullable = false,length = 50,unique = true)
	private String nome;
	
	//@Size(min = 0,max = 200,message = "Número máximo de caracteres atingidos")
	//@Column(length = 200)
	private String descricao;

	
}
