
public interface StackInterface<T> {

	T pop();
	T peek();
	int size();
	void reset();
	String toString();
	void push( T element);
}