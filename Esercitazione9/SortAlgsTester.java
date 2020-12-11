import java.util.*;
public class SortAlgsTester{
    public static void main(String[] args){
        if (args.length == 0 || args[0] == null){
            throw new IllegalArgumentException();
        }
        int l = Integer.parseInt(args[0]);
        int[] insArray = new int[l];
        int[] selArray = new int[l];
        int[] merArray = new int[l];
        for (int i = 0; i < l; i++){
            insArray[i] = l - i - 1; //(int)(101*Math.random());
            selArray[i] = insArray[i];
            merArray[i] = insArray[i];
        }
        long insStart = System.currentTimeMillis();
        SortAlgs.insertionSort(insArray);
        long insEnd = System.currentTimeMillis();
        long selStart = System.currentTimeMillis();
        SortAlgs.selectionSort(insArray);
        long selEnd = System.currentTimeMillis();
        long merStart = System.currentTimeMillis();
        SortAlgs.mergeSort(insArray);
        long merEnd = System.currentTimeMillis();
        long insTime = insEnd - insStart;
        long selTime = selEnd - selStart;
        long merTime = merEnd - merStart;
        System.out.println("Insertion Sort time: " + insTime);
        System.out.println("Selection Sort time: " + selTime);
        System.out.println("MergeSort time: " + merTime);
    }
}


/*
for (int i = 0; i < 10; i++){
    System.out.print(array[i] + " ");
}
System.out.println();
SortAlgs.mergeSort(array);
for (int i = 0; i < 10; i++){
    System.out.print(array[i] + " ");
}
System.out.println();
*/
