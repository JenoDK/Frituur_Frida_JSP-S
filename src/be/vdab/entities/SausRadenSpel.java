package be.vdab.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class SausRadenSpel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Saus teradenSaus;
	private String teradenSausNaam;
	private String teradenSausInPoints;
	private char[] teradenSausChar;
	private int fouten = 0;	
	private boolean geraden = false;
	
	public SausRadenSpel(List<Saus> sausList) {
		teradenSaus = sausList.get(new Random().nextInt(sausList.size()));
		teradenSausNaam = teradenSaus.getNaam();
		teradenSausInPoints = teradenSausNaam.replaceAll("(?s).", ".");
		teradenSausChar = teradenSausInPoints.toCharArray();
	}
	
	
	public String getTeradenSausNaam() {
		if (checkIfWordHasBeenFound()){
			return "U bent gewonnen, de saus was: "+teradenSausNaam;
		}else {
			return "U bent verloren, de saus was: "+teradenSausNaam;
		}
		
	}
	
	public boolean getGeraden() {
		return geraden;
	}


	public int getFouten() {
		return fouten;
	}

	public char[] getTeradenSausChar() {
		return teradenSausChar;
	}
	
	public boolean checkIfWordHasBeenFound(){		
		String str = String.valueOf(teradenSausChar);
		if (str.equals(teradenSausNaam)){
			geraden = true;
			return true;
		}else {
			return false;
		}
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

