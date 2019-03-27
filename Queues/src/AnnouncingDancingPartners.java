import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class AnnouncingDancingPartners {

	public static void main(String[] args) throws IOException {

		String dancer;
		CQueue<String> Fqueue = new CQueue<String>();
		CQueue<String> Mqueue = new CQueue<String>();
		Scanner infile = new Scanner( new File( "dancers.txt"));
		
		while( infile.hasNextLine()) {
			dancer = infile.nextLine();
			if(dancer.charAt(0)=='F') {
				Fqueue.enqueue(dancer.substring(2));
			}if(dancer.charAt(0)=='M'){
				Mqueue.enqueue(dancer.substring(2));
			}
		}
		
		System.out.println( "Announcing Dancers: "+ Fqueue);
		System.out.println( "Announcing Dancers: "+ Mqueue);		
		
		while(!Fqueue.isEmpty() && !Mqueue.isEmpty()) {
			
			System.out.println(Fqueue.dequeue()+ " Will be dancing with "+ Mqueue.dequeue());
		}
		if(!Fqueue.isEmpty() || !Mqueue.isEmpty()) {
			System.out.println("The following need to wait:");
			while(!Fqueue.isEmpty()) {
				System.out.println(Fqueue.dequeue());
			}
			while(!Mqueue.isEmpty()) {
				System.out.println(Mqueue.dequeue());
			}
		}
		
		
		infile.close();
		return;
	}
}
