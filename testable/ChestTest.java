import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ChestTest{
	//test .lock() is chest object is not locked.  Should return true
	@Test
	public void TestLockUnlocked(){
		Chest test = new Chest("test", "First Description", "Second Description");
		boolean temp = test.lock(Mockito.mock(Item.class), Mockito.mock(Item.class));
		assertTrue(temp);
	}

	//test .lock() if chest is already locked.  Should return false
	@Test
	public void TestLockLocked(){
		Chest test = new Chest("test", "First Description", "Second Description");
		test.lock(Mockito.mock(Item.class), Mockito.mock(Item.class));
		boolean temp = test.lock(Mockito.mock(Item.class), Mockito.mock(Item.class));
		assertFalse(temp);
	}

	//test description getter for locked.  Should return 1st description
	@Test
	public void TestFirstDescription(){
		Chest test = new Chest("test", "First Description", "Second Description");
		test.lock(Mockito.mock(Item.class), Mockito.mock(Item.class));
		String temp = test.description();
		assertEquals(temp, "First Description");
	}

	//test description getter for unlocked.  Should return 2nd description
	@Test
	public void TestSecondDescription(){
		Chest test = new Chest("test", "First Description", "Second Description");
		String temp = test.description();
		assertEquals(temp, "Second Description");
	}

	//test .locked() when locked.  Should return true
	@Test
	public void TestLocked(){
		Chest test = new Chest("test", "First Description", "Second Description");
		test.lock(Mockito.mock(Item.class), Mockito.mock(Item.class));
		assertTrue(test.locked());
	}

	//test .locked() when unlocked.  Should return false
	@Test
	public void TestLockedUnlocked(){
		Chest test = new Chest("test", "First Description", "Second Description");
		assertFalse(test.locked());
	}

	//test .key().  should not be null
	@Test
	public void TestKey(){
		Chest test = new Chest("test", "First Description", "Second Description");
		test.lock(Mockito.mock(Item.class), Mockito.mock(Item.class));
		assertNotNull(test.key());
	}

	//test .isKey() when not initialized.  should return false
	@Test
	public void TestIsKey(){
		Chest test = new Chest("test", "First Description", "Second Description");
		assertFalse(test.isKey(Mockito.mock(Item.class)));
	}

	//test .isKey() when initialized and equals the input. should return true
	@Test
	public void TestIsKeyEqual(){
		Chest test = new Chest("test", "First Description", "Second Description");
		Item testKey = new Item("key", "testKey");
		test.lock(Mockito.mock(Item.class), testKey);
		assertTrue(test.isKey(testKey));
	}

	//test . isKey() when initialized and not equal.  Should return False
	@Test
	public void TestIsKeyNotEqual(){
		Chest test = new Chest("test", "First Description", "Second Description");
		Item testKey = new Item("key", "testKey");
		Item notKey = new Item("notKey", "falseKey");
		test.lock(Mockito.mock(Item.class), testKey);
		assertFalse(test.isKey(notKey));
	}

	//test .open() when locked and key equals the provided key
	@Test
	public void TestOpenLockKey(){
		Chest test = new Chest("test", "First Description", "Second Description");
		Item key = new Item("key", "testKey");
		Item content = new Item ("content", "testContent");
		test.lock(content, key);
		assertEquals(content, test.open(key));
	}

	//test .open() when unlocked and correct/incorrect key provided.  Should return null
	@Test
	public void TestOpenUnlockKey(){
		Chest test = new Chest("test", "First Description", "Second Description");
		Item key = new Item("key", "testKey");
		assertNull(test.open(key));
	}

	//test .open() when locked and incorrect key.  should return Null
	@Test
	public void TestOpenLockedNotKey(){
		Chest test = new Chest("test", "First Description", "Second Description");
		Item key = new Item("key", "testKey");
		test.lock(Mockito.mock(Item.class), key);
		assertNull(test.open(new Item("notKey", "falseKey")));
	}
}
