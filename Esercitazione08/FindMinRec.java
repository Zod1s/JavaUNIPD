import java.util.*;
public class FindMinRec{
    public static void main(String[] args){
        if (args[0] == null || args[1] == null || args.length > 2){
            throw new IllegalArgumentException();
        }
        else{
            int dim = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            int[] array = new int[dim];
            Random random = new Random();
            for (int i = 0; i < dim; i++){
                array[i] = random.nextInt(n) + 1;
            }
            System.out.println(findMin(0, array));
        }
    }
    public static int findMin(int i, int[] array){
        if (array.length == i){
            return array[i - 1];
        }
        else{
            return Math.min(array[i], findMin(i+1, array));
        }
    }
}
