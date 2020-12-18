public class ArrayAlgorithms{
    public static void selectionSort(Comparable[] a){
        if (a == null) throw new IllegalArgumentException();
        if (a.length < 2) return;
        for (int i = 0; i < a.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[min].compareTo(a[j]) > 0){
                    min = j;
                }
            }
            if (i != min) swap(a, i, min);
        }
    }
    public static void insertionSort(Comparable[] a){
        if (a == null) throw new IllegalArgumentException();
        if (a.length < 2) return;
        for (int i = 1; i < a.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if (a[j + 1].compareTo(a[j]) < 0){
                    swap(a, j + 1, j);
                }
                else{
                    break;
                }
            }
        }
    }
    public static void mergeSort(Comparable[] a){
        if (a == null) throw new IllegalArgumentException();
        if (a.length < 2) return;
        int mid = a.length / 2;
        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[a.length - mid];
        System.arraycopy(a, 0, left, 0, left.length);
        System.arraycopy(a, mid, right, 0, right.length);
        mergeSort(left);
        mergeSort(right);
        merge(a, left, right);
    }

    public static void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void merge(Comparable[] a, Comparable[] b, Comparable[] c){
        int aIndex = 0, bIndex = 0, cIndex = 0;
        while(bIndex < b.length && cIndex < c.length){
            if (b[bIndex].compareTo(c[cIndex]) < 0){
                a[aIndex++] = b[bIndex++];
            }
            else a[aIndex++] = c[cIndex++];
        }
        while(bIndex < b.length){
            a[aIndex++] = b[bIndex++];
        }
        while(cIndex < c.length){
            a[aIndex++] = c[cIndex++];
        }
    }
}
