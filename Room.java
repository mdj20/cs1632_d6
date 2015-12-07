import java.util.ArrayList;


public class Room extends Attribute {

	private String _name;
	private String _description;
	private ArrayList< Attribute > _attributes;
	private ArrayList< Chest > _chests;
	private ArrayList< Container > _containers;
	private ArrayList< Door > _doors;
	
	Room( String name , String description ){
		
		super(name,description);
		_attributes= new ArrayList< Attribute >();
		_chests= new ArrayList< Chest > ();
		_containers= new ArrayList< Container >(); 
		_doors= new ArrayList< Door > ();
		
	}
	
	/*
	 *  following methods add objects to room;
	 */
	
	public void add(Attribute a){
		_attributes.add(a);
	}
	public void add(Chest chest){
		_chests.add(chest);
	}
	public void add(Container c){
		_containers.add(c);
	}
	public void add(Door door){
		_doors.add(door);
	}
	
	public ArrayList<Attribute> attributes(){
		return _attributes;
	}
	public ArrayList<Chest> chests(){
		return _chests;
	}
	
	public ArrayList<Container> containers(){
		return _containers;
	}
	public ArrayList<Door> doors(){
		return _doors;
	}
	
	
}
