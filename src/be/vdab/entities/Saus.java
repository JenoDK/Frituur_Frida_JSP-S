package be.vdab.entities;

import java.util.List;

public class Saus {
	private long nummer;
	private String naam;
	private List<String> ingrediŽnten;
	
	public Saus(long nummer, String naam, List<String> ingrediŽnten) {		
		this.nummer = nummer;
		this.naam = naam;
		this.ingrediŽnten = ingrediŽnten;
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
	public List<String> getIngrediŽnten() {
		return ingrediŽnten;
	}
	public void setIngrediŽnten(List<String> ingrediŽnten) {
		this.ingrediŽnten = ingrediŽnten;
	}
	
}
