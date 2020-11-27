import java.util.Scanner;

public class Primo{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserire un numero maggiore di 1: ");
        int i = s.nextInt();
        int j = 2;
        boolean isPrime = true;
        while (j*j <= i){
            if (i%j==0){
                isPrime = false;
                break;
            }
            j += 1;
        }
        if (isPrime){
            System.out.println(i+" e' primo");
        }
        else{
            System.out.println(i+" non e' primo");
        }
        s.close();
    }
}
