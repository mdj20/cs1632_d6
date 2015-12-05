
public class Chest extends Attribute {

	private Item _key;
	private Item _content;
	private String _altDescription;
	private boolean _locked;
	
	Chest(String name, String description, String description2){
		
		super(name,description);
		_altDescription = description2;
		
	}
	
	public boolean lock(Item content, Item key){
		
		boolean value = false;
		
		if (!_locked){
			_content = content;
			_key = key;
			_locked = true;
			value = true;
		}
		
		return value;
	}
	
	@Override
	public String description(){
		
		String value = super._description;
		
		if (!_locked){
			value = _altDescription;
		}
		
		return value;
		
	}

	
	public Item open(Item key){
		
		if ( _locked && key.equals(_key) ){
			return _content;
		}
		else{
			return null;
		}
							
	}
	
	public boolean locked(){ return _locked ; }
	
	public Item key(){ return _key; }
	
	public boolean isKey(Item key){ 
		
		// check that _key is initialized
		if (_key != null){
		return key.equals(_key); 
		}
		else {
			return false;  // if _key is null return false
		}
		
	}
}
