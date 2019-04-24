import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		BST<String> dictionary = new BST<String>();
		BST<String> misspells = new BST<String>();
		String ln="";
		String[] line= null;
		Scanner dict = new Scanner(new File ("dictionary.txt"));
		Scanner txt = new Scanner(new File("sampleText.txt"));
		
		while (dict.hasNext()) {
			dictionary.insert(dict.nextLine());
		}
		dict.close();
		
		if(txt.hasNext())
			ln=txt.nextLine();
		while (txt.hasNext()) {
			ln=ln+" "+txt.nextLine();
		}
		txt.close();
		
		line = ln.replaceAll("[.,]", "").split(" ");
			
		for (int i=0;i<line.length;i++) {
			if(!dictionary.searchFor(line[i])) {
				misspells.insert(line[i]);
			}
		}	
		misspells.inOrderTraversal();
		
		
	}
}
