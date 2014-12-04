public class SuperArray{
    Object[] stuff;
    int currentLength;

    public SuperArray(){
	stuff = new Object[10];
    }
    
    public SuperArray(int length){
       	stuff = new Object[length];
    }

    public String toString(){
	String ans = "[ ";
	for (int i = 0; i < size(); i++){
	    ans = ans + stuff[i] + " ";
	}
	ans = ans + "]";
	return ans;
    }

    public void add(Object e){
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

    public void add(int index, Object o){
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
	Object[] copy = new Object[newCapacity];
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

    public Object get(int index){
	if(index < 0  || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return stuff[index];
    }

    public Object set(int index, Object e){
	if( index < 0  || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Object a = stuff[index];
	stuff[index] = e;
	return a;	    
    }

    public Object remove(int index){
	Object a = stuff[index];
	Object[] copy = new Object[stuff.length];
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


    public static void main(String[]args){
	SuperArray a = new SuperArray(5);
	System.out.println(a);
	System.out.println(a.size());
	a.add("Abe");
	System.out.println(a);
       	System.out.println(a.size());
       	a.add("Aaron");
	System.out.println(a);
       	System.out.println(a.size());
	a.resize(3);
	System.out.println(a);
	a.add("Donny");
	System.out.println(a);
	a.add("Billy");
	a.add("Charles");
	System.out.println(a);	
	a.add(2, "Joe");
	System.out.println(a);	
	a.insertionSort();
	System.out.println(a);

    }
}
