
public class Attribute {
	
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
