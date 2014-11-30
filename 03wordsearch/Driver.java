import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{


    public static void main(String[]args)throws FileNotFoundException{	
	WordGrid A = new WordGrid(20, 20);
	File text = new File("WordGrid.txt");
        Scanner scnr = new Scanner(text);
	ArrayList<String> Words = new ArrayList<String>();
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            Words.add(line);}
	A.addWords(Words);
	System.out.println(A);
	A.fillBlanks();
	System.out.println( "Find these words:\n"+ A.wordsInPuzzle() );
	System.out.println(A);
    }
}
