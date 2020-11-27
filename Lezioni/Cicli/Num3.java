import java.util.Scanner;

public class Num3{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double sum = 0;
        while (s.hasNextDouble()){
            System.out.println("Prossimo numero(Premere Ctrl-D per terminare): ");
            sum += s.nextDouble();
        }
        System.out.println("Somma: "+sum);
        s.close();
    }
}
