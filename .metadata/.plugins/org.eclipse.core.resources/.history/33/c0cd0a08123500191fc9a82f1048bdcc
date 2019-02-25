import java.util.Scanner;

public class InfixToPostfix {

	public static void main(String[] args) {

		int value;
		String infixExpression;
		String postfixExpression;
		Scanner keyboard = new Scanner( System.in);
		
		for( int count = 1 ; count <= 5 ; count++) {
			
			System.out.print( "Enter infix expression: ");
			infixExpression = keyboard.nextLine();
			postfixExpression = convertToPostfix( infixExpression);
			value = evaluatePostfix( postfixExpression);
			System.out.println( infixExpression + " = " + postfixExpression + " = " + value);
		}
		
		keyboard.close();
		return;
	}
	
	public static int evaluatePostfix( String postfix) {
		
		int value = 0;
		int length, operand1, operand2, answer;
		char token;
		final char ADD = '+';
		final char SUB = '-';
		final char MUL = '*';
		final char DIV = '/';
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		postfix = removeBlanks( postfix);
		length = postfix.length();
		
		for( int index = 0 ; index < length ; index++) {
			
			token = postfix.charAt( index);
			
			switch( token) {
			
			case ADD:
				
				break;
			
			case SUB:
				
				break;
				
			case MUL:
				
				break;
				
			case DIV:
				
				break;
				
			default:
				
			}
		}
		
		value = stack.pop();
		return value;
	}
	
	public static String removeBlanks( String originalString)
	{
		char ch;
		final char BLANK = ' ';
		int index, stringLength;
		String deblankedString = "";
				    
		stringLength = originalString.length();
		for( index = 0 ; index < stringLength ; index++) {
			ch = originalString.charAt( index);
			if( ch != BLANK)
				deblankedString = deblankedString + ch;
		}
		
		return deblankedString;
	}

	public static String convertToPostfix( String infix)
	{
	    String postfix = "";
		final char LP = '(';
		final char RP = ')';
		final char ADD = '+';
		final char SUB = '-';
		final char MUL = '*';
		final char DIV = '/';
		char token, stackToken;
		final String BLANKSTR = " ";
		int infixLength;
		LinkedStack<Character> stack = new LinkedStack<Character>();
		
		infix = removeBlanks( infix);
		infixLength = infix.length(); 
		for( int index = 0 ; index < infixLength ; index++) {
			
			token = infix.charAt( index);	
			switch( token) {	
				case LP:
					
					break;
				case RP:
					for( ; ; ) {
						
					}
					break;
				case ADD: case SUB:
					for( ; ; ) {
						
					}
					break;
				case MUL: case DIV:
					for( ; ; ) {
						
					}
					break;
				default:
					postfix = postfix + BLANKSTR + token;
					break;
			}			
		}
		while( !stack.isEmpty()) {
				stackToken = stack.pop();
				postfix = postfix + BLANKSTR + stackToken;
		}
		
		return postfix;
	}
}
