import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class ProcessingFootnotes {

	public static void main(String[] args) throws IOException {

		char ch;
		String line;
		String footnote;
		int index, footnoteIndex = 0;
		final char END_FOOTNOTE = '}';
		final char BEGIN_FOOTNOTE = '{';
		Scanner infile = new Scanner( new File( "document.txt"));
		LQueue<String> footnotes = new LQueue<String>();
		
		while( infile.hasNextLine()) {
			line = infile.nextLine();
			for( index = 0 ; index < line.length() ; index++) {
				ch=line.charAt(index);
				if(ch != BEGIN_FOOTNOTE) {
					System.out.print(ch);
				}else {
					footnote="";
					if(ch==BEGIN_FOOTNOTE) {
						index++;
						footnoteIndex++;
						footnote=footnote+"["+footnoteIndex+"] ";
						while(ch != END_FOOTNOTE) {
							ch = line.charAt(index);
							footnote+=ch;
							index++;
						}
						footnotes.enqueue(footnote);
					}
				}
				
			}
			
			System.out.println();
		}
		
		System.out.println( "\n\n\n");
		

		infile.close();
		return;
	}
}
