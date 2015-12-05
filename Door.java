
public class Door extends Attribute {
	
	private Item _key;        	// key object to lock or unlock door
	private boolean _locked;	// locked boolean value
	private Room _room0; 		// linked room
	private Room _room1;		// linked room
	private int _direction;		// direction from room0 direction
	
	public static String directions[] = {"north","south","east","west"};

	/*  Contructor argument definitions:
	 *  
	 *  name: short name
	 *  description : long description
	 *  room0 : first room
	 *  room1 : second room
	 *  direction : the direction of the door from room0's perspective
	 *   
	 */
	
	Door(String name, String description, Room room0, Room room1, int direction) {
		super(name, description);
		_room0 = room0;
		_room1 = room1;
		_direction = direction;
		_room0.add(this);
		_room1.add(this);
	}
	
	// returns the room linked to source, by the door, if locked will return source door.
	public Room enter(Room source){
		
		Room value = source;
	
		if (!_locked){
			if (source.equals(_room0)){
				value = _room1; 
			}
			else if (source.equals(_room1) ){
				value = _room0;
			}
		}
		return value;
	}
	
	// will lock door and store key, returns true if worked
	public boolean lock(Item key){
		
		boolean value= false;
		
		// if not locked already, will lock door.
		if ( ! _locked   ){
			_key = key;
			_locked = true;
			value = true;
		}
		return value;
		
	}

	// will unlock door if proper key is given returns true if door is unlocked false if door is not unlocked or is not locked to begin with
	public boolean unlock(Item key){
		
		boolean value = false;
		
		if ( _locked == true && key.equals(_key) ){
			 _locked = false;
			 value = true;
		}
		
		return value;
	
	}
	
	// Data field accessing methods 
	public boolean locked(){return _locked;}
	
	public String direction(){ return directions[_direction]; }
	

}
