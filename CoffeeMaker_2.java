import java.util.ArrayList;

// 

public class CoffeeMaker_2 {
	
	public static void main(String args[]){
		
		ArrayList<Room> world = new ArrayList<Room>();
		
		Room room0 = new Room("South Room","Dark room with a sign that says south");
		Room room1 = new Room("Center Room","Dimly lit room");
		Room room2 = new Room("North Room","Light room with a sign that says North");
		Room roomE = new Room("East Room","Yellow room with a sign that says East");
		Room roomW = new Room("West Room","Green room with a sign that says West");
		
		
		new Door("Yellow door","Yellow door, made of Heavy Oak",room1,room0,1);
		new Door("Green door","Green door, made of Heavy Oak",room1,room2,0);
		new Door("Red door","Red door, made of Heavy Oak",room1,roomE,2);
		new Door("Black door","Black door, made of Heavy Oak",room1,roomW,3);
		
		
		
		
	}
	

}
