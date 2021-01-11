package ADTs.MultiMap;
public class SortedArrayMultiMap implements MultiMapInterface{
    private ComparablePair[] multiMap;
    private int size;
    public SortedArrayMultiMap(){
        multiMap = new ComparablePair[1];
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
        Comparable compKey = (Comparable) key;
        int low = 0;
        int high = size;
        while (low < high){
            int mid = (low + high) / 2;
            ComparablePair elem = multiMap[mid];
            if (elem.key.equals(compKey)){
                for (int j = mid; j < size - 1; j++){
                    multiMap[j] = multiMap[j + 1];
                }
                multiMap[size - 1] = null;
                size--;
                return elem.value;
            }
            else if (elem.key.compareTo(compKey) > 0){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return null;
    }

    public Object[] removeAll(Object key){
        if (key == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        Object[] toReturn = new Object[size];
        int index = 0;
        int i = 0;
        Comparable compKey = (Comparable) key;

        while (i < size && multiMap[i].key.compareTo(compKey) <= 0){
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
        ComparablePair pair = new ComparablePair((Comparable) key, value);
        if (size == multiMap.length){
            ComparablePair[] temp = new ComparablePair[size * 2];
            System.arraycopy(multiMap, 0, temp, 0, size);
            multiMap = temp;
        }
        multiMap[size++] = pair;
        sortKeys();
    }

    void sortKeys(){
        for (int j = size - 2; j >= 0; j--){
            if (multiMap[j + 1].key.compareTo(multiMap[j].key) < 0){
                ComparablePair temp = multiMap[j];
                multiMap[j] = multiMap[j + 1];
                multiMap[j + 1] = temp;
            }
            else{
                break;
            }
        }
    }

    public Object find(Object key){
        if (key == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        Comparable compKey = (Comparable) key;
        int low = 0;
        int high = size;
        while (low < high){
            int mid = (low + high) / 2;
            ComparablePair elem = multiMap[mid];
            if (elem.key.equals(compKey)){
                return elem.value;
            }
            else if (elem.key.compareTo(compKey) > 0){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return null;
    }

    public Object[] findAll(Object key){
        if (key == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        Object[] toReturn = new Object[size];
        int index = 0;
        for (int i = 0; i < size && multiMap[i].key.compareTo(key) <= 0; i++){
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

    private class ComparablePair{
        Comparable key;
        Object value;
        public ComparablePair(Comparable k, Object v){
            key = k;
            value = v;
        }
    }
}