import java.util.Scanner;

public class Coins{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        System.out.print("Lire: ");
        int lit = s.nextInt();
        System.out.print("Euro: ");
        double euro = s.nextDouble();
        System.out.println(lit / 1936.27 + euro);
    }
}
