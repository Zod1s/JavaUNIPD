import java.util.Scanner;

public class StdDev{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una sequenza di numeri(CTRL-D per interrompere): ");
        int c = 0;
        double sum = 0;
        double sqSum = 0;
        while(s.hasNextDouble()){
            double i = s.nextDouble();
            sum += i;
            sqSum += i*i;
            c++;
        }
        if (c < 2){
            System.out.println("Errore");
        }
        else{
            System.out.println(Math.sqrt((sqSum - sum*sum/c)/(c-1)));
        }
        s.close();
    }
}
