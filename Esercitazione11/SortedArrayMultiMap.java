public class SortedArrayMultiMap implements MultiMapInterface{
    private Pair[] multiMap;
    private int size;
    public SortedArrayMultiMap(){
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
        if (key == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        for (int i = 0; i < size; i++){
            if (multiMap[i].key.equals(key)){
                Object r = multiMap[i].value;
                for (int j = i; j < size; j++){
                    multiMap[j] = multiMap[j + 1];
                }
                size--;
                return r;
            }
            else if (((Comparable) multiMap[i].key).compareTo((Comparable) key) > 0){
                break;
            }
        }
        return null;
    }

    public Object[] removeAll(Object key){
        Object[] toReturn = new Object[size];
        int index = 0;
        int i = 0;
        Comparable compKey = (Comparable) key;
        while (i < size && ((Comparable) multiMap[i].key).compareTo(compKey) <= 0){
            if (multiMap[i].key.equals(key)){
                toReturn[index++] = multiMap[i].value;
                for (int j = i; j < size; j++){
                    multiMap[j] = multiMap[j + 1];
                }
                size--;
            }
            else{
                i++;
            }
        }
        toReturn = resize(toReturn, index);
        return toReturn;
    }

    public void insert(Object key, Object value){
        if (key == null || value == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        Pair pair = new Pair(key, value);
        if (size == multiMap.length){
            Pair[] temp = new Pair[size * 2];
            System.arraycopy(multiMap, 0, temp, 0, size);
            multiMap = temp;
        }
        multiMap[size++] = pair;
        sortKeys();
    }

    void sortKeys(){
        for (int i = 1; i < size; i++){
            for (int j = i - 1; j >= 0; j--){
                if (((Comparable) multiMap[j + 1].key).compareTo((Comparable) multiMap[j].key) < 0){
                    Pair temp = multiMap[j];
                    multiMap[j] = multiMap[j + 1];
                    multiMap[j + 1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }

    public Object find(Object key){
        if (!(key instanceof Comparable)) throw new IllegalArgumentException();
        for (int i = 0; i < size; i++){
            if (multiMap[i].key.equals(key)){
                return multiMap[i].value;
            }
            else if (((Comparable) multiMap[i].key).compareTo((Comparable) key) > 0){
                break;
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
