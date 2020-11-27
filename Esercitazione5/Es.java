import java.util.Scanner;

public class Es{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        /*
        System.out.print("Inserire un numero: ");
        int n = s.nextInt();
        if (n <= 0){
            System.out.println("Ingresso non valido");
        }
        else{
            for (int i = 1; i <= n; i++){
                System.out.print(i+" ");
                if (i%10 == 0){
                    System.out.print("\n");
                }
            }
            System.out.print("\n");
        }
        */
        int pad = 4;
        int max = 200;
        for (int i = 1; i <= max; i++){
            String c = " "+i;
            while(c.length() < pad){
                c = " " + c;
            }
            System.out.print(c);
            if (i%10 == 0){
                System.out.print("\n");
            }
        }
        s.close();
    }
}
