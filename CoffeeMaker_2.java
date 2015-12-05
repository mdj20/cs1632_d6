import java.util.ArrayList;

// 

public class CoffeeMaker_2 {
	
	public static void main(String args[]){
		
		
		
		ArrayList<Item> items = new ArrayList<Item>();
		
		Item red = new Item("Red Key","Red Key");
		Item black = new Item("Black key", "Black key");
		
		Chest woodenChest = new Chest("Wooden Chest","closed","open");
		
		woodenChest.lock(black, red);
		
		System.out.println(woodenChest.locked());
		System.out.println(woodenChest.isKey(red));
		
		System.out.println(woodenChest.name());
		
		Item back = woodenChest.open(red);
		
		
		System.out.println(woodenChest.name());
		
		
		System.out.println(woodenChest.open(black));
		
		
		System.out.println(back.name());
		
		ArrayList<Attribute> test = new ArrayList<Attribute>();
		test.add(woodenChest);
		System.out.println(test.size());
		
	}
	

}
