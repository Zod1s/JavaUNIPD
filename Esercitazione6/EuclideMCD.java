import java.util.Scanner;
public class EuclideMCD{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire due interi: ");
        int m = s.nextInt();
        int n = s.nextInt();
        if (m < 0 || m < n){
            System.out.println("Primo valore non accettabile");
        }
        else if (n < 1){
            System.out.println("Secondo valore non accettabile");
        }
        else {
            while (m%n != 0){
                int tmp = m % n;
                m = n;
                n = tmp;
            }
            System.out.println("MCD = "+n);
        }
    }
}
