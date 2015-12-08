import java.util.ArrayList;
import java.util.Scanner;

// driver program simply loads data and launches game

public class CoffeeMaker_2 {
	
	public static void main(String args[]){
		
		Hero hero = new Hero(DataBuilder.getWorld());  // load data
		hero.start(); // start game
		
		
	}
	

}
