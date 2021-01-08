package ADTs.Set;
public class ArraySet implements SetInterface{
    private final static int INITIAL_CAPACITY = 1;
    private Object[] v;
    private int size;
    public ArraySet(){
        v = new Object[INITIAL_CAPACITY];
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

    public Object[] toArray(){
        Object[] x = new Object[size];
        System.arraycopy(v, 0, x, 0, size);
        return x;
    }

    public boolean contains(Object x){ // O(n)
        for (int i = 0; i < size; i++){
            if (v[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    public void add(Object x){ // O(n)
        if (contains(x)) return;
        if (size == v.length){
            Object[] temp = new Object[size * 2];
            System.arraycopy(v, 0, temp, 0, size);
            v = temp;
        }
        v[size++] = x;
    }

    public static SetInterface union(SetInterface s1, SetInterface s2){ // O(n^2)
        SetInterface x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++){
            x.add(v[i]);
        }
        v = s2.toArray();
        for (int i = 0; i < v.length; i++){
            x.add(v[i]);
        }
        return x;
    }

    public static SetInterface intersection(SetInterface s1, SetInterface s2){ // O(n^2)
        SetInterface x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++){
            if (s2.contains(v[i])){ // O(n)
                x.add(v[i]);
            }
        }
        return x;
    }

    public static SetInterface difference(SetInterface s1, SetInterface s2){ // O(n^2)
        SetInterface x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++){
            if (!s2.contains(v[i])){ // O(n)
                x.add(v[i]);
            }
        }
        return x;
    }
}