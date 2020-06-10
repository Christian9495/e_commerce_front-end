package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Elemento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer quantità;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false) //per un indirizzo l'utente deve esistere
    @JoinColumn(name = "ordineId", nullable = false) //quella colonna sarà not null...name sarà il nome della chiave esterna
	@JsonIgnore 
	private Ordine ordine;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false) //per un indirizzo l'utente deve esistere
    @JoinColumn(name = "dolceId", nullable = false) //quella colonna sarà not null...name sarà il nome della chiave esterna
	private Dolce dolce;
	
	public Dolce getDolce() {
		return dolce;
	}
	public void setDolce(Dolce dolce) {
		this.dolce = dolce;
	}
	public Ordine getOrdine() {
		return ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getQuantità() {
		return quantità;
	}
	public void setQuantità(Integer quantità) {
		this.quantità = quantità;
	}
	
	
	
}
