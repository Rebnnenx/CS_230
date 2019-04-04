import java.util.Random;
import java.util.Scanner;


public class RandomNumber {

	public static void main(String[] args) {
		Random rand= new Random();
		int num, runs, cont;
		cont =1;
		Scanner kb= new Scanner(System.in);
		
		do {
			System.out.println("enter a number");
			num= kb.nextInt();
			
			System.out.println("enter the number of runs");
			runs=kb.nextInt();
			
			for(int i=1;i<=runs;i++) {
				System.out.print(rand.nextInt(num)+1+", ");
				
				if(i%10 ==0)
					System.out.println();
			}
			System.out.println("\n\nRun again? Yes=1, No =0:");
			cont=kb.nextInt();
			
		}while(cont == 1);
		
		kb.close();
	}

}
