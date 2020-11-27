import java.util.Scanner;
public class PrimeFactors{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserire un intero: ");
        int i = s.nextInt();
        if (i == 1){
            System.out.println("1 = 1");
        }
        else{
            int j = 2;
            String factors = i + " = 1";
            while (j <= i){
                if (i%j == 0){
                    factors += " * " + j;
                    i = i / j;
                    continue;
                }
                j++;
            }
            System.out.println(factors);
        }
        s.close();
    }
}
