public interface MapInterface extends Container{
    Object put(Object key, Object value);
    Object get(Object key);
    Object remove(Object key);
    int getSize();
    Object[] keys();
}