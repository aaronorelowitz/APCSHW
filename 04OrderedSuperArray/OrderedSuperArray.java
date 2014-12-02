public class OrderedSuperArray extends SuperArray{
    String[] stuff;
    int currentLength;

    public OrderedSuperArray(){
	stuff = new String[10];
    }
    
    public OrderedSuperArray(int length){
       	stuff = new String[length];
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
	int spot = size();
	if (size() == getLength()){
	    resize(size() * 2);
	}
	for (int i = 0; i < size(); i++){
	    if (stuff[i].compareTo(e) > 0){
		spot = i;
		i = stuff.length;
	    }
	}
	for(int i = stuff.length - 1; i > spot; i--){
	    stuff[i] = stuff[i - 1];
	}
	stuff[spot] = e;
	
    }

    public void add(int index, String e){
	add(e);
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
	remove(index);
	add(e);
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

    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray(5);
	System.out.println(a);
	System.out.println(a.size());
	a.add("Test");
	System.out.println(a);
       	System.out.println(a.size());
       	a.add("Apple");
	System.out.println(a);
       	System.out.println(a.size());
	a.resize(3);
	System.out.println(a);
	a.add("Blah");
	System.out.println(a);
	a.add("Car");
	a.add("Dog");
	System.out.println(a);	
	a.remove(2);
	System.out.println(a);
	a.set(1, "Joe");
	System.out.println(a);
	a.set(2, "Todd");
	System.out.println(a);

    }
}
