import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DoorTest{
	//test .lock() when not locked.  should return true
	@Test
	public void TestLock(){
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), Mockito.mock(Room.class), 0);
		assertTrue(test.lock(Mockito.mock(Item.class)));
	}

	//test .lock() when already locked.  should return false
	@Test
	public void TestLockLocked(){
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), Mockito.mock(Room.class), 0);
		test.lock(Mockito.mock(Item.class));
		assertFalse(test.lock(Mockito.mock(Item.class)));
	}

	//test .unlock() if not locked.  Should return false
	@Test
	public void TestUnlock(){
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), Mockito.mock(Room.class), 0);
		assertFalse(test.unlock(Mockito.mock(Item.class)));
	}

	//test .unlock() if locked with proper key
	@Test
	public void TestUnlockLocked(){
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), Mockito.mock(Room.class), 0);
		Item key = new Item("testKey", "key");
		test.lock(key);
		assertTrue(test.unlock(key));
	}

	//test .locked() when locked.  Should return true
	@Test
	public void TestLocked(){
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), Mockito.mock(Room.class), 0);
		test.lock(Mockito.mock(Item.class));
		assertTrue(test.locked());
	}

	//test .locked() when unlocked.  should return false
	@Test
	public void TestLockedUnlocked(){
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), Mockito.mock(Room.class), 0);
		assertFalse(test.locked());
	}

	//test .direction() if input Room is the same as current room
	@Test
	public void TestDirectionSame(){
		Room testRoom = new Room("testRoom", "room");
		Door test = new Door("testDoor", "door", testRoom, Mockito.mock(Room.class), 0);
		assertEquals(test.direction(testRoom), 0);
	}

	//test .direction() in input is next room AND input direction is NORTH(0).  should return 1
	@Test
	public void TestDirectionNorth(){
		Room testRoom = new Room("testRoom", "room");
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), testRoom, 0);
		assertEquals(test.direction(testRoom), 1);
	}

	//test .direction() in input is next room AND input direction is SOUTH(1).  should return 0
	@Test
	public void TestDirectionSouth(){
		Room testRoom = new Room("testRoom", "room");
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), testRoom, 1);
		assertEquals(test.direction(testRoom), 0);
	}

	//test .direction() in input is next room AND input direction is EAST(2).  should return 3
	@Test
	public void TestDirectionEast(){
		Room testRoom = new Room("testRoom", "room");
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), testRoom, 2);
		assertEquals(test.direction(testRoom), 3);
	}

	//test .direction() in input is next room AND input direction is WEST(3).  should return 2
	@Test
	public void TestDirectionWest(){
		Room testRoom = new Room("testRoom", "room");
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), testRoom, 3);
		assertEquals(test.direction(testRoom), 2);
	}

	//test .enter() if locked.  should return input Room
	@Test
	public void TestEnterLocked(){
		Door test = new Door("testDoor", "door", Mockito.mock(Room.class), Mockito.mock(Room.class), 0);
		test.lock(Mockito.mock(Item.class));
		Room testRoom = new Room("testRoom", "room");
		assertEquals(test.enter(testRoom), testRoom);
	}

	//test .enter() if unlocked and input equals Room0
	@Test
	public void TestEnterUnlockedRoom0(){
		Room testRoom = new Room("testRoom", "room");
		Room testRoom2 = new Room("testRoom2", "room2");
		Door test = new Door("testDoor", "door", testRoom, testRoom2, 0);
		assertEquals(test.enter(testRoom), testRoom2);
	}

	//test .enter() if unlocked and input equals Room1
	@Test
	public void TestEnterUnlockedRoom1(){
		Room testRoom = new Room("testRoom", "room");
		Room testRoom2 = new Room("testRoom2", "room2");
		Door test = new Door("testDoor", "door", testRoom, testRoom2, 0);
		assertEquals(test.enter(testRoom2), testRoom);
	}
}
