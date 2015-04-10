package be.vdab.entities;

import java.io.Serializable;

public class Spelbord implements Serializable{
	private static final long serialVersionUID = 1L;
	private int coordX = 0;
	private int coordY = 0;
	
	public int getCoordX() {
		return coordX;
	}
	public void setCoordX(int coordX) {
		if (this.coordX + coordX <= 0){
			this.coordX = 0;
		}else if (this.coordX + coordX >= 76){
			this.coordX = 76;
		}else {
			this.coordX += coordX;
		}
		
	}
	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		if (this.coordY + coordY <= 0){
			this.coordY = 0;
		}else if (this.coordY + coordY >= 45){
			this.coordY = 45;
		}else {
			this.coordY += coordY;
		}
	}
	public boolean checkIfFinished(){
		if (coordX == 38 && coordY == 22){
			return true;
		}else {
			return false;
		}
	}
	
	
}
