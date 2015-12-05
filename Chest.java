
public class Chest extends Attribute {

	private Item _key;
	private Item _content;
	private String _altDescription;
	private boolean locked;
	

	Chest(String name, String description, String description2){
		
		super(name,description);
		
		_altDescription = description2;
		
	}
	
	public void lock(Item content, Item key){
		
		_content = content;
		_key = key;

	}
	
	@Override
	public String description(){
		
		String value = super._description;
		
		if (!locked){
			value = _altDescription;
		}
		
		return value;
		
	}
	

	
	public Item open(Item key){
		
		if ( locked && key.equals(_key) ){
			return _content;
		}
		else{
			return null;
		}
							
	}
	
}
