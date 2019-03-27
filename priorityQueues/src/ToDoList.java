
public class ToDoList {

	public static void main(String[] args) {

		pQueue<Task> toDoList = new pQueue<Task>();
		
		toDoList.enqueue( new Task( "take out trash", 'B', 1));
		toDoList.enqueue( new Task( "Do Homework", 'C', 1));
		toDoList.enqueue( new Task( "Do the Dishes", 'B', 2));
		toDoList.enqueue( new Task( "play video games", 'A', 1));
		toDoList.enqueue( new Task( "Practice Programming", 'C', 3));
		toDoList.enqueue( new Task( "Sleep", 'C', 2));

		while( !toDoList.isEmpty())
				System.out.println( toDoList.dequeue());
		
		

	}

}
