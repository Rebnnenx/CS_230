import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LargeInteger {

	public static void main(String[] args) throws FileNotFoundException {
		
		String line;
		int size1, size2;
		LinkedList<Byte> sum = new LinkedList<Byte>();
		LinkedList<Byte> largeInt1 = new LinkedList<Byte>();
		LinkedList<Byte> largeInt2 = new LinkedList<Byte>();
		Scanner inFile = new Scanner( new File( "largeIntegers.txt"));
		
		line = inFile.nextLine();
		largeInt1 = buildLargeInteger( line);
		line = inFile.nextLine(); 	
		largeInt2 = buildLargeInteger( line);
		inFile.close();
		
		size1 = largeInt1.size();
		size2 = largeInt2.size();
		if(size1<size2) {
			for(int count=1;count<=size2-size1;count++)
				largeInt1.insertAtFront((byte)0);
		}else
			for(int count=1;count<=size1-size2;count++)
				largeInt2.insertAtFront((byte)0);
		
		
		System.out.println(largeInt1);
		System.out.println(largeInt2);
		largeInt1.reverse();
		largeInt2.reverse();
		sum = add( largeInt1, largeInt2);
		sum.reverse();
		System.out.println(sum);
		return;
	}
	
	public static LinkedList<Byte> buildLargeInteger( String line) {
		
		Byte x;
		String str;
		int length = line.length();
		LinkedList<Byte> largeInt = new LinkedList<Byte>();
		
		for(int i=0; i<length; i++) {
			str=line.substring(i, i+1);
			x=Byte.parseByte(str);
			largeInt.insertAtBack(x);
		}
		
		return largeInt;
	} 

	public static LinkedList<Byte> add( LinkedList<Byte> num1, LinkedList<Byte> num2) {
		
		int size = num1.size();
		Byte x, y, z, carry = 0;
		LinkedList<Byte> largeInt = new LinkedList<Byte>();
		
		for(int count =1;count<size;count++) {
			x=num1.removeFromFront();
			y=num2.removeFromBack();
			z= (byte)(x + y + carry);
			if (z>=10) {
				z = (byte)(z%10);
				carry =1;
			}
			else
				carry =0;
			largeInt.insertAtBack(z);
		}
		if(carry>0)
			largeInt.insertAtBack(carry);
		
		return largeInt;
	}
		
}
