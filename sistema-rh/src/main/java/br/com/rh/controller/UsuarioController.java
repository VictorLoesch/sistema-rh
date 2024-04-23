package br.com.rh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rh.data.vo.usuario.UsuarioVO;
import br.com.rh.model.Usuario;
import br.com.rh.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<List<UsuarioVO>> listAll(){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listAll());
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<UsuarioVO> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id));
	}
	
	@PostMapping(
			value = "/", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<UsuarioVO> creat(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.creat(usuario));
	}
	
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<?> delete(){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
