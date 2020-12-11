public class SortAlgs{
    public static void insertionSort(int[] array){
        if (array == null) return;
        for (int i = 1; i < array.length; i++){
            boolean inserted = false;
            for (int j = i - 1; j >= 0 && !inserted; j--){
                if (array[j] > array[j+1]){
                    swap(array, j, j+1);
                }
                else{
                    inserted = true;
                }
            }
        }
    }
    public static void selectionSort(int[] array){
        if (array == null) return;
        for (int i = 0; i < array.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }
            if (min != i){
                swap(array, i, min);
            }
        }
    }
    public static void mergeSort(int[] array){
        if (array == null || array.length <= 1) return;
        int l = array.length / 2;
        int[] a = new int[l];
        int[] b = new int[array.length - l];
        System.arraycopy(array, 0, a, 0, a.length);
        System.arraycopy(array, l, b, 0, b.length);
        mergeSort(a);
        mergeSort(b);
        merge(array, a, b);
    }
    public static void swap(int[] array, int iS, int iF){
        int temp = array[iS];
        array[iS] = array[iF];
        array[iF] = temp;
    }
    public static void merge(int[] m, int[] a, int[] b){
        int aIndex = 0, bIndex = 0, mIndex = 0;
        while(aIndex < a.length && bIndex < b.length){
            if (a[aIndex] < b[bIndex]){
                m[mIndex++] = a[aIndex++];
            }
            else{
                m[mIndex++] = b[bIndex++];
            }
        }
        while(aIndex < a.length){
            m[mIndex++] = a[aIndex++];            
        }
        while(bIndex < b.length){
            m[mIndex++] = b[bIndex++];            
        }
        return;
    }
}
