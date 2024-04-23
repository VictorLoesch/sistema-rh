package br.com.rh.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(columnDefinition = "TEXT")
	private String imagem;

	@NotBlank(message = "Nome inválido")
	@Size(min = 3, max = 100, message = "Nome com caracteres acima de 100 ou abaixo de 3")
	@Column(nullable = false)
	private String nome;

	//@Email(message = "Email inválido")
	//@Size(min = 3, max = 100, message = "Nome com caracteres acima de 100 ou abaixo de 3")
	//@Column(nullable = false)
	private String email;

	@NotBlank(message = "Senha inválido")
	@Size(min = 1, message = "Senha inválido")
	@Column(nullable = false)
	private String senha;

	@NotBlank(message = "Login inválido")
	@Size(min = 3, max = 100, message = "Login inválido")
	@Column(nullable = false, unique = true)
	private String login;

	@NotNull
	@Column(precision = 8, scale = 2)
	private BigDecimal salario;

	//@NotBlank(message = "CPF inválido")
	//@Size(min = 11, max = 14, message = "CPF inválido") // Ele ira aceitar no máximo 14 pois pode vir com . ou -
	//@Column(nullable = false, length = 11, unique = true)
	private String CPF;

	@NotBlank(message = "RG inválido")
	@Column(nullable = false)
	private String RG;

	//@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	//@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataContratacao;

	// @NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	//@NotBlank(message = "Endereço inválido")
	//@Size(min = 10, max = 250, message = "Endereço inválido")
	//@Column(nullable = false)
	private String endereco;

	@ManyToOne
    @JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	
	public String getRole() {
		return this.cargo.getNome(); // Retorna o nome do cargo como a role
	}

	public String getResponsavel() {
		return this.departamento.getResponsavel().getNome(); // Retorna o responsavel desse funcionario caso exista
	}
	
// ------------------------------------- Construtores --------------------------------------------	
	
	
	
}
