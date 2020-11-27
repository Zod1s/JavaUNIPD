import java.util.Scanner;

public class Esercitazione{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserire un numero di base: ");
        int n = s.nextInt();
        System.out.print("Inserire il numero massimo: ");
        int m = s.nextInt();
        int i = 1;
        while (n * i <= m){
            System.out.print(n * i + " ");
            i++;
        }
        s.close();
    }
}
