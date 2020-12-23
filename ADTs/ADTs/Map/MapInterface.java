package ADTs.Map;
import ADTs.Container.*;
public interface MapInterface extends Container{
    Object put(Object key, Object value);
    Object get(Object key);
    Object remove(Object key);
    Object[] keys();
}