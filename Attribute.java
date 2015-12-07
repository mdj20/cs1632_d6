
public class Attribute {
	
	/*
	 *  Base class for the rest of the building blocks of the game
	 *  
	 *  any Attribute has a name: a short description and the id of attribute
	 *  					description: a more in depth description
	 */
	
	
	protected String _name;
	protected String _description;

	Attribute( String name , String description){
		
		_name = name;
		_description = description;
		
	}
	
	// data field access methods 
	public String name(){ return _name; }
	
	public String description(){ return _description; }
	

} // end Attribute
