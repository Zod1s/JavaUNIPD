import java.util.*;
public class FibIter{
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
        iterFib(n);
        long end = System.nanoTime();
        System.out.println(end - init);
    }

    public static long iterFib(int n){
        long fib0 = 0;
        long  fib1 = 1;
        for (int i = 1; i < n; i++){
            long temp = fib1;
            fib1 += fib0;
            fib0 = temp;
        }
        return fib1;
    }
}
