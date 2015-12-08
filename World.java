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
	private ArrayList< Item > _winItems;
	
	World( ArrayList<Room> world, Room start ){
		
			_world = world;
			_currentLocation = start;
			setUpRoom();
			_winItems = new ArrayList<Item>();
			_inventory = new HashSet<Item>();
			
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
					
					StringBuilder sb = new StringBuilder("You enter ");
					sb.append(_currentLocation.name());
					value = sb.toString();
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
		nonContainers.addAll( _currentChests );
		nonContainers.addAll( _currentDoors );
		nonContainers.addAll( _currentAttributes );
		nonContainers.addAll( _inventory );
		
		for (Attribute a : nonContainers){
			if(target.equalsIgnoreCase((a.name()))){
				value = a.description();
				break;
			}
		}
		
		for (Container c : _currentContainers){
			
			if (target.equalsIgnoreCase(c.name())){
			
				
				
				StringBuilder sb = new StringBuilder();
			
				sb.append(c.description());
				
				
				if (c.contains()){
					Item item = c.get();
					_inventory.add(item);
					sb.append("\nYou found a "+item.name());
				
				}
				value = sb.toString();
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
			if (target.equalsIgnoreCase(d.name())){ // if door name equals target 
				
				StringBuilder sb = new StringBuilder(); // create new stringBuilder 
				
				if(d.locked() && _inventory.contains(d.key()) ){  // unlock
					
					d.unlock(d.key());
					sb.append("You have opened the "+d.description()); // create message
						
				}
				else if(d.locked() && !_inventory.contains(d.key())){ // doesnt have the key
					
					sb.append("You dont have the correct item"); 
					
				}
				else {
					sb.append("This is already unlocked.");
				}
				
				value = sb.toString();
			}
		}
		
		// check for chest with corect name and open, put item in inventory
		for (Chest c : _currentChests){
			if (target.equalsIgnoreCase(c.name())){
				
				StringBuilder sb = new StringBuilder();
				
				if(c.locked() && _inventory.contains(c.key()) ){
					Item item = c.open(c.key());
					_inventory.add(item);
					 sb.append("You have opened the "+c.description()+"\nYou found "+item.name());	
				}
				else if(c.locked() && !_inventory.contains(c.key())){
					sb.append("You dont have the correct item");	
				}
				else {
					sb.append("This is already unlocked.");
				}		
				value = sb.toString();
			}
		}

		return value;
	}
	
	public String inventory(){
		StringBuilder sb = new StringBuilder("Inventory:\n");
		for (Item i : _inventory){
			sb.append(i.name()+"\n");
		}
		return sb.toString();
	}
	
	public int addWinRequirement(Item item){
		_winItems.add(item);
		return _winItems.size();
	}
	
	// returns true if player has all items required for winning
	public boolean canDrink(){
		return _inventory.containsAll(_winItems);
	}
	
	// drink command returns appropriate string depending on requirements 
	public String drink(){
		
		if (canDrink()){
			return "You have succeded in your quest!";
		}
		else{
			return "You do not have the correct Ingredients!";
		}
		
	}
	
	// will return a string of all the names of the attributes inthe current room
	// each on it's own line.
	public String roomAttributes(){
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.addAll(_currentAttributes);
		attributes.addAll(_currentChests);
		attributes.addAll(_currentContainers);
		
		for (Attribute a : attributes){
			sb.append(a.name()+"\n");
		}
		
		return sb.toString();
		
	}
	
	public String currentLocationName(){return _currentLocation.name();}
	public Room location(){return _currentLocation;}
	public ArrayList<Item> winItems(){ return _winItems;}
	public ArrayList<Door> doors(){ return _currentDoors;}
	public ArrayList<Chest> chests(){ return _currentChests;}
	public ArrayList<Container> containers(){ return _currentContainers;}
	public ArrayList<Attribute> attributes(){ return _currentAttributes;}
}
