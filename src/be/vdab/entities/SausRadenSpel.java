package be.vdab.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import be.vdab.dao.SausDAO;

public class SausRadenSpel implements Serializable {
	private static final long serialVersionUID = 1L;
	private final SausDAO sausdao = new SausDAO();
	private final List<Saus> sausList = (List<Saus>) sausdao.findAll();
	private final Saus teradenSaus = sausList.get(new Random().nextInt(sausList.size()));
	private final String teradenSausNaam = teradenSaus.getNaam();
	private final char teradenSausChar[] = new char[teradenSaus.getNaam().length()];
	private int fouten = 0;
	private String melding;
	private boolean checkWord = false;
	
	public SausRadenSpel() {
		for (int i=0;i<teradenSaus.getNaam().length();i++){
			teradenSausChar[i] = '.';
		}
	}
	
	public String getMelding() {
		return melding + teradenSausNaam;
	}

	public void setMelding(String melding) {
		this.melding = melding;
	}

	public String getTeradenSausNaam() {
		return teradenSausNaam;
	}


	public int getFouten() {
		return fouten;
	}

	public char[] getTeradenSausChar() {
		return teradenSausChar;
	}
	
	public boolean getCheckWord(){
		String str = String.valueOf(teradenSausChar);
		if (str.equalsIgnoreCase(teradenSausNaam)){
			checkWord = true;
		}
		return checkWord;
	}
	
	public void checkIfCharExists(char c){
		int pos = teradenSaus.getNaam().indexOf(c, 0);
		if (pos == -1){fouten++;}
	    while (pos != -1){
	    	teradenSausChar[pos] = c;
	    	pos = teradenSaus.getNaam().indexOf(c, pos+1);
	    }	    
	}
	
	
}
