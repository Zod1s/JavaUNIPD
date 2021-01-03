package ADTs.MultiMap;
public class ArrayMultiMap implements MultiMapInterface{
    private Pair[] multiMap;
    private int size;
    public ArrayMultiMap(){
        multiMap = new Pair[1];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public Object remove(Object key){
        for (int i = 0; i < size; i++){
            if (multiMap[i].key.equals(key)){
                Object r = multiMap[i].value;
                multiMap[i] = multiMap[--size];
                return r;
            }
        }
        return null;
    }

    public Object[] removeAll(Object key){
        Object[] toReturn = new Object[size];
        int index = 0;
        for (int i = 0; i < size; i++){
            if (multiMap[i].key.equals(key)){
                toReturn[index++] = multiMap[i].value;
                multiMap[i] = multiMap[--size];
            }
        }
        toReturn = resize(toReturn, index);
        return toReturn;
    }

    public void insert(Object key, Object value){
        if (key == null || value == null) throw new IllegalArgumentException();
        Pair pair = new Pair(key, value);
        if (size == multiMap.length){
            Pair[] temp = new Pair[size * 2];
            System.arraycopy(multiMap, 0, temp, 0, size);
            multiMap = temp;
        }
        multiMap[size++] = pair;
    }

    public Object find(Object key){
        for (int i = 0; i < size; i++){
            if (multiMap[i].key.equals(key)){
                return multiMap[i].value;
            }
        }
        return null;
    }

    public Object[] findAll(Object key){
        Object[] toReturn = new Object[size];
        int index = 0;
        for (int i = 0; i < size; i++){
            if (multiMap[i].key.equals(key)){
                toReturn[index++] = multiMap[i].value;
            }
        }
        toReturn = resize(toReturn, index);
        return toReturn;
    }

    public int getSize(){
        return size;
    }

    public Object[] keys(){
        Object[] ks = new Object[size];
        for (int i = 0; i < size; i++){
            ks[i] = multiMap[i].key;
        }
        return ks;
    }

    private Object[] resize(Object[] a, int i){
        Object[] temp = new Object[i];
        System.arraycopy(a, 0, temp, 0, i);
        return temp;
    }

    private class Pair{
        Object key;
        Object value;
        public Pair(Object k, Object v){
            key = k;
            value = v;
        }
    }
}