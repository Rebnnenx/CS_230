import java.io.*;
import java.util.Scanner;

public class Sieve {
	
	public static void main(String[] args) {
		int n=0, p=0, x;
		String cont = "y";
		Scanner kb = new Scanner(System.in);
		CQueue<Integer> integers = new CQueue<Integer>();
		CQueue<Integer> temp = new CQueue<Integer>();
		ABQueue<Integer> primes = new ABQueue<Integer>();
		
		do{
			System.out.print("please enter an integer: ");
			n =kb.nextInt();
		
		while(n<2) {
			System.out.println("Error: number must be greater than 1");
			System.out.print("please enter an integer: ");
			n =kb.nextInt();
		}
		
		for(int i=2; i<=n;i++) {
			integers.enqueue(i);
		}
		
		p=integers.dequeue();
		primes.enqueue(p);
		do {
			
			
			int size=integers.size();
			
			for(int i=0; i<size;i++) {
				x=integers.dequeue();
			//	System.out.println(p+"  "+ x);
				
				
				if(x%p != 0) {
					integers.enqueue(x);
				}
				
		}
			p=integers.dequeue();
			primes.enqueue(p);
		}while((p<Math.sqrt(n)));
		
		while(!integers.isEmpty())
			primes.enqueue(integers.dequeue());
		
		System.out.println("Here are the prime numbers of this list: ");
		

			int counter=1;
			while(!primes.isEmpty()) {
				System.out.print(primes.dequeue()+" ");
				counter++;
				if(counter ==11) {
					counter=1;
					System.out.println();
				}
					
			}
				
		
		System.out.println("\n\nRun Again (y/n)?");
		cont=kb.next();
		
		
		
	}while(cont.equals("y")||cont.equals("Y"));
		
		kb.close();
	}
}
