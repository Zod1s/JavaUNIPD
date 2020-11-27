import java.util.Scanner;

public class CostoMacchina{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Anno: ");
        int n = s.nextInt();
        final int INCR = 156;
        final int BASE = 100;
        System.out.println("Costo anno "+n+": "+(BASE + (n - 1) * INCR));
    }
}
