import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class WorldTest {
	static World world ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		world = DataBuilder.getWorld();
		world.look("bowl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	
	@Test
	public void testMoveSuccess() {
  
		// tests that a move() call works correctly 
		
		String expected = "You enter South Room";
		String actual = world.move(1);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLook() {
		
		// tests for a proper failed move call
		
		String expected = "Dimly lit room";
		String actual = world.look();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testLookItem(){
		
		System.out.print(world.look("bowl"));
		String expected = "Ceramic Bowl";
		String actual = world.look("bowl");
		assertEquals(expected,actual);
	}
	
	@Test
	public void testInv(){  // tests the printing of the inventory
		System.out.print(world.inventory());
		String expected = "Inventory:\nblue key\n";
		String actual = world.inventory();
		assertEquals(expected,actual);
	}
	
	@Test
	public void testCanDrinkfail(){   // tests can drink in a failure scenario 
		assertTrue(!world.canDrink());
		
	}
	
	@Test
	public void testCanDrinkPass(){
		
		World testWorld = new World(new ArrayList<Room>(),new Room("Mock","Mock"));
		
		Item coffee = new Item("coffee","Black coffee");
		Item sugar = new Item("sugar","Natural Sugar");
		Item cream = new Item("cream","Cream (tastes better than milk)");
		
		// adds to inventory
		HashSet<Item> inv = testWorld.getInventorySet();
		inv.add(coffee);
		inv.add(cream);
		inv.add(sugar);

		// add win requirements 
		testWorld.addWinRequirement(coffee);
		testWorld.addWinRequirement(cream);
		testWorld.addWinRequirement(sugar);
		
		
		assertTrue(testWorld.canDrink());
		
	}
	
	@Test
	public void testAddWinRequirement(){
	
		assertTrue(4==world.addWinRequirement(new Item("Mock","MOCK")));
	}
	
	@Test
	public void testDrink(){
		
		// must create new world to test
		World testWorld = new World(new ArrayList<Room>(),new Room("Mock","Mock"));
		
		// add win items
		Item coffee = new Item("coffee","Black coffee");
		Item sugar = new Item("sugar","Natural Sugar");
		Item cream = new Item("cream","Cream (tastes better than milk)");
		
		// add items to inv
		HashSet<Item> inv = testWorld.getInventorySet();
		inv.add(coffee);
		inv.add(cream);
		inv.add(sugar);

		// add items to win requirement set
		testWorld.addWinRequirement(coffee);
		testWorld.addWinRequirement(cream);
		testWorld.addWinRequirement(sugar);
		
		// expected
		String expected = "You have succeded in your quest!";
		
		// test
		assertEquals(expected,testWorld.drink());
		
	}
	
	@Test
	public void testOpen(){
		
		// tests the opening of a chest

		Room room = new Room("Mock","Mock");
		
		// creates test world 
		World testWorld = new World(new ArrayList<Room>(),room);
		
		// sets up chest
		Item key = new Item("KEY","KEY");
		Item item = new Item("item","item");
		Chest chest = new Chest("chest","chest","chest");
		chest.lock(item, key);
		room.add(chest);
		
		// adds key to inv
		HashSet<Item> inv = testWorld.getInventorySet();
		inv.add(key);

		// test for correct open string
		String actual = testWorld.open("chest");
		String expected = "You have opened the chest\nYou found item";
		assertEquals(expected,actual);
		
	}

}
