
public class Chest extends Attribute {

	private Item _key;	// item required to unlock
	private Item _content; // item stored
	private String _altDescription; // description that is given after chestis opened
	private boolean _locked; // locked booelan 
	
	Chest(String name, String description, String description2){
		super(name,description);
		_altDescription = description2;
		
	}
	
	// stores item, and sets boolean _contains to true
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
	
	
	// This method will return one of the descriptions, 
	// the primary description when it is locked and alternate after it is opened
	
	@Override   
	public String description(){
		
		String value = super._description;
		
		if (!_locked){
			value = _altDescription;
		}
		
		return value;
		
	}

	// will take item (key) and return stored Item. flips booelan to false
	public Item open(Item key){
		
		if ( _locked && key.equals(_key) ){
			return _content;
		}
		else{
			return null;
		}
							
	}
	
	public boolean locked(){ return _locked ; }  // data access
	public Item key(){ return _key; } // data access
	
	// checks weather the item provided is key
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
