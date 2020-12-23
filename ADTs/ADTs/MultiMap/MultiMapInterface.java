package ADTs.MultiMap;
import ADTs.Container.*;
public interface MultiMapInterface extends Container{
    void put(Object key, Object value);
    Object get(Object key);
    Object[] getAll(Object key);
    Object remove(Object key);
    Object[] removeAll(Object key);
    Object[] keys();
}