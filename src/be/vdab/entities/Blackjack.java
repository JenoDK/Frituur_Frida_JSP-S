package be.vdab.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blackjack {
	private static List<String> deck = new ArrayList<String>();
	
	public Blackjack(){
		fillDeck();
		shuffleDeck();
	}
	
	public void fillDeck(){
		for (int i=0;i<=52;i++){
			deck.add(String.valueOf(i));
		}
	}
	
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
}
