package ADTs.Map;
public class MapArray implements MapInterface{
    protected Pair[] map;
    protected int size;

    public MapArray(){
        map = new Pair[1];
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

    public Object remove(Object k){
        for (int i = 0; i < size; i++){
            if (map[i].getKey().equals(k)){
                Object elem = map[i].getValue();
                map[i] = map[--size];
                return elem;
            }
        }
        return null;
    }

    public Object get(Object k){
        for (int i = 0; i < size; i++){
            if (map[i].getKey().equals(k)){
                return map[i].getValue();
            }
        }
        return null;
    }

    public Object put(Object k, Object v){
        if (k == null || v == null) throw new IllegalArgumentException();
        Object elem = remove(k);
        if (size == map.length){
            Pair[] temp = new Pair[size * 2];
            System.arraycopy(map, 0, temp, 0, size);
            map = temp;
        }
        map[size++] = new Pair(k, v);;
        return elem;
    }

    public Object[] keys(){
        Object[] ks = new Object[size];
        for (int i = 0; i < size; i++){
            ks[i] = map[i].getKey();
        }
        return ks;
    }

    private class Pair{
        private Object key;
        private Object value;
        public Pair(Object k, Object v){
            key = k;
            value = v;
        }

        public Object getKey(){
            return key;
        }

        public Object getValue(){
            return value;
        }

        // public void setKey(Object k){
        //     key = k;
        // }

        // public void setValue(Object v){
        //     value = v;
        // }
    }
}