package ADTs.Queue;
public class CircularFixedArrayQueue extends FixedArrayQueue{
    public CircularFixedArrayQueue(int _size){
        super(_size);
    }

    public void enqueue(Object elem){
        if (increment(back) == front){
            throw new FullQueueException();
        }
        queue[back] = elem;
        back = increment(back);
    }

    public Object dequeue(){
        Object r = getFront();
        front = increment(front);
        return r;
    }

    protected int increment(int n){
        return (n + 1) % queue.length;
    }
}