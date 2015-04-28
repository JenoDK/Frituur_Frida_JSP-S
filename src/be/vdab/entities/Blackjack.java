package be.vdab.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Blackjack {
	private static List<String> deck;
	private static List<String> cardsInHand;
	private static int value;
	
	public Blackjack(){
		deck = new ArrayList<String>();
		cardsInHand = new ArrayList<String>();
		value = 0;
		fillDeck();
		shuffleDeck();
	}
	
	public void fillDeck(){
		for (int i=1;i<=52;i++){
			deck.add(String.valueOf(i));
		}
	}
	
	public List<String> getDeck(){
		return deck;
	}
	
	public void shuffleDeck(){
		Collections.shuffle(deck);
	}
	
	public void newCard(){
		Random rand = new Random();
		int randomNum = rand.nextInt((deck.size()));
		String a = deck.get(randomNum);
		deck.remove(randomNum);
		cardsInHand.add(a);
		value += realValueOf(a);
	}
	
	public boolean isAce(String a){
		return (a.equals("1")||a.equals("2")||a.equals("3")||a.equals("4"));
	}
	
	public List<String> getCardsInHand() {
		return cardsInHand;
	}
	
	public void setValue(int a){
		value += a;
	}
	
	public int getValue(){		
		return value;
	}
	
	public int getValueOfHand(){
		int sum = 0;
		for (String a : cardsInHand){
			sum += realValueOf(a);
		}
		return sum;
	}
	
	public int realValueOf(String a){
		int b = Integer.parseInt(a);
		if (b>=1 && b<=4){
			return 1;
		}else if (b>=5 && b<=16){
			return 10;
		}else if (b>=17 && b<=20){
			return 10;
		}else if (b>=21 && b<=24){
			return 9;
		}else if (b>=25 && b<=28){
			return 8;
		}else if (b>=29 && b<=32){
			return 7;
		}else if (b>=33 && b<=36){
			return 6;
		}else if (b>=37 && b<=40){
			return 5;
		}else if (b>=41 && b<=44){
			return 4;
		}else if (b>=45 && b<=48){
			return 3;
		}else if (b>=49 && b<=52){
			return 2;
		}else {
			return 0;
		}
	}
}
