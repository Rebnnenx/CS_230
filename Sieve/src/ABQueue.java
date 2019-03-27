@SuppressWarnings("unchecked")
/**
* Uses the <T> generic data type:
* Enqueue: Adds the element to the back of the queue, "push"
* Dequeue: Removes the first element from the front of the queue, or whatever has priority, "pop"
* PeekAtFront: Returns the first element in the queue without removing it
* peekAtBack: Returns the last element in the queue at the back without removing it
* toString: To display entire queue
* isEmpty/isFull
* Constructors: Basic constructors, no-arg, parameterized, copy, etc.
*/

public class ABQueue<T> {

	private int back;
	private int front;
	private T [] queue;

	public ABQueue() {
		
		back = 0;
		front = 0;
		queue = (T[]) new Object[100];
	}
	
	public ABQueue( int capacity) {
		
		back = 0;
		front = 0;
		if( capacity > 0)
			queue = (T[]) new Object[capacity];
		else
			queue = (T[]) new Object[1000];
	}

	public void enqueue( T element) {
		
		if( isFull()) {
			T[] newQueue = (T[]) new Object[queue.length+50];
			for (int i = 0; i < back; i++)
				newQueue[i] = queue[i];
			queue = newQueue;
		}

		queue[back] = element;
		back++;
		
	}
	
	public T dequeue() {
		
		T item = null;
		
		if( isEmpty()) {
			System.out.println( "Empty queue...");
			return item;
		}
		
		item = queue[front];
		for (int i = 1; i < back; i++)
			queue[i-1] = queue[i];
		back--;
		
		return item;
	}

	public T peekAtFront() {
		
		T frontItem = null;
		
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return frontItem;
		}	
			
		frontItem = queue[front];
		
		return frontItem;
	}

	public T peekAtBack() {

		T backItem = null;
		
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return backItem;
		}
		
		backItem = queue[back-1];
		
		return backItem;
	}
	
	public String toString() {
		
		String str = "[ ";
		
		if( !isEmpty())
			for( int index = 0 ; index < back ; index++ )
				str = str + queue[index] + " ";
		
		str += "]";
		
		return str;
	}

	public int size() {
		
		return( back-1);
	}
	
	public boolean isFull() {
		
		return( back == queue.length);
	}

	public boolean isEmpty() {
		
		return( back == 0);
	}
}
