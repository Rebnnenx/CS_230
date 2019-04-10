import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polynomials <T extends Comparable<T>>{

	public static void main(String[] args) throws FileNotFoundException{
		
		
		File list = new File("polynomials.txt");
	    Scanner fileReader = new Scanner(list);
	    LinkedList<PolyNum> poly1 = new LinkedList<PolyNum>();
	    LinkedList<PolyNum> poly2 = new LinkedList<PolyNum>();
	    LinkedList<PolyNum> polyAdd = new LinkedList<PolyNum>();
	    LinkedList<PolyNum> polySub = new LinkedList<PolyNum>();
	    LinkedList<PolyNum> polyMult = new LinkedList<PolyNum>();
	    
	    int x;
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
	    
	    System.out.println("Program is reading input file to obtain the two polynomials. "+
	    				"The two input polynomials are:\np(x) = "+displayPolynomial(poly1)+
	    				"\nq(x) = "+displayPolynomial(poly2));
	    
	    System.out.println("\nProgram is now performing arithmetic operations on the two polynomials...");
	    System.out.print(displayPolynomial(poly1)+" + "+displayPolynomial(poly2)+ " = ");
	    polyAdd= add(poly1, poly2);
	    System.out.println(displayPolynomial(polyAdd));
	    
	    System.out.print(displayPolynomial(poly1)+" - "+displayPolynomial(poly2)+ " = ");
	    polySub= sub(poly1,poly2);
	    System.out.println(displayPolynomial(polySub));
	    //System.out.println(polySub);
	    
	    System.out.println("\nProgram is now evaluating each polynomial using x= "+ x);
	    System.out.println("p("+x+") = "+eval(poly1, x));
	    System.out.println("q("+x+") = "+eval(poly2, x));
	    
	    System.out.println("\nProgram is now performing multiplication on the two polynomials...");
	    System.out.print(displayPolynomial(poly1)+" * "+displayPolynomial(poly2)+ " = ");
	    polyMult= multiply(poly1, poly2);
	    System.out.println(displayPolynomial(polyMult));
	    fileReader.close();
	}
	
	public static String displayPolynomial(LinkedList<PolyNum> poly) {
		String str="( ";
		int size = poly.size();
		
		for(int i=0; i<size; i++) {
			PolyNum term =poly.removeFromFront();
			if(term.getCoeficent()!=0) {
				if(term.getCoeficent()==1) {
					if(i==0)
						str= str +term.getCoeficent();
					else if(i==1)
						str=str+" + x";
					else
						str=str+" + x^"+term.getExponent();
				}else if(term.getCoeficent()==-1) {
					if(i==0)
						str= str +term.getCoeficent();
					else if(i==1)
						str=str+" - x";
					else
						str=str+" - x^"+term.getExponent();
				}else {
					if(i==0)
						str= str +term.getCoeficent();
					else if(i==1)
						str=str+" + "+ term.getCoeficent()+"x";
					else
						str=str+" + "+ term.getCoeficent()+"x^"+term.getExponent();
				}
				
			}
		poly.insertAtBack(term);
		}
		return str+" )";
	}
	
	public static LinkedList<PolyNum> add(LinkedList<PolyNum> poly1,LinkedList<PolyNum>poly2){
		
		LinkedList<PolyNum>p1= new LinkedList<PolyNum>(poly1);
		LinkedList<PolyNum>p2= new LinkedList<PolyNum>(poly2);
		LinkedList<PolyNum>res = new LinkedList<PolyNum>();
		PolyNum term1, term2;
		int size;
		if (p1.size()>p2.size())
			size = p1.size();
		else
			size = p2.size();
		for(int i=0; i<size;i++) {
			
			if(!p1.isEmpty()&& !p2.isEmpty()) {
				term1= p1.removeFromFront();
				term2= p2.removeFromFront();
				if(term1.getExponent() >term2.getExponent()) {
					res.insertAtBack(term2);
					p1.insertAtFront(term1);
				}
				else if( term1.getExponent()<term2.getExponent()) {
					res.insertAtBack(term1);
					p2.insertAtFront(term2);
				}
				else {
					PolyNum termR= new PolyNum(term1.getCoeficent()+term2.getCoeficent(), term1.getExponent());
					res.insertAtBack(termR);
				}
			}
		}
		while(!p1.isEmpty()) {
			res.insertAtBack(p1.removeFromFront());
		}
		while(!p2.isEmpty()) {
			res.insertAtBack(p2.removeFromFront());
		}
		
		return res;
	}
	
public static LinkedList<PolyNum> sub(LinkedList<PolyNum> poly1,LinkedList<PolyNum>poly2){
		
		LinkedList<PolyNum>p1= new LinkedList<PolyNum>(poly1);
		LinkedList<PolyNum>p2= new LinkedList<PolyNum>(poly2);
		LinkedList<PolyNum>res = new LinkedList<PolyNum>();
		PolyNum term1, term2;
		int size;
		if (p1.size()>p2.size())
			size = p1.size();
		else
			size = p2.size();
		for(int i=0; i<size;i++) {
			
			if(!p1.isEmpty()&& !p2.isEmpty()) {
				term1= p1.removeFromFront();
				term2= p2.removeFromFront();
				if(term1.getExponent() >term2.getExponent()) {
					res.insertAtBack(term2);
					p1.insertAtFront(term1);
				}
				else if( term1.getExponent()<term2.getExponent()) {
					res.insertAtBack(term1);
					p2.insertAtFront(term2);
				}
				else {
					PolyNum termR= new PolyNum(term1.getCoeficent()-term2.getCoeficent(), term1.getExponent());
					res.insertAtBack(termR);
				}
				
			}
		}
		while(!p1.isEmpty()) {
			PolyNum temp = p1.removeFromFront();
			temp.setCoef(temp.getCoeficent());
			res.insertAtBack(temp);
		}
		while(!p2.isEmpty()) {
			PolyNum temp = p2.removeFromFront();
			temp.setCoef(temp.getCoeficent()*-1);
			res.insertAtBack(temp);
		}
		
		return res;
	}

	@SuppressWarnings("null")
	
	public static int eval(LinkedList<PolyNum> poly, int x) {
		
		LinkedList<PolyNum> p = new LinkedList<PolyNum>(poly);
		int res= p.removeFromFront().getCoeficent();
		PolyNum temp=null;
		while(!p.isEmpty()) {
			temp=p.removeFromFront();
			res= (int) (res+(temp.getCoeficent()*(Math.pow(x, temp.getExponent()))));
		}
			
		
		return res;
	}
	
	public static LinkedList<PolyNum> multiply(LinkedList<PolyNum> p1,LinkedList<PolyNum> p2){
		LinkedList<PolyNum> res= new LinkedList<PolyNum>();
		
		System.out.println(p1.size()+" "+p2.size());
		for(int i = 0; i < p2.size(); i++) {
			int add, deg;
			add=deg=0;
			System.out.println("test4");
			for(int j = 0; j < p1.size(); j++) {
				deg=i+j;
				System.out.println("test");
				int size = res.size();
				for(int t=0;t<size;t++) {
					System.out.println("test");
					PolyNum temp = res.removeFromFront();
					if(deg == temp.getExponent()) {
						add= add+temp.getCoeficent();
						System.out.println("test2");
						
					}
				}
				add = add + (p1.removeFromFront().getCoeficent() 
						     *p2.removeFromFront().getCoeficent());
				PolyNum temp2= new PolyNum(add, deg);
				res.insertAtBack(temp2);
			}
		}
		
		return res;
	}
}

class PolyNum implements Comparable<PolyNum>{
	
	
	
	@Override
	public String toString() {
		return "PolyNum [coef=" + coef + ", exponent=" + exponent + "]";
	}

	private int coef = 0, exponent= 0;
	
	public PolyNum(int coef, int exp) {
		this.coef = coef;
		this.exponent=exp;
		
		return;
	}
	public PolyNum(PolyNum other) {
		this.coef=other.coef;
		this.exponent=other.exponent;
		
		return;
	}
	public PolyNum copy(PolyNum other) {
		PolyNum poly = new PolyNum(other);
		
		return poly;
	}
	public PolyNum setTerm(int coef, int exp) {
		PolyNum poly= new PolyNum(coef, exp);
		
		return poly;
	}
	
	public int getCoeficent() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	
	public int getExponent() {
		return exponent;
	}
	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	@Override
	public int compareTo(PolyNum o) {
		
		return 0;
	}
}
