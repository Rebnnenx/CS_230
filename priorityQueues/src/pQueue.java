@SuppressWarnings("hiding")

public class pQueue<T extends Comparable<T>> {

	private class Node<T> {	
		private T data;
		private Node<T> next;
		
		public Node( T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node<T> front;
	private Node<T> back;
	int nodeCount;
	
	public pQueue() {
		
		front = null;
		back = null;
		nodeCount = 0;
	}
	
	public pQueue( pQueue<T> otherQueue) {
		
		if( otherQueue.isEmpty()) {
			System.out.println( "Incoming queue is empty");
		}
		else {
			this.front = null;
			this.back = null;
			this.nodeCount = 0;
			
			T dataValue;
			Node<T> currentNode = otherQueue.front;
			while( currentNode != null) {
				dataValue = currentNode.data;
				enqueue( dataValue);
				currentNode = currentNode.next;
			}
		}
	}
	
	public void enqueue( T dataValue) {
		
		Node<T> newNode = new Node<T>( dataValue);
		
		if( isEmpty())
			front = back = newNode;
		else {
			boolean found = false;
			Node<T> currentNode = front;
			Node<T> trailCurrentNode = front;
			
			while(currentNode != null && !found) {
				if( currentNode.data.compareTo(dataValue)<0) {
					found =true;
				}else {
					trailCurrentNode=currentNode;
					currentNode=currentNode.next;
				}
			}
			
			if(currentNode ==front) {
				newNode.next = front;
				front=newNode;
			}
			else if(currentNode == null) {
				back.next=newNode;
				back=newNode;
			}
			else {
				newNode.next=currentNode;
				trailCurrentNode.next=newNode;
			}
		}
		
		nodeCount++;
		return;
	}
	
	public T dequeue() {
		
		T node = null;
		
		if( isEmpty()) {
			System.out.println( "Queue is empty.");
			return node;
		}
		
		if( front == back) {
			node = front.data;
			front = back = null;
		}
		else {
			node = front.data;
			front = front.next;
		}
		
		nodeCount--;
		return node;
	}
		
	public boolean isEmpty() {
		
		return( front == null);
	}
	
	public int size() {
		
		return nodeCount;
	}
	
	public String toString() {
		
		String str = "";
		
		if( isEmpty()) {
			str = str + "Queue is empty...";
			return str;
		}
		
		Node<T> currentNode = front;	
		while( currentNode != null) {
			str = str + currentNode.data + "  ";
			currentNode = currentNode.next;
		}
		
		return str;
	}
}
