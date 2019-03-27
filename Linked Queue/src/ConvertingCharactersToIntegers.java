import java.util.Scanner;

public class ConvertingCharactersToIntegers {

	public static void main(String[] args) {

		char ch;
		String word;
		int length, number = 0;
		Scanner keyboard = new Scanner( System.in);
		LQueue<Character> queue = new LQueue<Character>();

		System.out.print( "Enter a sequence of digits: ");
		word = keyboard.nextLine();
		
		length = word.length();

		for( int index = 0 ; index < length ; index++) {
			
		}
		
		while( !queue.isEmpty()) {
			
		}

		System.out.print( "Sequence entered after it is " );
		System.out.println( "converted to a decimal integer: " + number);
		System.out.print( "Verifying that it is an integer ");
		System.out.println( "by multiplying it by 2: " + number * 2);
		keyboard.close();
		return;
	}
}
