import java.util.Random;
public class InsertionRecursive{
    public static void insertionRec(int[] array, int size){
        if (array == null){
            throw new IllegalArgumentException();
        }
        if (size > 1){
            insertionRec(array, size-1);
            int value = array[size - 1];
            int i;
            for (i = size - 2; i >= 0 && array[i] > value; i--){
                array[i + 1] = array[i];
            }
            array[i + 1] = value;
        }
    }

    public static void main(String[] args){
        Random r = new Random(System.nanoTime());
        int dim = r.nextInt(20) + 1;
        int[] array = new int[dim];
        for (int i = 0; i < dim; i++){
            array[i] = r.nextInt(50);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        insertionRec(array, array.length);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
