
public class Chest extends Attribute {

	private Item _key;
	private Item _content;
	boolean locked;
	

	Chest(String name, String description, String description2){
		
		super(name,description,description2);
		locked = false;
		
	}
	
	public void lock(Item content, Item key){
		
		_content = content;
		_key = key;
		locked = true;
		
	}
	
	
	public Item open(Item key){
		
		Item value = key;
		
		if ( locked == true && key.equals(_key) ){
						
					swapDescription();
					value = _content;
					
		}
		
		return value;
					
	}
	
}
