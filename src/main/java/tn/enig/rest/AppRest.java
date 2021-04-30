package tn.enig.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IProduitDao;
import tn.enig.model.Produit;

@CrossOrigin("*") 
@RestController
@Timed
public class AppRest {
	
	@Autowired
	IProduitDao daop ;
	public void setDaop(IProduitDao daop) {
		this.daop=daop;
	}
	public AppRest(MeterRegistry registry) {
        // constructs a gauge to monitor the size of the population
        	registry.mapSize("produits", daop);
        }
	
	@GetMapping("/produits")
	public List<Produit> get1(){
		return daop.findAll();
	}
	@PostMapping("/addProduit")
	public Produit addProduit(@RequestBody Produit p) {
		return daop.save(p);
	}
	@DeleteMapping("/deleteProduit/{id}")
	public void deleteProduit(@PathVariable("id") int id) {
		daop.deleteById(id);
	}


}
