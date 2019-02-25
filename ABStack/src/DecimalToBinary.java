import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		int num;
		Scanner kb = new Scanner(System.in);
		
		for (int count =1; count <=5; count++) {
			System.out.println("Enter a positive integer: ");
			num = kb.nextInt();
			if(num >= 0)
				convert(num);
			else
				System.out.println(num + " is negative.");
			
			kb.close();
			return;
		}
		
	}
		public static void convert(int n) {
			
			ABStack<Integer> stack = new ABStack<Integer>();
			int rem;
			
			while (n > 0) {
				rem = n %2;
				n=n/2;
				stack.push(rem);
			}
			
			while(!stack.isEmpty()) 
				System.out.print(stack.pop());
			System.out.println();
			
			return;
		}
	

}
