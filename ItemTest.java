import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ItemTest{
	//test Item.class inherits .name() from Attribute.class
	@Test
	public void TestName(){
		Item test = new Item("name", "description");
		assertEquals("name", test.name());
	}

	//test Item.class inherits .description() from Attribute.class
	@Test
	public void TestDescription(){
		Item test = new Item("name", "description");
		assertEquals("description", test.description());
	}
}
