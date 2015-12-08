import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ContainerTest{
	//test .hide() when empty (_contains = false).  should return true
	@Test
	public void TestHideContainsTrue(){
		Container test = new Container("test", "container");
		assertTrue(test.hide(Mockito.mock(Item.class)));
	}

	//test .hide() when not empty (_contains = true).  should return false
	@Test
	public void TestHideContainsFalse(){
		Container test = new Container("test", "container");
		test.hide(Mockito.mock(Item.class));
		assertFalse(test.hide(Mockito.mock(Item.class)));
	}

	//test .get() when not empty (_contains = true).  should not be null
	@Test
	public void TestGetContainsTrue(){
		Container test = new Container("test", "container");
		test.hide(Mockito.mock(Item.class));
		assertNotNull(test.get());
	}

	//test .get() when empty (_contains = false).  should return null
	@Test
	public void TestGetContainsFalse(){
		Container test = new Container("test", "container");
		assertNull(test.get());
	}

	//test .contains() if not empty (_contains = true).  should retrun true
	@Test
	public void TestContainsTrue(){
		Container test = new Container("test", "container");
		test.hide(Mockito.mock(Item.class));
		assertTrue(test.contains());
	}

	//test .contains() if empty (_contains = false).  should return false
	@Test
	public void TestContainsFalse(){
		Container test = new Container("test", "container");
		assertFalse(test.contains());
	}
}
