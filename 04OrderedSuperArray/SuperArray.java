public class SuperArray{
    String[] stuff;
    int currentLength;

    public SuperArray(){
	stuff = new String[10];
    }
    
    public SuperArray(int length){
       	stuff = new String[length];
	for (int i = 0; i <stuff.length; i++){
	    stuff[i] = "" + i + " ";
	}
    }

    public String toString(){
	String ans = "[ ";
	for (int i = 0; i < size(); i++){
	    ans = ans + stuff[i] + " ";
	}
	ans = ans + "]";
	return ans;
    }

    public void add(String e){
	if (size() == getLength()){
	    resize(size() + 1);
	}
	    for (int i = 0; i < stuff.length; i++){
		if (stuff[i] == null){
		    stuff[i] = e;
		    i = stuff.length;
	    }
	    }
    }

    public void add(int index, String o){
	if(index < 0 || index > size() ){
	    throw new IndexOutOfBoundsException();
	}				
	if(size() == stuff.length){
	    resize( size() * 2 );
	}
	for(int i = stuff.length - 1; i > index; i--){
	    stuff[i] = stuff[i - 1];
	}
	stuff[ index ] = o;
	;
    }

    public int size(){
	int ans = 0;
	for (int i = 0; i < stuff.length; i++){
	    if (stuff[i] != null){
		ans= ans + 1;
	    }
	}
	return ans;
    }

    public void resize(int newCapacity){
	String[] copy = new String[newCapacity];
	if (stuff.length < copy.length){
	    for (int i = 0; i < stuff.length; i++){
		copy[i] = stuff[i];
		    }
	}else{
	     for (int i = 0; i < copy.length; i++){
		copy[i] = stuff[i];
		    }
	}
	stuff = copy;
    }

    public void clear(){
	for (int i = 0; i < stuff.length; i++){
	    stuff[i] = null;
	}
    }
    public String get(int index){
	if(index < 0  || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return stuff[index];
    }

    public String set(int index, String e){
	if( index < 0  || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String a = stuff[index];
	stuff[index] = e;
	return a;	    
    }

    public String remove(int index){
	String a = stuff[index];
	String[] copy = new String[stuff.length];
	for(int i = 0; i < index; i ++){
	    copy[i] = stuff[i];}
	for(int q = index + 1; q < stuff.length; q++){
	    copy[q - 1] = stuff[q];}
	stuff  = copy;
	return a;
    }

    public int getLength(){
	return stuff.length;
    }

    public int find(String target){
	for(int i = 0; i < size(); i++){
	    if (target.equals((String) stuff[i])){
		    return i;
	    }
	}
	return -1;
    }

    public void insertionSort(){
	for (int i = 1; i < size(); i++){
	    String x = (String)stuff[i];
	    int j = i;
	    while (j > 0 && ((String)stuff[j-1]).compareTo(x) > 0){
		stuff[j] = (String)stuff[j-1];
		j = j - 1;}
	    stuff[j] = x;}
    }

    public void selectionSort(){
	for (int i = 1; i < size(); i++){
	    String x = stuff[i];
	    int index = i;
	    for (int q = i; q < size(); q++){
		if (x.compareTo(stuff[q]) > 0){
		    x = stuff[q];
		    index = q;
		}
	    }
	    String swap = stuff[i];
	    stuff[i] = x;
	    stuff[index] = swap;
	}
    }

    public static void main(String[]args){
	SuperArray a = new SuperArray(500000);
	a.selectionSort();
    }
}
