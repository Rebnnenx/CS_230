public class DLList<T> {

	private class Node<T> {
		
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		public Node( T data) {
			
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	private int nodeCount;
	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public DLList() {
		
		this.firstNode = null;
		this.lastNode = null;
		nodeCount = 0;
	}
	
	public DLList( DLList<T> otherList) {
		
		if( !otherList.isEmpty()) {
			
			Node<T> current = otherList.firstNode;
			this.insert( current.data);
			current = current.next;
		}
	}
	
	public int size() {
		
		return nodeCount;
	}

	public void reset() {

		this.nodeCount = 0;
		this.firstNode = null;
		this.lastNode = null;

	}

	public boolean isEmpty() {
		
		return( nodeCount == 0);
	}

	public boolean insert(T element) {

		if( this.isEmpty()) 			
			insertAtFront( element);
		else
			insertAtBack( element);
		
		return true;
	}
	
	public void insertAtFront( T element) {
		
		Node<T> newNode = new Node<T>( element);
		
		if( isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		}
		else {
			
		}
		nodeCount++;
		return;
	}
	
	public void insertAtBack( T element) {
		
		Node<T> newNode = new Node<T>( element);
		
		if( isEmpty()) 
			firstNode = lastNode = newNode;
		else {
			
		}
		nodeCount++;
		return;
	}

	public boolean remove(T target) {

		if( isEmpty()) {
			System.out.println( " List is empty.");
			return false;
		}
		
		if( nodeCount == 1) {
			reset();
			return true;
		}
		
		Node<T> currentNode = firstNode;
		while( currentNode != null && !currentNode.data.equals( target))
			currentNode = currentNode.next;
		
		if( currentNode == null) {
			System.out.println( target + " not found");
			return false;
		}
		
		// if( currentNode == firstNode) {
			
		}
		
		// if( currentNode == lastNode) {
			
		}
		
		
		return true;
	}

	public T removeFromFront() {
		
		T data = firstNode.data;
		
		if( nodeCount == 1) {
			reset();
			return data;
		}
		
		//
		
		return data;
	}
	
	public T removeFromBack() {
		
		T data = lastNode.data;
		
		if( nodeCount == 1) {
			reset();
			return data;
		}
		
		// 
		
		return data;
	}
	
	public boolean contains(T target) {

		if( isEmpty()) {
			System.out.println( " List is empty.");
			return false;
		}
		
		Node<T> currentNode = firstNode;
		
		while( currentNode != null && !currentNode.data.equals( target))
			currentNode = currentNode.next;
		
		if( currentNode == null) {
			System.out.println( target + " not found");
			return false;
		}
		else
			return true;
	}
	
	public String toString() {
		
		String str = "";
		
		if( isEmpty()) {
			str = "List is empty";
			return str;
		}
		
		Node<T> current = firstNode;
		
		while( current != null) {
			str = str + current.data + " ";
			current = current.next;
		}
		return str;
	}
}
