package br.com.rh.data.vo.usuario;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.rh.data.vo.cargo.CargoVO;
import br.com.rh.data.vo.departamento.DepartamentoVOV2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioVO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	private long id;

	@JsonIgnore
	private String imagem;

	private String nome;

	private String email;

	@JsonIgnore
	private String senha;

	private String login;
	
	
	private BigDecimal salario;

	
	private String CPF;

	private String RG;

	@JsonIgnore
	private Date dataNascimento;

	@JsonIgnore
	private Date dataContratacao;

	private CargoVO cargo;

	private String endereco;

	
	private DepartamentoVOV2 departamento;
	


}	
