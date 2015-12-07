import java.util.ArrayList;
import java.util.Scanner;

// 

public class CoffeeMaker_2 {
	
	public static void main(String args[]){
		
		ArrayList<Room> list = new ArrayList<Room>();
		
		Room room0 = new Room("South Room","Dark room with a sign that says south");
		Room room1 = new Room("Center Room","Dimly lit room");
		Room room2 = new Room("North Room","Light room with a sign that says North");
		Room roomE = new Room("East Room","Yellow room with a sign that says East");
		Room roomW = new Room("West Room","Green room with a sign that says West");
		
		
		Door lockedDoor = new Door("Yellow door","Yellow door, made of Heavy Oak",room1,room0,1);
		new Door("Green door","Green door, made of Heavy Oak",room1,room2,0);
		new Door("Red door","Red door, made of Heavy Oak",room1,roomE,2);
		new Door("Black door","Black door, made of Heavy Oak",room1,roomW,3);
		
		list.add(room0);
		list.add(room1);
		list.add(room2);
		list.add(roomE);
		list.add(roomW);
		
		Item key = new Item("red key","red key");
		Container pot = new Container("pot","small but deep brown pot");
		pot.hide(key);
		room1.add(pot);
		lockedDoor.lock(key);
		
		Chest chest = new Chest("Metal Chest","Locked Metal Chest","Metal Chest Unlocked");
		Item coffee = new Item("Coffee","Craffe of steaming black coffee");
		
		chest.lock(coffee, key);
		
		World world = new World(list, room1);
		
		room2.add(chest);
		
		System.out.println(world.move(1));
		System.out.println(world.look("pot"));
		System.out.println();
		System.out.println(world.open("Yellow door"));
		System.out.println(world.move(0));
		
	
		
		System.out.println(world.inventory());
		
		System.out.println(world.open("Metal Chest"));
		
		Scanner scanner = new Scanner(System.in);
	
		
		
	}
	

}
