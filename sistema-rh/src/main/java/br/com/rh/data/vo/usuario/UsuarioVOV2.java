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
public class UsuarioVOV2 implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	private long id;

	@JsonIgnore
	private String imagem;

	private String nome;

	private String email;

	private String login;
	
	
	private CargoVO cargo;

	private String endereco;
	
	
}	
