import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class WordGrid{
    private char[][]data;
    private Random random = new Random();

    public WordGrid(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }

    private void clear(){
	for(int k = 0;k < data.length; k++){
	    for (int j = 0; j < data[k].length; j++){
		data[k][j] = ' ';
	    }
	}
    }


    public String toString(){
	String ans = "";
	for(int k = 0;k < data.length; k++){
	    ans = ans + "\n";
	    for (int j = 0; j < data[k].length; j++){
		ans = ans + " " + data[k][j];
	    }
	}
	return ans;
    }


    public boolean addRandom( String word, int row, int col, int dx, int dy){
	if (checkword(word ,row, col, dx, dy)){
		for(int i = 0; i < word.length(); i++){
		    data[row][col] = word.charAt(i);
		    row = row + dy;
		    col = col + dx;}
		return true;}
	else{return false;}
    }

    public boolean checkword( String word, int row, int col, int dx, int dy){
	if(dx == 0 && dy == 0 ||
	   row < 0 || col < 0 ||
	   col + dx * word.length() >= data[0].length || col + dx * word.length() < 0||
	   row + dy * word.length() >= data.length || row + dy * word.length() < 0)
	    return false;
	 for (int i = 0;i < word.length(); i++){
	     if (data[row + (i * dy)][col + (i * dx)] != ' ' && data[row + (i * dy)][col + (i * dx)] != word.charAt(i))
		    {return false;}}
	return true;}

    public void addWords(ArrayList<String> Words){
	int i = 0;
	int length = Words.size();
	while(i < length){
	    int X = random.nextInt(Words.size());
	    String word = Words.remove(X);
	    int q = 0;
	    while (!(addRandom(word, random.nextInt(data.length), random.nextInt(data[0].length),
			       random.nextInt(3) - 1, random.nextInt(3) - 1 )) 
		   && (q < 1000000)){
		q = q + 1;}
	    i = i + 1;}
	}

    public void fillBlanks(){
	for(int K = 0; K < data.length; K++){
	    for(int J = 0; J < data[K].length; J++){
		if(data[K][J] == ' ')
		data[K][J] = (char)('A' + (int)(Math.random()*26));
	    }
	}
    }

    public static void main(String[]args)throws FileNotFoundException{	
	File text = new File("WordGrid.txt");
        Scanner scnr = new Scanner(text);
	ArrayList<String> Words = new ArrayList<String>();
        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            Words.add(line);
        }       
	WordGrid A = new WordGrid(20, 20);
	System.out.println(A);
	A.addWords(Words);
	System.out.println(A);
	A.fillBlanks();
	System.out.println(A);
    }

}
