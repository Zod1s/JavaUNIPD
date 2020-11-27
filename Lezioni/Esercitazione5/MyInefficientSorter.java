import java.util.*; // errore nella stampa
public class MyInefficientSorter{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] vals = new int[1];
        int index = 0;
        while(s.hasNextInt()){
            vals[index] = s.nextInt();
            index++;
            if (index >= vals.length){
                int[] valst = new int[vals.length * 2];
                for (int i = 0; i < index; i++){
                    valst[i] = vals[i];
                }
                vals = valst;
            }
        }
        vals = resize(vals, index);
        int[] ordered = new int[vals.length];
        int i = 0;
        while(vals.length > 0){
            int ind = minimum(vals);
            ordered[i] = vals[ind];
            i++;
            vals = eliminateAndResize(vals, ind);
        }
        display(ordered);
        s.close();
    }

    private static int[] resize(int[] vals, int index){
        int[] valst = new int[index];
        for (int i = 0; i < index; i++){
            valst[i] = vals[i];
        }
        return valst;
    }

    private static int minimum(int[] array){
        int minIndex = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] < array[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int[] eliminateAndResize(int[] array, int index){
        array[index] = array[array.length - 1];
        return resize(array, array.length - 1);
    }

    private static void display(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
