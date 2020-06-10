package com.example.demo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private boolean stato = false; //ordine non esistente
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL) //per un indirizzo l'utente deve esistere
    @JoinColumn(name = "clienteId", nullable = false) //quella colonna sarà not null...name sarà il nome della chiave esterna
	@JsonIgnore //evita di fare il rimpallo cliente-carrello
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Elemento> elementi;
	
	public Set<Elemento> getElementi() {
		return elementi;
	}
	public void setElementi(Set<Elemento> elementi) {
		this.elementi = elementi;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	

}
