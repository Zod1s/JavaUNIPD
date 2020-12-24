package ADTs.Queue;
public class CircularVariableArrayQueue extends CircularFixedArrayQueue{
    public CircularVariableArrayQueue(int _size){
        super(_size);
    }

    public void enqueue(Object elem){
        if (increment(back) == front){
            Object[] temp = new Object[queue.length * 2];
            System.arraycopy(queue, 0, temp, 0, queue.length);
            queue = temp;
            if (back < front){
                System.arraycopy(queue, 0, queue, queue.length / 2, back);
                back += queue.length / 2;
            }
        }
        super.enqueue(elem);
    }
}