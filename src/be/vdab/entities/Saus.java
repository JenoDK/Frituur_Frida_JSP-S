package be.vdab.entities;

import java.util.List;

public class Saus {
	private long nummer;
	private String naam;
	private List<String> ingredi�nten;
	
	public Saus(long nummer, String naam, List<String> ingredi�nten) {		
		this.nummer = nummer;
		this.naam = naam;
		this.ingredi�nten = ingredi�nten;
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
	public List<String> getIngredi�nten() {
		return ingredi�nten;
	}
	public void setIngredi�nten(List<String> ingredi�nten) {
		this.ingredi�nten = ingredi�nten;
	}
	
}