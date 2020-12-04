import java.util.*;
public class Rec2{
    public static void main(String[] args){
        if (args[0] == null || args[1] == null || args.length > 2){
            throw new IllegalArgumentException();
        }
        try{
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            if (n1 <= 0 || n2 <= 0){
                throw new IllegalArgumentException();
            }
            System.out.println(mcd(n1, n2));
        }
        catch (NumberFormatException e){
                System.out.println("Non e' stato inserito un intero");
        }
    }
    public static int mcd(int a, int b){
        if (b == 0){
            return a;
        }
        else{
            return mcd(b, a % b);
        }
    }
}
