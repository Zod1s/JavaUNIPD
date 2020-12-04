import java.util.*;
public class Rec1{
    public static void main(String[] args){
        if (args[0] == null || args.length > 1){
            throw new IllegalArgumentException();
        }
        else{
            try{
                int n = Integer.parseInt(args[0]);
                if (n <= 0){
                    throw new IllegalArgumentException();
                }
                System.out.println(rec(n));
            }
            catch (NumberFormatException e){
                System.out.println("Non e' stato inserito un intero");
            }
        }
    }
    public static int rec(int n){
        if (n == 1){
            return 1;
        }
        else{
            return n + rec(n - 1);
        }
    }
}
