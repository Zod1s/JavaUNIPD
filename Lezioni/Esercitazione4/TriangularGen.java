import java.util.Scanner;

public class TriangularGen{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserire un numero intero: ");
        int k = s.nextInt();
        int acc = 0;
        for (int i = 0; i < k; i++){
            acc += i + 1;
        }
        System.out.println(acc);
    }
}
