package ADTs.Queue;
public class FixedArrayQueue implements QueueInterface{
    protected Object[] queue;
    protected int front;
    protected int back;

    public FixedArrayQueue(int _size){
        queue = new Object[_size];
        makeEmpty();
    }

    public void makeEmpty(){
        front = 0;
        back = 0;
    }

    public boolean isEmpty(){
        return (front == back);
    }

    public void enqueue(Object elem){
        if (back == queue.length){
            throw new FullQueueException();
        }
        queue[back++] = elem;
    }

    public Object dequeue(){
        Object r = getFront();
        front++;
        return r;
    }

    public Object getFront(){
        if (isEmpty()){
            throw new EmptyQueueException();
        }
        return queue[front];
    }
}