import java.util.Scanner;
public class ArraySum{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Quanti elementi? ");
        int l = s.nextInt();
        double[] a = new double[l];
        double sum = 0;
        // double[] b = new double[l];
        System.out.println("Inserire gli elementi del primo array");
        for (int i = 0; i < l; i++){
            a[i] = s.nextDouble();
        }
        System.out.println("Inserire gli elementi del secondo array");
        for (int i = 0; i < l; i++){
            a[i] += s.nextDouble();
            sum += a[i];
        }
        System.out.println("Somma dei due array: ");
        ArrayUtil.display(a);
        System.out.println(sum);
    }
}
