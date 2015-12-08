import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AttributeTest{
	//test .name()
	@Test
	public void TestName(){
		Attribute test = new Attribute("name", "description");
		assertEquals("name", test.name());
	}

	//test .description()
	@Test
	public void TestDescription(){
		Attribute test = new Attribute("name", "description");
		assertEquals("description", test.description());
	}
}
