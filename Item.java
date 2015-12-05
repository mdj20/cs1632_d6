
public class Item {

	private String _name;
	private String _description;
	
	Item( String name, String description ){
		_name = name;
		_description = description;
	}
	
	public String name(){ return _name;}
	
	public String description(){ return _description;}
	
}
