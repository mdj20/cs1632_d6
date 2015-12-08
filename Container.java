
public class Container extends Attribute {
	
	/*
	 * a container is an attribute that can hold an item
	 */

	private boolean _contains;	// boolean stating that it contains something
	private Item _contents;		// item that it may contain
	
	// basic constructor
	Container(String name, String description) {
		super(name, description);
		_contains = false;
	}
	
	// Constructor that hides an item inside
	Container(String name, String description, Item item) {
		super(name, description);
		_contains = false;
		_contains = hide(item);
	}

	// hides item and sets boolean to true
	public boolean hide( Item item ){
		boolean value = false;
		if ( !_contains ){
			_contents = item;
			_contains = true;
			value = true;
		}
		return value;
	}
	
	// returns item and sets boolean to false
	public Item get(){
		
		Item value = null;
			if (_contains){
				value = _contents;
				_contains = false;
			}
		return value;
		
	}
	// data access
	public boolean contains(){ return _contains ; }
	
}
