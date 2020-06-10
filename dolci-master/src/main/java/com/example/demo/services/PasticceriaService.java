package com.example.demo.services;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Ordine;
import com.example.demo.entities.Elemento;
import com.example.demo.entities.Cliente;
import com.example.demo.entities.Dolce;
import com.example.demo.repositories.ElementoRepository;
import com.example.demo.repositories.OrdineRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.DolceRepository;

@Service
public class PasticceriaService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private DolceRepository dolceRepository;
	@Autowired
	private OrdineRepository ordineRepository;
	@Autowired
	private ElementoRepository elementoRepository;

	public Cliente addCliente(String nome, String cognome, String username, String indirizzo, String telefono) {
		Cliente clienteAggiunto = new Cliente();
		clienteAggiunto.setNome(nome);
		clienteAggiunto.setCognome(cognome);
		clienteAggiunto.setUsername(username);
		clienteAggiunto.setIndirizzo(indirizzo);
		clienteAggiunto.setTelefono(telefono);
		return clienteRepository.save(clienteAggiunto);

	}

	public Dolce addDolce(String nome, String descrizione, BigDecimal prezzo) {
		Dolce dolceAggiunto = new Dolce();
		dolceAggiunto.setNome(nome);
		dolceAggiunto.setDescrizione(descrizione);
		dolceAggiunto.setPrezzo(prezzo);
		return dolceRepository.save(dolceAggiunto);

	}

	public Iterable<Dolce> getDolci() {
		return dolceRepository.findAll();

	}

	public Ordine addElemento(Integer idDolce, Integer idCliente) {
		Elemento elementoAggiunto = new Elemento();		
		Ordine ordine = controllaOrdine(idCliente);
		
		Dolce dolce = dolceRepository.findById(idDolce).orElse(null);
		elementoAggiunto.setOrdine(ordine);
		elementoAggiunto.setDolce(dolce);
		elementoAggiunto.setQuantità(1);
		ordine.getElementi().add(elementoAggiunto);
		return ordineRepository.save(ordine);
	}

	public Ordine controllaOrdine(Integer idCliente) {
		Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
		for(Ordine ordine : cliente.getOrdini()) {
			if(ordine.isStato()) {
				return ordine;
			}
		}
		Ordine nuovoOrdine = new Ordine();
		nuovoOrdine.setStato(true);
		nuovoOrdine.setCliente(cliente);		
		return ordineRepository.save(nuovoOrdine);	
	}
	
	
	public Set<Elemento> getOrdine(Integer idCliente) {
		Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
		
		for(Ordine ordine : cliente.getOrdini()) {
			if(ordine.isStato()) {
				return ordine.getElementi();
			}
		}
		return null;
	}
	
	public void deleteElemento(Integer idElemento) {
		elementoRepository.deleteById(idElemento);
		
	}
	
	public Cliente cercaCliente(String username) {
		Iterable<Cliente> clienti = clienteRepository.findAll();
		for(Cliente cliente : clienti) {
			if(cliente.getUsername().equals(username)) {
				return cliente;
			}
		}
		return null;
	}

//	Address indirizzoTrovato = utente.getIndirizzi().stream().filter(utente -> utente.getId().equals(addressId))
//			.findAny().orElse(null);

//	public Carrello addCarrello(Integer clienteId, Set<Elemento> elementi, boolean stato) {
//		Carrello carrelloAggiunto = new Carrello();
//		Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
//		carrelloAggiunto.setElementi(elementi);
//		
//		
//		
//	}
}
