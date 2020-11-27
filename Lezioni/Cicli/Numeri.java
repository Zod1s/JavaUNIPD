import java.util.Scanner;
public class Numeri{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Quanti numeri vuoi sommare?: ");
        double sum = 0;
        final int N = s.nextInt();
        System.out.println("Inserisci i numeri: ");
        for (int i = 0; i < N; i++){
            sum += s.nextDouble();
        }
        System.out.println(sum);
        s.close();
    }
}
