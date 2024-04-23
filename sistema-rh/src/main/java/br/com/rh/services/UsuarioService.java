package br.com.rh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rh.data.vo.usuario.UsuarioVO;
import br.com.rh.mapper.DozerMapper;
import br.com.rh.model.Usuario;
import br.com.rh.repositorys.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<UsuarioVO> listAll(){
		return DozerMapper.parseListObjects(usuarioRepository.findAll(), UsuarioVO.class);
	}
	
	
	public UsuarioVO findById(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrados"));
		return DozerMapper.parseObject(usuario, UsuarioVO.class);
	}
	
	public UsuarioVO creat(Usuario usuario) {
		return DozerMapper.parseObject(usuarioRepository.save(usuario), UsuarioVO.class);
	}
	
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	
}
