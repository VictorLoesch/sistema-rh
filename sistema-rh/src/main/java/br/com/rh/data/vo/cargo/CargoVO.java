package br.com.rh.data.vo.cargo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String descricao;

}
