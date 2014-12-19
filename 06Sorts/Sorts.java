public class Sorts{

    public static String name(){
	return "Orelowitz, Aaron";
    }

    public static int period(){
	return 7;
    }

    public static void selection(int[]a) {
	for (int i = 1; i < a.length; i++){
	    int x = a[i];
	    int index = i;
	    for (int q = i; q < a.length; q++){
		if (x > (a[q])){
		    x = a[q];
		    index = q;
		}
	    }
	    int swap = a[i];
	    a[i] = x;
	    a[index] = swap;
	}
    }


    public static void insertion(int[]a) {
	for (int i = 1; i < a.length; i++){
	    int x = a[i];
	    int j = i;
	    while (j > 0 && (a[j-1]) > (x)){
	        a[j] = a[j-1];
		j = j - 1;}
	    a[j] = x;}

    }


    public static void bubble(int[]a) {
        boolean x = true;                                         
        while (x) {
            x = false;
            for (int i= 1; i < a.length; i ++) {
                if (a[i-1] > a[i]) {
                    int foo = a[i];
                    a[i] = a[i-1];
                    a[i-1] = foo;
                    x = true;
                }
            }
	}
    }


}
