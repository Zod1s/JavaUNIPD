import java.util.Scanner;

public class Piastrelle{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Larghezza piastrelle: ");
        int Plarg = s.nextInt();
        System.out.println("Larghezza pavimento: ");
        int Tlarg = s.nextInt();
        int n = 1 + 2 * ((Tlarg - Plarg) / (2 * Plarg));
        double gap = (Tlarg - n * Plarg) / 2.0;
        System.out.println(n+"\n"+gap);
    }
}
