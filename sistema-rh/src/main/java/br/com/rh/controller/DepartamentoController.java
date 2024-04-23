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

import br.com.rh.data.vo.departamento.DepartamentoVO;
import br.com.rh.model.Departamento;
import br.com.rh.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	@GetMapping(
			value = "/", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<List<DepartamentoVO>> listAll(){
		return ResponseEntity.status(HttpStatus.OK).body(departamentoService.listAll());
	}

	@GetMapping(
			value = "/{id}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public DepartamentoVO findById(@PathVariable Long id) {
		return departamentoService.findById(id);
	}
	
	@PostMapping(
			value = "/", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<DepartamentoVO> creat(@RequestBody Departamento departamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.create(departamento));
	}
	
	@DeleteMapping(
			value = "/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"})
	public ResponseEntity<?> delete(){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
