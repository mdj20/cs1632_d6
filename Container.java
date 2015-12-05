
public class Container extends Attribute {

	private boolean _contains;
	private Item _contents;
	
	// basic constructor
	Container(String name, String description) {
		super(name, description);
		_contains = false;
	}
	
	// Constructor that hides an item inside
	Container(String name, String description, Item item) {
		super(name, description);
		_contains = hide(item);
	}

	public boolean hide( Item item ){
		boolean value = false;
		if ( !_contains ){
			_contents = item;
			_contains = true;
		}
		return value;
	}
	
	public Item get(){
		
		Item value = null;
			if (_contains){
				value = _contents;
				_contains = false;
			}
		return value;
		
	}
	
	public boolean contains(){ return _contains ; }
	
}
