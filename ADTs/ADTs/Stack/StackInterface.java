package ADTs.Stack;
import ADTs.Container.*;
public interface StackInterface extends Container{
    void push(Object elem);
    Object pop();
    Object top();
}