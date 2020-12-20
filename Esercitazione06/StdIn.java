import java.util.Scanner;
public class StdIn{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int index = 0;
        int[] array = new int[1];
        System.out.println("Inserire numeri interi (CTRL-D per finire): ");
        while(s.hasNextInt()){
            array[index] = s.nextInt();
            index++;
            if (index >= array.length){
                array = ArrayUtil.resize(array, array.length*2);
            }
        }
        for (int i = index - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
