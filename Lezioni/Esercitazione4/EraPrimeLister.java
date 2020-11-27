import java.util.Scanner;
public class EraPrimeLister{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserire un numero intero: ");
        int c = s.nextInt();
        for (int i = 2; i < c; i++){
            if (isPrime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        s.close();
    }

    public static boolean isPrime(int i){
        int j = 2;
        boolean isprime = true;
        while (j*j <= i && isprime){
            if (i%j==0){
                isprime = false;
            }
            j += 1;
        }
        return isprime;
    }
}
