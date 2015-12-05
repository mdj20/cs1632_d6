
public class Attribute {
	
	protected String _name;
	protected String _cachedDescription1;
	protected String _description;

	
	Attribute(String name, String description){
		this(name,description,null);

	}
	
	Attribute( String name , String description , String description2 ){
		
		_name = name;
		_cachedDescription1 = description;
		
		_description = _cachedDescription1;
	}
	
	// data field access methods 
	public String name(){ return _name; }
	
	public String description(){ return _description; }
	

} // end Attribute
