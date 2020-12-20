import java.util.Scanner;

public class SomeNumbers{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserire interi(CTRL-D per uscire): ");
        int c = 0;
        double sum = 0;
        double absSum = 0;
        double prod = 1;
        while(s.hasNextDouble()){
            double i = s.nextDouble();
            sum += i;
            prod *= i;
            absSum += Math.abs(i);
            c++;
        }
        if (c < 2){
            System.out.println("Errore, meno di due parametri");
        }
        else{
            System.out.println(sum);
            System.out.println(absSum);
            System.out.println(prod);
            System.out.println(sum/c);
        }
        s.close();
    }
}
