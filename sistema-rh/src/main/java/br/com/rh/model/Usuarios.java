package br.com.rh.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuarios implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(columnDefinition = "TEXT")
	private String imagem;

	//@NotBlank(message = "Nome inválido")
	//@Size(min = 3, max = 100, message = "Nome com caracteres acima de 100 ou abaixo de 3")
	@Column(nullable = false)
	private String nome;

	//@Email(message = "Email inválido")
	//@Size(min = 3, max = 100, message = "Nome com caracteres acima de 100 ou abaixo de 3")
	@Column(nullable = false)
	private String email;

	//@NotBlank(message = "Senha inválido")
	//@Size(min = 1, message = "Senha inválido")
	//@Column(nullable = false)
	private String senha;

	//@NotBlank(message = "Login inválido")
	//@Size(min = 3, max = 100, message = "Login inválido")
	@Column(nullable = false, unique = true)
	private String login;

	@NotNull
	@Column(precision = 8, scale = 2)
	private BigDecimal salario;

	//@NotBlank(message = "CPF inválido")
	//@Size(min = 11, max = 14, message = "CPF inválido") // Ele ira aceitar no máximo 14 pois pode vir com . ou -
	//@Column(nullable = false, length = 11, unique = true)
	private String CPF;

	//@NotBlank(message = "RG inválido")
	//@Column(nullable = false)
	private String RG;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataContratacao;

	// @NotNull
	@ManyToOne
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


	
// ------------------------------------- Construtores --------------------------------------------	
	
	
	public Usuarios() {}


	public Usuarios(long id, String imagem, String nome, String email, String senha, String login,
			@NotNull BigDecimal salario, String cPF, String rG, @NotNull Date dataNascimento,
			@NotNull Date dataContratacao, Cargo cargo, String endereco, Departamento departamento) {
		super();
		this.id = id;
		this.imagem = imagem;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.login = login;
		this.salario = salario;
		CPF = cPF;
		RG = rG;
		this.dataNascimento = dataNascimento;
		this.dataContratacao = dataContratacao;
		this.cargo = cargo;
		this.endereco = endereco;
		this.departamento = departamento;
	}

	
// ------------------------------------- Geters e seters --------------------------------------------

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	
	
// ------------------------------------- Equals e hashCode --------------------------------------------		
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(CPF, RG, cargo, dataContratacao, dataNascimento, departamento, email, endereco, id, imagem,
				login, nome, salario, senha);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(CPF, other.CPF) && Objects.equals(RG, other.RG) && Objects.equals(cargo, other.cargo)
				&& Objects.equals(dataContratacao, other.dataContratacao)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(departamento, other.departamento) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && id == other.id && Objects.equals(imagem, other.imagem)
				&& Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
				&& Objects.equals(salario, other.salario) && Objects.equals(senha, other.senha);
	}

	
}
