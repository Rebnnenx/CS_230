@SuppressWarnings("unchecked")
public class ABStack<T> implements StackInterface<T> {

	private T [] stack;
	private int stackTop;
	private final int DEFAULTCAP = 10;
	
	public ABStack() {
		
		stackTop = -1;
		stack = (T[]) new Object[DEFAULTCAP];
	}

	public ABStack( int capacity) {
		
		stackTop = -1;
		
		if( capacity > 0)
			stack = (T[]) new Object[capacity];
		else {
			System.out.print( "Invalid capacity given. ");
			System.out.print( "The default capacity of " + DEFAULTCAP + " is used.");
			stack = (T[]) new Object[DEFAULTCAP];
		}
	}
	
	public ABStack(ABStack<T> other) {
		stackTop = -1;
		T [] newStack = (T[]) new Object[other.size()];
		
		for( int index = 0 ; index < other.size()-1 ; index++) {
			newStack[index] = (T) other.stack[index];
		}
		stack= newStack;
		
		
	}

	public void push(T element) {
		
		if( isFull()) {
			int newStackCapacity = stackTop + 10;
			T [] newStack = (T[]) new Object[newStackCapacity];
			
			for( int index = 0 ; index < stack.length-1 ; index++)
				newStack[index] = stack[index];
			stack = newStack;
		}
		
		stackTop++;
		stack[stackTop] = element;
		return;
	}

	public T pop() {
		
		T topElement = null;
		
		if( isEmpty())
			return topElement;
		
		topElement = stack[stackTop];
		stackTop--;
		return topElement;
	}

	public T peek() {
		
		T topElement = null;
		
		if( isEmpty())
			return topElement;
		
		topElement = stack[stackTop];
		return topElement;
	}

	public boolean isEmpty() {
		
		return (stackTop == -1);
	}
	
	public boolean isFull() {
		
		return( stackTop == stack.length - 1);
	}
	
	public int size() {
		
		return stack.length;
	}

	public void reset() {
		
		stackTop = -1;
		return;
	}
	
	public String toString() {
		
		String str = "[";
		
		for( int index = 0 ; index <= stackTop ; index++ )
			str = str + stack[index] + " ";
		
		str += "]";
		
		return str;
	}
	
	public ABStack<T> copy() {
		ABStack<T> copy = new ABStack<T>();
		
		for( int index = 0 ; index < stack.length-1 ; index++)
			copy.push(stack[index]);
		return copy;
	}
	
	public void copy(ABStack<T> other) {
		
		stackTop = -1;
		T [] newStack = (T[]) new Object[other.size()];
		
		for( int index = 0 ; index < other.size()-1 ; index++) {
			newStack[index] = (T) other.stack[index];
		}
		stack= newStack;
	}
	
	
	
	
	
	
}