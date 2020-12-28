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
        for (int i = 0; i < size; i++){
            if (map[i].key.equals(key)){
                Object r = map[i].value;
                map[i] = map[--size];
                return r;
            }
            else if(((Comparable) map[i].key).compareTo(key) > 0){
                return null;
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

    void sortKeys(){
        for (int i = 1; i < size; i++){
            for (int j = i - 1; j >= 0; j--){
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
    }

    public Object get(Object key){
        if (key == null || !(key instanceof Comparable)) throw new IllegalArgumentException();
        for (int i = 0; i < size; i++){
            if (map[i].key.equals(key)){
                return map[i].value;
            }
            else if(((Comparable) map[i].key).compareTo(key) > 0){
                return null;
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
            ks[i] = (Comparable) map[i].key;
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