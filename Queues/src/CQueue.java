@SuppressWarnings("unchecked")
public class CQueue<T> {
	
	private int back;
	private int size;
	private int front;
	private T [] queue;
	
	
	
	public CQueue() {
		
		back = 0;
		size = 0;
		front = 0;
		queue = (T[]) new Object[1000];
	}
	
	public CQueue( int capacity) {
		
		back = 0;
		size = 0;
		front = 0;
		if( capacity > 0)
			queue = (T[]) new Object[capacity];
		else
			queue = (T[]) new Object[100];
	}

	public void enqueue( T element) {
		
		if( isFull()) {
			T[] newQueue = (T[]) new Object[queue.length+50];
			for(int index=0; index<queue.length;index++) {
				newQueue[index]=queue[index];
			}
			back =queue.length;
			queue=newQueue;
		}
		queue[back] = element;
		back=(back+1)%queue.length;
		size++;
		return;
	}
	
	public T dequeue() {
		
		T item = null;
		if( isEmpty()) {
			System.out.println( "Empty queue...");
			return item;
		}
		
		item = queue[front];
		front=(front+1)%queue.length;
		size--;
		return item;
	}

	public T peekAtFront() {
		
		T frontItem = null;
		
		if( !isEmpty())
			frontItem = queue[front];
		else
			System.out.println("Queue is empty...");
		
		return frontItem;
	}

	public T peekAtBack() {

		T backItem = null;
		
		if( !isEmpty())
			if(back==0) {
				backItem= queue[queue.length-1];
				return backItem;
			}else
				backItem = queue[back-1];
		else
			System.out.println("Queue is empty...");
		return backItem;
	}
	
	public String toString() {
		
		String str = "[ ";
		int x=front;
		
		if( !isEmpty())
			for( int index = 0 ; index < size ; index++ ) {
				str = str + queue[x] + " ";
				x=(x+1)%queue.length;
				
			}
		
		str += "]";
		
		return str;
	}

	public int size() {
		
		return( size);
	}

	public void reset() {
		
		back = front = size = 0;
		return;
	}
	
	public boolean isFull() {
		
		return( size == queue.length);
	}

	public boolean isEmpty() {
		
		return( size == 0);
	}
}
