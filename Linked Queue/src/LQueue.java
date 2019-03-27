public class LQueue<T> {

	private Node<T> front;
	private Node<T> back;
	private int nodeCount;
	
	private class Node<T> {	
		private T data;
		private Node<T> next;
		
		public Node( T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public LQueue() {
		
		front = null;
		back = null;
		nodeCount=0;
	}
	
	public LQueue( LQueue<T> otherQueue) {
		
		if( otherQueue.isEmpty()) {
			System.out.println( "Incoming queue is empty");
		}
		else {
			this.front = null;
			this.back = null;			
			T dataValue;
			Node<T> currentNode = otherQueue.front;
			
			while(currentNode != null) {
				dataValue = currentNode.data;
				this.enqueue(dataValue);
				currentNode= currentNode.next;
			}
			
		}
	}
	
	public void enqueue( T dataValue) {
		
		Node<T> newNode = new Node<T>( dataValue);
		
		if( isEmpty()) {
			front= newNode;
		}else {
			back.next=newNode;
		}
		back=newNode;
		nodeCount++;
		
		return;
	}
	
	public T dequeue() {
		
		T item = null;
		if (!isEmpty()) {
			if (nodeCount == 1) {
				item =front.data;
				reset();
			}else {
				item =front.data;
				front=front.next;
				nodeCount--;
			}
			
		}else
			System.out.println("queue is empty.");
		
		
		return item;
	}
	
	public T peekAtFront() {
		
		T dataValue = null;
		
		if( isEmpty())
			System.out.println( "Queue is empty.");
		else
			dataValue = front.data;
					
		return dataValue;
	}
	
	public T peekAtBack() {
		
		T dataValue = null;
		
		if( isEmpty())
			System.out.println( "Queue is empty.");
		else
			dataValue = back.data;
		
		return dataValue;
	}

	public boolean isEmpty() {
		
		return(nodeCount ==0 );
	}
	
	public int size() {

		int nodeCount = 0;

		return nodeCount;
	}
	
	public void reset() {
		
		this.front = null;
		this.back = null;
		this.nodeCount = 0;
		
		return;
	}

	public String toString() {
		
		String str = "[";
		
		if( isEmpty()) {
			str = str + "Queue is empty...";
			return str;
		}
		
		Node<T> currentNode = front;	
		while(currentNode != null) {
			str = str+currentNode.data+" ";
			currentNode=currentNode.next;
		}
		str=str+"]";
		return str;
	}
	
	
	
	
	
	
	
	
}
