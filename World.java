import java.util.ArrayList;

public class World {

	private Room _currentLocation;
	private ArrayList< Item > _inventory;
	private ArrayList< Room > _world;
	
	private ArrayList< Door > _currentDoors;
	private ArrayList< Chest > _currentChests;
	private ArrayList< Container > _currentContainers;
	private ArrayList< Attribute > _currentAttributes;
	 
	
	World( ArrayList<Room> world, Room start ){
		
			_world = world;
			_currentLocation = start;
			setUpRoom();
			
	}
	
	// gathers _currentLocation information such as doors Item and all attributes and ready them
	private void setUpRoom(){
		
		_currentDoors = _currentLocation.doors();
		_currentChests = _currentLocation.chests();
		_currentContainers = _currentLocation.containers();
		_currentAttributes = _currentLocation.attributes();
		
	}
	
	public boolean move( Door d ){
		boolean value = false;
	
		
		
			for (Door door : _currentDoors){
			
				if( door.direction() == d ){
					
				}
					
			}
					
		return value;
	}
	
	public String look(String target){
		
	}
	
	public ArrayList<Door> doors(){ return _currentDoors;}
	public ArrayList<Chest> chests(){ return _currentChests;}
	public ArrayList<Container> containers(){ return _currentContainers;}
	public ArrayList<Attribute> attributes(){ return _currentAttributes;}
}
