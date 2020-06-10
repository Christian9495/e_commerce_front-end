package com.example.demo.controllers;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Dolce;
import com.example.demo.entities.Elemento;
import com.example.demo.services.PasticceriaService;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/pasticceria")
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

	@Autowired
	private PasticceriaService pasticceriaService;

	@PostMapping(path = "/addCliente")
	public @ResponseBody String addCliente(@RequestParam String nome, @RequestParam String cognome,
			@RequestParam String username, @RequestParam String indirizzo, @RequestParam String telefono) {
		pasticceriaService.addCliente(nome, cognome, username, indirizzo, telefono);
		return "cliente salvato";
	}
	
	@PostMapping(path = "/addDolce")
	public @ResponseBody String addDolce(@RequestParam String nome, @RequestParam String descrizione, @RequestParam BigDecimal prezzo) {
		pasticceriaService.addDolce(nome, descrizione, prezzo);
		return "dolce salvato";
	}
	
	@GetMapping(path = "/allDolci")
	public @ResponseBody Iterable<Dolce> getDolci(){
		return pasticceriaService.getDolci();
	}
	
	@PostMapping(path = "/addElemento")
	public @ResponseBody String addElemento(@RequestParam Integer idDolce, @RequestParam Integer idCliente) {
		pasticceriaService.addElemento(idDolce, idCliente);
		return "CarrelloDolce salvato";
		
	}
	
	@GetMapping(path = "/ordine")
	public @ResponseBody Set<Elemento> getOrdine(@RequestParam Integer idCliente){
		return pasticceriaService.getOrdine(idCliente);
	}
	
	@PostMapping(path = "/deleteElemento")
	public @ResponseBody String deleteElemento(@RequestParam Integer idElemento) {
		pasticceriaService.deleteElemento(idElemento);
		return "Elemento eliminato";
		
	}
	
	
	@PostMapping(path = "/cercaCliente")
	public  @ResponseBody Cliente cercaCliente(@RequestBody String username) {
		return pasticceriaService.cercaCliente(username);
		
	}

}
