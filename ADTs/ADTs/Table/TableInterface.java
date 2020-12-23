package ADTs.Table;
import ADTs.Container.*;
public interface TableInterface extends Container{
    void insert(int key, Object value);
    Object get(int key);
    Object remove(int key);
}