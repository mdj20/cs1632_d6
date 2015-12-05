import java.util.ArrayList;


public class Room {

	String _name;
	String _description;
	ArrayList< Attribute > _attributes;
	ArrayList< Chest > _chests;
	
	Room( String name , String description ){
		
		_name = name;
		_description = description;
		
	}
	
	public void addExit(){
		
	}
	
//	public Attribute removeAttribute( Attribute a ){
		
		//if ( _attribute != null &&   )
		
		
		
		
		
	//}
	
	
	
	public void addAttribute( Attribute a){
		
		if ( _attributes == null)
			 _attributes = new ArrayList<Attribute>();
		 
		_attributes.add(a);
		
	}
	
	
	
	
	
	
	
	
	
}
