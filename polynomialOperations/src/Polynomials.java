import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class PolyNum implements Comparable<PolyNum>{
	private int coef = 0, exponent= 0;
	
	public PolyNum(int coef, int exp) {
		this.coef = coef;
		this.exponent=exp;
		
		return;
	}
	
	public int getCoeficent() {
		return coef;
	}
	
	public int getExponent() {
		return exponent;
	}

	@Override
	public int compareTo(PolyNum o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
public class Polynomials <T extends Comparable<T>>{

	public static void main(String[] args) throws FileNotFoundException{
		
		
		File list = new File("polynomials.txt");
	    Scanner fileReader = new Scanner(list);
	    LinkedList<PolyNum> poly1 = new LinkedList<PolyNum>();
	    LinkedList<PolyNum> poly2 = new LinkedList<PolyNum>();
	    LinkedList<PolyNum> polyR = new LinkedList<PolyNum>();
	    
	    int x, coef, exp;
	    String input;
	    
	    x = fileReader.nextInt();
	    fileReader.nextLine();
	    input = fileReader.nextLine();
	    String terms[] =input.split(" ");
	    
	    for (int i=0; i<terms.length;i=+2) {
	    	PolyNum temp = new PolyNum(Integer.parseInt(terms[i]),Integer.parseInt(terms[i+1]));
	    	poly1.insertAtBack(temp);
	    }
	    
	    
	    input = fileReader.nextLine();
	    terms=input.split(" ");
	}

	
	
}
