import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver{


    public static void main(String[]args)throws FileNotFoundException{
	WordGrid A = new WordGrid(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
	if(args.length > 2){  
	    A.setSeed(Long.parseLong( args[2], 10));  
	}
	A.loadWordsFromFile("WordGrid.txt", (args.length <= 3 || Integer.valueOf(args[3]) != 1));
	System.out.println( "Find these words:\n"+ A.wordsInPuzzle() );
	System.out.println(A);
    }
}
