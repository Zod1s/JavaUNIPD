import java.util.Scanner;

public class Num2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        double sum = 0;
        final String SENTINELLA = "STOP";
        boolean done = false;
        while (!done){
            System.out.println("Prossimo numero (STOP per terminare): ");
            String read = s.nextLine();
            if (read.equals(SENTINELLA)){
                done = true;
            }
            else{
                done = true;
            }
        }
        System.out.println("Somma: "+sum);
        s.close();
    }
}
