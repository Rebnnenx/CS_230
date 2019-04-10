@SuppressWarnings("hiding")

public class LinkedList<T extends Comparable<T>> {

	private class Node<T extends Comparable<T>> {
		
		private T data;
		private Node<T> next;
		
		public Node( T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node<T> firstNode;
	private Node<T> lastNode;
	private Node<T> targetNode;
	private Node<T> trailTargetNode;
	private boolean found;
	
	private void find( T target) {
		
		targetNode = firstNode;
		trailTargetNode = firstNode;
		found = false;
		while(targetNode != null && !targetNode.data.equals(target)) {
			trailTargetNode=targetNode;
			targetNode=targetNode.next;
		}
		if(targetNode!=null) {
			found = true;
		}
		
		
		return;
	}
	
	public LinkedList() {
		
		firstNode = lastNode = null;
	}
	
	public LinkedList( LinkedList<T> otherList) {
		
		if( !otherList.isEmpty()) {
			this.reset();
			
			T dataValue;
			Node<T> currentNode = otherList.firstNode;
			while( currentNode != null) {
				dataValue = currentNode.data;
				this.insertAtBack( dataValue);
				currentNode = currentNode.next;
			}
		}
	}
	
	public int size() {

		int nodeCount = 0;
		Node<T> currentNode = firstNode;
		
		if( isEmpty()) 
			return nodeCount;
		
		while( currentNode != null) {
			nodeCount++;
			currentNode = currentNode.next;
		}
		
		return nodeCount;
	}

	public void reset() {

		firstNode = lastNode = null;
		return;
	}

	public boolean isEmpty() {
		
		return( firstNode == null);
	}

	public void insertAtBack( T element) {
		
		Node<T> newNode = new Node<T>( element);
		
		if( this.isEmpty()) {
			firstNode = lastNode = newNode;
			return;
		}
		lastNode.next=newNode;
		lastNode=newNode;
		
		return;
	}
	
	public void insertAtFront( T element) {
		
		Node<T> newNode = new Node<T>( element);
		
		if( this.isEmpty()) {
			firstNode = lastNode = newNode;
			return;
		}
		newNode.next=firstNode;
		firstNode=newNode;
		
		
		return;
	}

	public T removeFromFront() {
		
		T data = null;
		
		if( isEmpty()) {
			System.out.println( "List is empty...");
			return data;
		}
		data = firstNode.data;
		if(firstNode==lastNode) 
			firstNode=lastNode=null;
		else
			firstNode=firstNode.next;
		
		return data;
	}
	
	public T removeFromBack() {
		
		T data = null;
		
		if( isEmpty()) {
			System.out.println( "List is empty...");
			return data;
		}
		data = lastNode.data;
		if(firstNode==lastNode) { 
			firstNode=lastNode=null;
			return data;
		}
		
		Node<T> currentNode=firstNode;
		while(currentNode.next != lastNode)
			currentNode=currentNode.next;
		lastNode=currentNode;
		lastNode.next=null;
		return data;
	}
	
	public void remove( T target) {
		
		find( target);
		
		if( !found)
			return;
		
		if(firstNode==targetNode) {
			removeFromFront();
			return;
		}
		if(targetNode==lastNode) {
			removeFromBack();
			return;
		}
		trailTargetNode.next=targetNode.next;
		targetNode=null;
		return;
	}

	public boolean contains( T target) {
		
		find( target);
		return found;
	}
	
	public String toString() {
		
		String str = "";
		
		if( isEmpty()) {
			str = "List is empty";
			return str;
		}
		
		Node<T> currentNode = firstNode;
		while( currentNode != null) {
			str = str + currentNode.data + " ";
			currentNode = currentNode.next;
		}
		
		return str;
	}
	
	public void reverse(){
		
		reverseThisList(firstNode);
		return;
	}
	
	private void reverseThisList(Node<T> currentNode) {
		
		if (currentNode == null)
			return;
		
		if(currentNode==this.lastNode) {
			this.lastNode=this.firstNode;
			this.firstNode=currentNode;
			return;
		}
		
		reverseThisList(currentNode.next);
		currentNode.next.next =currentNode;
		currentNode.next = null;
		return;
	}
	
	
	
	
}
