
public class Door extends Attribute {
	
	/*
	 * attribute that links rooms 
	 * provides methods for locking and unlocking with specific item
	 * 
	 * 
	 */
	
	private Item _key;        	// key object to lock or unlock door
	private boolean _locked;	// locked boolean value
	private Room _room0; 		// linked room
	private Room _room1;		// linked room
	private int _direction;		// direction from room0 direction
	
	private final static int NORTH = 0 ; 
	private	final static int SOUTH = 1 ;
	private final static int EAST  = 2 ;
	private final static int WEST = 4 ;
	private final static int INVALID = -1;
	
	public static String directions[] = {"north","south","east","west"}; // standard strings for direction

	/*  Contructor argument definitions:
	 *  
	 *  name: short name
	 *  description : long description
	 *  room0 : first room
	 *  room1 : second room
	 *  direction : the direction of the door from room0's perspective
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
	
	// returns the direction code that this door will represent, for the room passed in.
	public int direction(Room in){
	
		int value = INVALID;
		
		// if room passed in is the room that _direction represents, then simply pass back the representation
		if (in.equals(_room0)){
			value = _direction;
		}
		// if the room is the opposite room, then return the opposite direction (If north then return south etc.)
		else if (in.equals(_room1)){
			
			switch (_direction){
				case NORTH: value = SOUTH;
					break;
				case SOUTH: value = NORTH;
					break;
				case EAST : value = WEST;
					break;
				case WEST: value = EAST;
			}
		}
		
		return value ;
	
	}
	

	

}
