import java.util.ArrayList;
import java.util.HashSet;

public class World {

	private Room _currentLocation;
	private HashSet< Item > _inventory;
	private ArrayList< Room > _world;
	
	private ArrayList< Door > _currentDoors;
	private ArrayList< Chest > _currentChests;
	private ArrayList< Container > _currentContainers;
	private ArrayList< Attribute > _currentAttributes;
	
	private StringBuilder _sb;
	 
	
	World( ArrayList<Room> world, Room start ){
		
			_world = world;
			_currentLocation = start;
			setUpRoom();
			_inventory = new HashSet<Item>();
			_sb = new StringBuilder();
			
	}
	
	// gathers _currentLocation information such as doors Item and all attributes and ready them
	private void setUpRoom(){
		
		_currentDoors = _currentLocation.doors();
		_currentChests = _currentLocation.chests();
		_currentContainers = _currentLocation.containers();
		_currentAttributes = _currentLocation.attributes();
		
	}
	
	// attmpts to move in the direction passed in.
	public String move( int d ){
		
		String value = "You can't go there";
		
		
			// checks if door in that direction exists
			for (Door door : _currentDoors){
				
				// if door is found, create response string for value
				if( door.direction(_currentLocation) == d ){
					_currentLocation = door.enter(_currentLocation);
					setUpRoom();
					
					_sb = new StringBuilder();
					_sb.append("You enter ");
					_sb.append(_currentLocation.name());
					value = _sb.toString();
					break; // break for
				}
					
			}
					
		return value;
	}
	
	// returns string of name of item passed through
	public String look(String target){
		
		String value = "You can't look at that.";
		
		
		// search for target match
		ArrayList<Attribute> nonContainers = new ArrayList<Attribute>();
		nonContainers.addAll(_currentChests);
		nonContainers.addAll(_currentDoors);
		nonContainers.addAll(_currentAttributes);
		nonContainers.addAll(_inventory);
		
		for (Attribute a : nonContainers){
			if(target.equals(a.name())){
				value = a.description();
				break;
			}
		}
		
		for (Container c : _currentContainers){
			
			if (target.equals(c.name())){
				
				_sb = new StringBuilder();
			
				_sb.append(c.description());
				
				if (c.contains()){
					Item item = c.get();
					_inventory.add(item);
					_sb.append("\nYou found a"+item.name());
					value = _sb.toString();
				}
				break;
			}
		}
		return value;
	}
	
	public String look(){return _currentLocation.description();}
	
	public String open(String target){
		// default response
		String value = "You can't do that.";
		
		// Check if door is target, and see if unlock is applicable
		for (Door d : _currentDoors){
			if (target.equals(d.name())){ // if door name equals target 
				
				_sb = new StringBuilder(); // create new stringBuilder 
				
				if(d.locked() && _inventory.contains(d.key()) ){  // unlock
					
					d.unlock(d.key());
					_sb.append("You have opened the "+d.description()); // create message
						
				}
				else if(d.locked() && !_inventory.contains(d.key())){ // doesnt have the key
					
					_sb.append("You dont have the correct item"); 
					
				}
				else {
					_sb.append("This is already unlocked.");
				}
				
			}
		}
		
		// check for chest with corect name and open, put item in inventory
		for (Chest c : _currentChests){
			if (target.equals(c.name())){
				
				_sb = new StringBuilder();
				
				if(c.locked() && _inventory.contains(c.key()) ){
					Item item = c.open(c.key());
					_inventory.add(item);
					_sb.append("You have opened the "+c.description()+"\n You found "+item.name());	
				}
				else if(c.locked() && !_inventory.contains(c.key())){
					_sb.append("You dont have the correct item");	
				}
				else {
					_sb.append("This is already unlocked.");
				}		
			}
		}
		value = _sb.toString();
		return value;
	}
	
	
	
	public ArrayList<Door> doors(){ return _currentDoors;}
	public ArrayList<Chest> chests(){ return _currentChests;}
	public ArrayList<Container> containers(){ return _currentContainers;}
	public ArrayList<Attribute> attributes(){ return _currentAttributes;}
}
