import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class RoomTest{
	//test adding and getting _attributes
	@Test
	public void TestAttribute(){
		Room test = new Room("testRoom", "room1");
		test.add(Mockito.mock(Attribute.class));
		assertTrue(test.attributes().size() > 0);
	}

	//test adding and getting _chests
	@Test
	public void TestChests(){
		Room test = new Room("testRoom", "room1");
		test.add(Mockito.mock(Chest.class));
		assertTrue(test.chests().size() > 0);
	}

	//test adding and getting _containers
	@Test
	public void TestContainers(){
		Room test = new Room("testRoom", "room1");
		test.add(Mockito.mock(Container.class));
		assertTrue(test.containers().size() > 0);
	}

	//test adding and getting _doors
	@Test
	public void TestDoors(){
		Room test = new Room("testRoom", "room1");
		test.add(Mockito.mock(Door.class));
		assertTrue(test.doors().size() > 0);
	}
}
