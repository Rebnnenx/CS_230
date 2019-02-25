
public class LinkedStack<T> {
	
	private class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node <T> top;
	
	public LinkedStack() {
		top = null;
	}
	
	public void push( T data) {
		
		Node<T> newNode= new Node(data);
		
		if(isEmpty()) {
			top = newNode;
			return;
		}
		newNode.next=top;
		top = newNode;
		return;
		
	}
	
	public T pop() {
		T item=null;
		if (isEmpty()) {
			System.out.println("stack is empty");
			return item;
		}
		item = top.data;
		top= top.next;
		return item;
	}
	
	public T peek() {
		T item=null;
		if (isEmpty()) {
			System.out.println("stack is empty");
			return item;
		}
		item = top.data;
		return item;
	}
	
	public boolean isEmpty() {
		return (top==null);
	}
	
	public String toString() {
		String str = "";
		Node<T> temp = top;
		
		while (temp !=null) {
			str = str + temp.data + " ";
			temp= temp.next;
			
		}
		return str;
	}
	
	
	
}
