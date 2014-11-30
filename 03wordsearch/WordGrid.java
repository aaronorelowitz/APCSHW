import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class WordGrid{
    private char[][]data;

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

    public boolean addWordHorizontal(String word,int row, int col){
	if (data[row].length - col < word.length()){
	    return false;}
	else{
	    for (int i = 0;i < word.length(); i++){
		if (data[row][col + i] != ' ' && data[row][col + i] != word.charAt(i))
		    {return false;}}
	    for (int k = 0;k < word.length(); k++){
		data[row][col + k] = word.charAt(k);
	    }
	    return true;}

    }

    public boolean addWordVertical(String word,int row, int col){
	if (data[col].length - row < word.length()){
	    return false;}
	else{
	    for (int i = 0;i < word.length(); i++){
		if (data[row + i][col] != ' ' && data[row + i][col] != word.charAt(i))
		    {return false;}}
	    for (int k = 0;k < word.length(); k++){
		data[row + k][col] = word.charAt(k);
	    }
	    return true;}
    }

      public boolean addWordDiagonal(String word,int row, int col){
	if (data[col].length - row < word.length() || data[row].length - col < word.length()){
	    return false;}
	else{
	    for (int i = 0;i < word.length(); i++){
		if (data[row + i][col + i] != ' ' && data[row + i][col + i] != word.charAt(i))
		    {return false;}}
	    for (int k = 0;k < word.length(); k++){
		data[row + k][col + k] = word.charAt(k);
	    }
	    return true;}
    }

    public boolean addWordHorizontalReverse(String word,int row, int col){
	if (col < word.length()){
	    return false;}
	else{
	    for (int i = 0;i < word.length(); i++){
		if (data[row][col - i] != ' ' && data[row][col - i] != word.charAt(i))
		    {return false;}}
	    for (int k = 0;k < word.length(); k++){
		data[row][col - k] = word.charAt(k);
	    }
	    return true;}

    }

    public boolean addWordDiagonalReverse(String word,int row, int col){
	if (row < word.length() || col < word.length()){
	    return false;}
	else{
	    for (int i = 0;i < word.length(); i++){
		if (data[row - i][col - i] != ' ' && data[row - i][col - i] != word.charAt(i))
		    {return false;}}
	    for (int k = 0;k < word.length(); k++){
		data[row - k][col - k] = word.charAt(k);
	    }
	    return true;}
    }

    public boolean addWordVerticalReverse(String word,int row, int col){
	if (row < word.length()){
	    return false;}
	else{
	    for (int i = 0;i < word.length(); i++){
		if (data[row - i][col] != ' ' && data[row - i][col] != word.charAt(i))
		    {return false;}}
	    for (int k = 0;k < word.length(); k++){
		data[row - k][col] = word.charAt(k);
	    }
	    return true;}
    }

    public boolean addRandom(String word,int row, int col){
	Random R = new Random();
	int X = R.nextInt(6);
	if (X == 0)return addWordHorizontal(word, row, col);
	if (X == 1)return addWordVertical(word, row, col);
	if (X == 2)return addWordDiagonal(word, row, col);
	if (X == 3)return addWordHorizontalReverse(word, row, col);
	if (X == 4)return addWordVerticalReverse(word, row, col);
	else{return addWordDiagonalReverse(word, row, col);}
    }				   

    public void addWords(ArrayList<String> Words, int rows, int cols){
	int i = 0;
	Random R = new Random();
	int length = Words.size();
	while(i < length){
	    int X = R.nextInt(Words.size());
	    String word = Words.remove(X);
	    int q = 0;
	    while (!(addRandom(word, R.nextInt(rows), R.nextInt(cols))) && (q < 1000000)){
		q = q + 1;}
	    i = i + 1;}
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
	A.addWords(Words, 20, 20);
	System.out.println(A);}

}
