package be.vdab.entities;

import java.io.Serializable;
import java.util.List;

public class Saus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long nummer;
	private String naam;
	private List<String> ingrediënten;
	
	public Saus(long nummer, String naam, List<String> ingrediënten) {		
		this.nummer = nummer;
		this.naam = naam;
		this.ingrediënten = ingrediënten;
	}
	public long getNummer() {
		return nummer;
	}
	public void setNummer(long nummer) {
		this.nummer = nummer;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public List<String> getIngrediënten() {
		return ingrediënten;
	}
	public void setIngrediënten(List<String> ingrediënten) {
		this.ingrediënten = ingrediënten;
	}
	public void addIngredient(String ingredient){
		ingrediënten.add(ingredient);
	}
	
}
