/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskbilletautomat;

/**
 *
 * @author Adam Aron Edelsten
 */
import java.awt.Image;
import java.awt.Toolkit;

public class Coin {

	private Image TheImage;

	private int sizeOfCoins = 50;
	private int centerOfCoins = sizeOfCoins / 2;
	
	private double coinValue = 0;

	private int xPos = 0;
	private int yPos = 0;

	
	public Coin(double value, String NameOfPicture) {

		coinValue = value;
		TheImage = Toolkit.getDefaultToolkit().getImage(NameOfPicture);

	}
	
	
	public Coin(int x, int y,int coinSize, double value,String NameOfPicture) {

		xPos = x;
		yPos = y;
		sizeOfCoins = coinSize;
		coinValue = value;
		TheImage = Toolkit.getDefaultToolkit().getImage(NameOfPicture);

	}


	public Image getImage() {

		return TheImage;
	}

	public void setXpos(int x) {
		xPos = x;
	}

	public void setYpos(int y) {
		yPos = y;
	}

	public int getXpos() {
		return xPos;
	}

	public int getYpos() {
		return yPos;
	}

	public void setValue(double value) {
		coinValue = value;
	}

	public double getValue() {
		return coinValue;
	}
	
	public int getSize() {
		return sizeOfCoins;
	}
	
	public int getCenter(){
		return centerOfCoins;
	}
	

	//return value
}
