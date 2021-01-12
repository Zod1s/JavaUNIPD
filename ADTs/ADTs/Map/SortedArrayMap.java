package ADTs.Map;
public class SortedArrayMap implements SortedMapInterface{
    private ComparablePair[] map;
    private int size;
    public SortedArrayMap(){
        map = new ComparablePair[1];
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
        int high = size - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            ComparablePair elem = map[mid];
            if (elem.key.equals(key)){
                for (int j = mid; j < size - 1; j++){
                    map[j] = map[j + 1];
                }
                map[size - 1] = null;
                size--;
                return elem.value;
            }
            else if (elem.key.compareTo(compKey) > 0){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return null;
    }

    public Object put(Object key, Object value){
        if (key == null || value == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        ComparablePair pair = new ComparablePair((Comparable) key, value);
        Object toReturn = remove(key);
        if (size == map.length){
            ComparablePair[] temp = new ComparablePair[size * 2];
            System.arraycopy(map, 0, temp, 0, size);
            map = temp;
        }
        map[size++] = pair;
        sortKeys();
        return toReturn;
    }

    private void sortKeys(){
        for (int j = size - 2; j >= 0; j--){
            if (map[j + 1].key.compareTo(map[j].key) < 0){
                ComparablePair temp = map[j + 1];
                map[j + 1] = map[j];
                map[j] = temp;
            }
            else{
                break;
            }
        }
    }

    public Object get(Object key){
        if (key == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        Comparable compKey = (Comparable) key;
        int low = 0;
        int high = size - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            ComparablePair elem = map[mid];
            if (elem.key.equals(key)){
                return elem.value;
            }
            else if (elem.key.compareTo(compKey) > 0){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return null;
    }

    public int getSize(){
        return size;
    }

    public Object[] keys(){
        return sortedKeys();
    }

    public Comparable[] sortedKeys(){
        Comparable[] ks = new Comparable[size];
        for (int i = 0; i < size; i++){
            ks[i] = map[i].key;
        }
        return ks;
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