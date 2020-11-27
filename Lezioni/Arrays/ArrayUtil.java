import java.util.*;
public class ArrayUtil{
    public static int[] resize(int[] a, int newL){
        int[] newA = new int[newL];
        if (newL >= a.length){
            System.arraycopy(a, 0, newA, 0, a.length);
        }
        else{
            System.arraycopy(a, 0, newA, 0, newL);
        }
        return newA;
    }

    public static double[] resize(double[] a, int newL){
        double[] newA = new double[newL];
        if (newL >= a.length){
            System.arraycopy(a, 0, newA, 0, a.length);
        }
        else{
            System.arraycopy(a, 0, newA, 0, newL);
        }
        return newA;
    }

    
    public static void display(int[] c){
        System.out.print("[");
        for (int i = 0; i < c.length; i++){
            System.out.print(c[i]);
            if (i != c.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    public static void display(double[] c){
        System.out.print("[");
        for (int i = 0; i < c.length; i++){
            System.out.print(c[i]);
            if (i != c.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    public static void display(int[] c, int csize){
        System.out.print("[");
        for (int i = 0; i < csize; i++){
            System.out.print(c[i]);
            if (i != c.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    public static void display(double[] c, int csize){
        System.out.print("[");
        for (int i = 0; i < csize; i++){
            System.out.print(c[i]);
            if (i != c.length - 1){
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }
    
    public static int[] randomIntArray(int l, int n){
        int[] a = new int[l];
        for (int i = 0; i < l; i++){
            a[i] = (int)(1 + n*Math.random());
        }
        return a;
    }

    public static int[] randomIntArray(int l, int min, int max){
        int[] a = new int[l];
        for (int i = 0; i < l; i++){
            a[i] = (int)(min + (1 + max - min)*Math.random());
        }
        return a;
    }
    
    public static int[] removeNoOrder(int[] array, int index){
        if (index < array.length){
            array[index] = array[array.length - 1];
            return resize(array, array.length - 1);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static int removeWithLogicNoOrder(int[] array, int index, int max){
        if (max > index){
            array[index] = array[max - 1];
            max--;
            return max;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static int[] removeWithOrder(int[] array, int index){
        if (index < array.length){
            for (int i = index; i < array.length - 1; i++){
                array[i] = array[i + 1];
            }
            return resize(array, array.length - 1);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static int removeWithLogicWithOrder(int[] array, int index, int max){
        if (index < max){
            for (int i = index; i < max - 1; i++){
                array[i] = array[i + 1];
            }
            max--;
            return max;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static int insertWithLogic(int[] array, int index, int value, int max){
        if (index < max){
            for (int i = max - 1; i > index; i--){
                array[i] = array[i - 1];
            }
            array[index] = value;
            max++;
            return max;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static boolean isElemWithLogic(int[] array, int value, int max){
        boolean found = false;
        for (int i = 0; !found && i < max; i++){
            if (array[i] == value){
                found = true;
            }
        }
        return found;
    }

    public static void remove(int[] array, int size, int index){ // no order
        if (index < size){
            array[index] = array[size - 1];
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static void removeSorted(int[] array, int size, int index){
        if (index < size){
            for (int i = index; i < size - 1; i++){
                array[i] = array[i + 1];
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static void insert(int[] array, int size, int index, int value){
        if (index < size){
            for (int i = size - 1; i > index; i--){
                array[i] = array[i - 1];
            }
            array[index] = value;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public static int findMin(int[] array, int size){
        int min = 0;
        for (int i = 0; i < size; i++){
            if (array[i] < array[min]){
                min = i;
            }
        }
        return array[min];
    }
    
    public static int findMax(int[] array, int size){
        int max = 0;
        for (int i = 0; i < size; i++){
            if (array[i] > array[max]){
                max = i;
            }
        }
        return array[max];
    }

    public static int find(int[] array, int size, int target){
        for (int i = 0; i < size; i++){
            if (array[i] == target){
                return i;
            }
        }
        return -1;
    }
} 
