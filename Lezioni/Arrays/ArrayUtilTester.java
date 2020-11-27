import java.util.*;
public class ArrayUtilTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire la dimensione, il minimo e il massimo: ");
        int l = s.nextInt();
        int min = s.nextInt();
        int max = s.nextInt();
        int[] array = ArrayUtil.randomIntArray(l, min, max);
        int size = array.length;
        ArrayUtil.display(array, size);

        System.out.println("Dammi un valore e un indice");
        int val = s.nextInt();
        int index = s.nextInt();
        ArrayUtil.insert(array, size, index, val);
        ArrayUtil.display(array, size);

        System.out.println("Dammi un indice da eliminare, dimensione: "+size);
        index = s.nextInt();
        ArrayUtil.remove(array, size, index);
        ArrayUtil.display(array, --size);

        System.out.println("Dammi un indice da eliminare, dimensione: "+size);
        index = s.nextInt();
        ArrayUtil.removeSorted(array, size, index);
        ArrayUtil.display(array, --size);

        System.out.println("Dammi un valore da cercare: ");
        val = s.nextInt();
        index = ArrayUtil.find(array, size, val);
        System.out.println(index);

        System.out.println(ArrayUtil.findMax(array, size));
        System.out.println(ArrayUtil.findMin(array, size));
    }
}
