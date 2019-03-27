@SuppressWarnings("unchecked")

public class ABList<T> {

	private T [] list;
	private int location;
	private boolean found;
	private int itemsCount;
	private final int DEFAULTCAP = 20;
	
	public ABList() {
		
		location = 0;
		found = false;
		itemsCount = 0;
		list = (T[]) new Object[DEFAULTCAP];
	}

	public ABList( int capacity) {
		
		location = 0;
		found = false;
		itemsCount = 0;
		
		if( capacity > 0)
			list = (T[]) new Object[capacity];
		else {
			System.out.println( "Invalid capacity given. The default capacity is being used instead.");
			list = (T[]) new Object[DEFAULTCAP];
		}
	}

	private void find( T target) {
		
		location = 0;
		found = false;
		
		while( location < itemsCount) {
			if( list[location].equals( target)) {
				found = true;
				return;
			}
			else
				location++;
		}
		
		return;
	}

	public int size() {
		
		return itemsCount;
	}

	public boolean isFull() {
		
		return( itemsCount == list.length);
	}

	public boolean isEmpty() {
		
		return( itemsCount == 0);
	}
	
	public int indexOf( T element) {
		
		find( element);
		
		if( found)
			return location;
		else
			return -1;
	}

	public boolean contains( T element) {
		
		find( element);
		
		if( found)
			return true;
		else
			return false;
	}

	public void reset() {
		
		location = 0;
		found = false;
		itemsCount = 0;
		list = (T[]) new Object[DEFAULTCAP];
		return;
	}
	
	public void set( T element, int index) {
		
		if( index >= 0 && index <= itemsCount) {
			list[index] = element;
		}
		else
			System.out.println( "Invalid index.");
		
		return;
	}
	
	public T get( int index) {
		
		if( isEmpty()) {
			System.out.println( "List is empty.");
			return null;
		}
		
		if( index < 0 || index >= itemsCount) {
			System.out.println( "Invalid index.");
			return null;
		}
		
		return list[index];
	}

	public boolean insert( T element) {
		
		if( isFull()) {
			System.out.println( "List is full.");
			return false;
		}
		
		list[itemsCount] = element;
		itemsCount++;
		return true;
	}

	public void insert( T element, int index) {
		
		if( isFull()) {
			System.out.println( "List is full.");
			return;
		}
		
		if( index < 0) {
			System.out.println( "Invalid index.");
			return;
		}
		
		
		
		return;
	}

	public void remove( int index) {
		
		if( isEmpty()) {
			System.out.println( "List is empty.");
			return;
		}
		
		if( index < 0 || index >= itemsCount) {
			System.out.println( "Invalid index.");
			return;
		}
		
		for( int i = index ; i < itemsCount-1 ; i++) 
			list[i] = list[i+1];
	
		itemsCount--;
		return;

	}

	public boolean remove( T element) {
		
		if( isEmpty()) {
			System.out.println( "List is empty.");
			return false;
		}
		
		find( element);
		
		if( found)
			for( int i = location ; i < itemsCount-1 ; i++) 
				list[i] = list[i+1];
		
		itemsCount--;
		
		return true;
	}

	public String toString() {
		
		String str = "[";
		
		for( int index = 0 ; index < itemsCount ; index++ )
			str = str + list[index] + " ";
		str += "]";
		
		return str;
	}

}
