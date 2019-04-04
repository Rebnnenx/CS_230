import java.util.Random;


public class MergingLists {
	
	public static void Main(String[] args) {
	
		int[] A=new int[25];
		int[] B=new int[40];
		ABList<Integer> C = new ABList<Integer>();
		Random rand = new Random();
		int i,j;
		i=0; 
		j=0;
		for(j=0;j<A.length;j++)
			A[i]= rand.nextInt(100);
		
		for(i=0;i<A.length;i++) {
			B[j]= rand.nextInt(100);
		}
		
		A=bubbleSort(A);
		B=bubbleSort(B);
		for(int index=0; index<A.length;index++)
			System.out.print(A[index]+" ");
		System.out.println();
		for(int index=0; index<B.length;index++)
			System.out.print(B[index]+" ");
		i=j=0;
		while(i<A.length && j<B.length) {
			if(A[i]<=B[j]) {
				C.insert(A[i]);
				i++;
			}
			else {
				C.insert(B[j]);
				j++;
			}
		}
		while(i<A.length)
			C.insert(A[i++]);
		while(j<B.length)
			C.insert(B[j++]);
		
		System.out.println(C);
	}
	
	
	
	public static int[] bubbleSort(int[] x) {
		int pass, i, temp;
		
		for (pass=1; pass<=x.length;pass++) {
			for(i=0; i<x.length-1;i++) {
				if(x[i]> x[i+1]) {
					temp=x[i];
					x[i]=x[i+1];
					x[i+1]=temp;
				}
			}
		}
			return x;
	}
	
}

