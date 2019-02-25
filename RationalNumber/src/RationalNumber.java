/**
 * Brennen Nalley
 *This is meant to create an object class RationalNumber
 * to display and modify rational numbers
 */

public class RationalNumber
{
	private int numerator;
	private int denominator;
	
	//constructors
	public RationalNumber() 
	{
		numerator=0;
		denominator=1;
	}
	
	
	public RationalNumber(int n, int d) 
	{
		numerator= n;
		denominator = d;
		simplify();
	}
	
	public RationalNumber(String n, String d) 
	{
		numerator= Integer.parseInt(n);
		denominator = Integer.parseInt(d);
		simplify();
	}
	
	//copy constructor copies existing object into new object
	public RationalNumber(RationalNumber other) 
	{
		this.numerator = other.numerator;
		this.denominator = other.denominator;
		simplify();
	}
	
	
	//methods to set the numerator individually
	public void setNumerator(int num) 
	{
		numerator= num;
		simplify();
	}
	
	public void setNumerator(String num) 
	{
		numerator= Integer.parseInt(num);
		simplify();
	}
	
	
	//methods to set the numerator individually
	public void setDenominator(int den) 
	{
		denominator= den;
		simplify();
	}
	
	public void setDenominator(String den) 
	{
		denominator= Integer.parseInt(den);
		simplify();
	}
	
	
	//returns the numerator or denominator
	public int getNumerator() 
	{
		return numerator;
	}
	
	public int getDenominator() 
	{
		return denominator;
	}
	
	
	//simplifier method
	public void simplify()
	{
		
		int divisor = gcd(numerator, denominator);
		numerator = numerator/divisor;
		denominator= denominator/divisor;
		
		if(denominator < 0)
		{
			denominator = -denominator;

			if (numerator < 0) {
				this.numerator = -this.numerator;

			}else {
				this.numerator=-numerator;

			}
		}
	}
	
	
	//finds gcd of the RationalNumber object
	public static int gcd(int a, int b)
	{
		if (b == 0) 
	        return a; 
	      return gcd(b, a % b);
	}
	
	
	//creates a copy of the calling object
	public RationalNumber copy()
	{
		RationalNumber other = new RationalNumber(numerator, denominator);
		
		return other;
	}
	
	public boolean equals(RationalNumber other)
	{
		if(this.denominator==other.denominator) {
			if(this.numerator == other.numerator) {
				return true;
			}
		}
		return false;
	}
	
	//addition method
	public RationalNumber addition(RationalNumber other) {
		
		RationalNumber answer = new RationalNumber(
			this.numerator*other.denominator +other.numerator*this.denominator,
		    this.denominator*other.denominator); 
		return answer;
	}
	
	
	//subtraction method
	public RationalNumber subtraction(RationalNumber other) {
		
		RationalNumber answer = new RationalNumber(
			this.numerator*other.denominator -other.numerator*this.denominator,
			this.denominator*other.denominator);
		return answer;
	}
	
	
	//multiplication method
	public RationalNumber multiplication(RationalNumber other) {
		
		RationalNumber answer = new RationalNumber(
			this.numerator*other.numerator,this.denominator*other.denominator); 
		return answer;
	}
	
	
	//division method
	public RationalNumber division(RationalNumber other) {
		
		RationalNumber answer = new RationalNumber(
			this.numerator*other.denominator,this.denominator*other.numerator);
		return answer;
	}
	
	/*
	public int compareTo( RationalNumber other) {
		
		if(this.toDecimal()== other.toDecimal()) {
			return 0;
		}
		if(this.toDecimal() < other.toDecimal()) {
			return -1;
		}else
			return 1;
	}
	*/
	
	//returns the decimal of the rational number
	public double toDecimal() 
	{
		return ((double)numerator/denominator);
	}
	
	
	//toString method
	public String toString()
	{
		return numerator +"/" + denominator;
	}
	
	
}
