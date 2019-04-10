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
	    
	    for (int i=0; i<terms.length;i=i+2) {
	    	PolyNum temp = new PolyNum(Integer.parseInt(terms[i]),Integer.parseInt(terms[i+1]));
	    	poly1.insertAtBack(temp);
	    }
	    
	    input = fileReader.nextLine();
	    terms =input.split(" ");
	    
	    for (int i=0; i<terms.length;i=i+2) {
	    	PolyNum temp = new PolyNum(Integer.parseInt(terms[i]),Integer.parseInt(terms[i+1]));
	    	poly2.insertAtBack(temp);
	    }
	    
	    //System.out.println(poly2.toString()+ "\n"+displayPolynomial(poly2));

	}
	
	public static String displayPolynomial(LinkedList<PolyNum> poly) {
		String str="";
		int size = poly.size();
		
		for(int i=0; i<size; i++) {
			PolyNum term =poly.removeFromFront();
			if(term.getCoeficent()!=0) {
				if(i==0)
					str= str +term.getCoeficent();
				else
					str=str+" + "+ term.getCoeficent()+"x^"+term.getExponent();
			}
		poly.insertAtBack(term);
		}
		return str;
	}
	
	
	
	
	
}
