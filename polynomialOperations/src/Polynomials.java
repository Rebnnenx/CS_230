import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polynomials <T extends Comparable<T>>{
	
	private class Poly <T extends Comparable<T>>{
		private int coef, exponent;
		
		public Poly(int coef, int exp) {
			this.coef = coef;
			this.exponent=exp;
			
			return;
		}
		public int getCoeficent() {
			
		}
	}

	public static void main(String[] args) throws FileNotFoundException{
		
		
		File list = new File("polynomials.txt");
	    Scanner fileReader = new Scanner(list);
	    LinkedList<Poly> poly1 = new LinkedList<Poly>();
	    LinkedList<Integer> poly2 = new LinkedList<Integer>();
	    LinkedList<Integer> polyR = new LinkedList<Integer>();
	    
	    int x, coef, exp;
	    String input;
	    
	    x = fileReader.nextInt();
	    fileReader.nextLine();
	    input = fileReader.nextLine();
	    String terms[] =input.split(" ");
	    
	    
	    input = fileReader.nextLine();
	    terms=input.split(" ");
	    

	    
	    
	    
	    
	}
	
}
