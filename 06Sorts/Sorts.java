public class Sorts{
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
