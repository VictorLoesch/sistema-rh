package br.com.rh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rh.services.CargoService;

@Controller
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;

}
