import java.util.*;
public class FibRec{
    public static void main(String[] args){
        int n = 0;
        if (args[0] == null){
            Scanner s = new Scanner(System.in);
            System.out.println("Inserire un intero");
            boolean done = false;
            while (!done){
                try{
                    n = s.nextInt();
                }
                catch(InputMismatchException e){
                    s.nextLine();
                }
            }
        }
        else if(args.length > 1){
            throw new IllegalArgumentException();
        }
        else{
            n = Integer.parseInt(args[0]);
        }
        long init = System.nanoTime();
        recFib(n);
        long end = System.nanoTime();
        System.out.println(end - init);
    }

    public static long recFib(int n){
        if (n <= 2){
            return 1;
        }
        return recFib(n - 1) + recFib(n - 2);
    }
}
