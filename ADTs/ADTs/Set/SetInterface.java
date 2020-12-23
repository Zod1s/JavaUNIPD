package ADTs.Set;
import ADTs.Container.*;
public interface SetInterface extends Container{
    void add(Object elem);
    boolean contains(Object elem);
    Object[] toArray();
}