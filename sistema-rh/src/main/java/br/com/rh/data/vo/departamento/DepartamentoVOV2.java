package br.com.rh.data.vo.departamento;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.rh.data.vo.usuario.UsuarioVOV2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoVOV2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonProperty("nome_departamento")
	private String nome;
	
	@JsonIgnore
	private UsuarioVOV2 responsavel;
	
	@JsonProperty("nome_Responsavel")
	public String getNomeResonsavel() {
		return this.getResponsavel().getNome();
	}
}
