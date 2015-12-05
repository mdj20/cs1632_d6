
public class Door extends Attribute {
	
	private Item _key;
	private boolean _locked;
	private Room _room0;
	private Room _room1;
	

	Door(String name, String description, Room room0, Room room1) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}
	
	//
	public Room enter(Room source){
		Room value = source;
	
		if (!_locked){
			if (source.equals(_room0)){
				value = _room1; 
			}
			else{
				value = _room0;
			}
		}
		return value;
	}
	
	public boolean lock(Item key){
		
		boolean value= false;
		
		if ( ! _locked   ){
			_key = key;
			_locked = true;
			value = true;
		}
		return value;
		
	}

	public boolean unlock(Item key){
		boolean value = false;
		
		if ( _locked == true && key.equals(_key) ){
			_locked = false;
			value = true;
		}
		
		return value;
	
	}
	
	
	
	

}
