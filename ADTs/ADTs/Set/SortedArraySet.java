package ADTs.Set;
public class SortedArraySet implements SortedSetInterface{
    private final static int INITIAL_CAPACITY = 1;
    private Comparable[] v;
    private int size;

    public SortedArraySet(){
        v = new Comparable[INITIAL_CAPACITY];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int getSize(){
        return size;
    }

    public Comparable[] toSortedArray(){
        Comparable[] x = new Comparable[size];
        System.arraycopy(v, 0, x, 0, size);
        return x;
    }

    public Object[] toArray(){
        return toSortedArray();
    }

    public boolean contains(Object x){ // O(log(n))
        Comparable t = (Comparable) x;
        int low = 0;
        int high = size;
        while (low < high){
            int mid = (low + high) / 2;
            Comparable elem = v[mid];
            if (elem.equals(t)){
                return true;
            }
            else if (elem.compareTo(t) > 0){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }

    public void add(Comparable x){ // O(n)
        if (contains(x)) return;
        if (size == v.length){
            Comparable[] temp = new Comparable[size * 2];
            System.arraycopy(v, 0, temp, 0, size);
            v = temp;
        }
        v[size++] = x;
        sort();
    }

    public void add(Object x){ // O(n)
        throw new IllegalArgumentException();
    }

    void sort(){ // O(n) perché faccio un solo ciclo
        if (size < 2){
            return;
        }
        for (int j = size - 2; j >= 0; j--){
            if (v[j + 1].compareTo(v[j]) < 0){
                Comparable temp = v[j];
                v[j] = v[j + 1];
                v[j + 1] = temp;
            }
            else{
                break;
            }
        }
    }

    public static SortedSetInterface union(SortedSetInterface s1, SortedSetInterface s2){ // O(nlog(n)), simile al merge
        // in questo caso add è O(log(n)) perché l'elemento inserito è già in fondo, quindi
        // il sort è O(1) mentre il contains è sempre O(log(n))
        SortedSetInterface x = new SortedArraySet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length){
            if (v1[i].compareTo(v2[j]) < 0){
                x.add(v1[i++]);
            }
            else if (v1[i].compareTo(v2[j]) > 0){
                x.add(v2[j++]);
            }
            else{
                x.add(v1[i++]);
                j++;
            }
        }
        while (i < v1.length){
            x.add(v1[i++]);
        }
        while (j < v2.length){
            x.add(v2[j++]);
        }
        return x;
    }

    public static SortedSetInterface intersection(SortedSetInterface s1, SortedSetInterface s2){ // O(nlog(n))
        SortedSetInterface x = new SortedArraySet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        for (int i = 0, j = 0; i < v1.length; i++){
            while (j < v2.length && v1[i].compareTo(v2[j]) > 0){ // se v1 > v2, allora gli elementi di
                                                                 // v2 non sono presenti in v1
                j++;
            }
            if (j == v2.length){
                break;
            }
            if (v1[i].compareTo(v2[j]) == 0){
                x.add(v1[i]);
                j++;
            }
        }
        return x;
    }

    public static SortedSetInterface difference(SortedSetInterface s1, SortedSetInterface s2){ // O(nlog(n))
        SortedSetInterface x = new SortedArraySet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();
        int i, j;
        for (i = 0, j = 0; i < v1.length; i++){
            while (j < v2.length && v1[i].compareTo(v2[j]) > 0){
                j++;
            }
            if (j == v2.length){
                break;
            }
            if (v1[i].compareTo(v2[j]) != 0){
                x.add(v1[i]);
            }
        }
        while (i < v1.length){
            x.add(v1[i++]);
        }
        return x;
    }
}