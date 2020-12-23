package ADTs.Queue;
import ADTs.Container.*;
public interface QueueInterface extends Container{
    void enqueue(Object elem);
    Object dequeue();
    Object getFront();
}