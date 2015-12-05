
public class Attribute {
	
	protected String _name;
	protected String _cachedDescription1;
	protected String _cachedDescription2;
	protected String _description;
	
	
	
	Attribute(String name, String description){
		this(name,description,null);
	}
	
	Attribute( String name , String description , String description2 ){
		
		_name = name;
		_cachedDescription1 = description;
		_cachedDescription2 = description2;
		
		_description = _cachedDescription1;
	}
	
	public String name(){ return _name; }
	
	public String description(){ return _description; }
	
	protected void swapDescription(){
	
		if (_cachedDescription2 !=null)
		_description = _cachedDescription2;
		
	}
	
	
	
	
	

} // end Attribute
