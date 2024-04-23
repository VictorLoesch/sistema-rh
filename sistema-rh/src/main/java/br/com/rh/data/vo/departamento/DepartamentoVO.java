package br.com.rh.data.vo.departamento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.rh.data.vo.usuario.UsuarioVOV2;
import br.com.rh.mapper.DozerMapper;
import br.com.rh.model.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private UsuarioVOV2 responsavel;
	
	@Setter(AccessLevel.NONE)
	private List<UsuarioVOV2> funcionarios;
	
	
	public void setFuncionarios(List<Usuario> funcionarios) {
		this.funcionarios = DozerMapper.parseListObjects(funcionarios, UsuarioVOV2.class);
	}
	
	
}
