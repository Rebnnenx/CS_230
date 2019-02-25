import java.util.Scanner;

public class Parenthesis{
	
	public static void main(String[] args) {
		
		char ch;
		Scanner kb = new Scanner(System.in);
		String expression;
		ABStack<Integer> stack = new ABStack<Integer>(20);
		
		for (int count = 1; count <=5 ; count++){
			
			System.out.println("Enter an expression: ");
			expression = kb.nextLine();
			
			for (int index =0; index <expression.length(); index++) {
				
				ch= expression.charAt(index);
				
				if(ch == '(')
					stack.push(index);
				else if(ch == ')') {
					if(stack.isEmpty())
						System.out.println(") at index " +index + " does  not have a matching (.");
					else
						System.out.println(") at index " +index+ " matches the ( at index " +stack.pop());
				}
			}
			
			while( !stack.isEmpty()) {
				System.out.println("( at index " +stack.pop()+ "does not have a matching ).");
			}
		}
		kb.close();
	}
	
	
	
	
}