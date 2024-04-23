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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rh.data.vo.cargo.CargoVO;
import br.com.rh.model.Cargo;
import br.com.rh.services.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	
	@PostMapping(
			value = "/",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<CargoVO> createCargo(@RequestBody Cargo cargo) {		
		return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.creat(cargo));
	}
	
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<List<CargoVO>> listCargos() {		
		return ResponseEntity.status(HttpStatus.OK).body(cargoService.listAll());
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<CargoVO> findByCargos(@PathVariable("id") Long id) {		
		return ResponseEntity.status(HttpStatus.OK).body(cargoService.findById(id));
	}
	
	@PutMapping(
					value = "/", 
					consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"},
					produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<CargoVO> update(@RequestBody Cargo cargo) {
		return ResponseEntity.status(HttpStatus.OK).body(cargoService.update(cargo));
	}
	
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,"application/x-yaml"} )
	public ResponseEntity<?> delete(@PathVariable Long id) {
		cargoService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
