package tn.enig.model;

import javax.persistence.*;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String description ;
	private int quantite ;
	private float prix ;
	public Produit() {
		super();
	}
	public Produit(Integer id, String description, int quantite, float prix) {
		super();
		this.id = id;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
}
