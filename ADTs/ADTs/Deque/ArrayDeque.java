package ADTs.Deque;
public class ArrayDeque implements DequeInterface{
    private Object[] deque;
    private int front; // points to the cell after the one that is going to be written
    private int back; // points to the cell that is going to be written

    public ArrayDeque(){
        deque = new Object[16];
        makeEmpty();
    }

    public void makeEmpty(){
        front = 0;
        back = 0;
    }

    public boolean isEmpty(){
        return (front == back);
    }

    public void addFirst(Object element){
        if (element == null) throw new IllegalArgumentException();
        if (decrement(front) == back){
            Object[] temp = new Object[2 * deque.length];
            System.arraycopy(deque, 0, temp, 0, deque.length);
            if (back < front){
                System.arraycopy(temp, 0, temp, deque.length, back);
            }
            front = temp.length;
            back = deque.length;
            deque = temp;
        }
        front = decrement(front);
        deque[front] = element;
    }

    public void addLast(Object element){
        if (element == null) throw new IllegalArgumentException();
        if (front == increment(back)){
            Object[] temp = new Object[2 * deque.length];
            System.arraycopy(deque, 0, temp, 0, deque.length);
            if (back < front){
                System.arraycopy(temp, 0, temp, deque.length, back);
            }
            front = temp.length - 1;
            back = deque.length;
            deque = temp;
        }
        deque[back] = element;
        back = increment(back);
    }

    public Object getFirst(){
        if (isEmpty()) throw new EmptyDequeException();
        return deque[front];
    }

    public Object getLast(){
        if (isEmpty()) throw new EmptyDequeException();
        return deque[back - 1];
    }

    public Object removeFirst(){
        if (isEmpty()) throw new EmptyDequeException();
        Object r = deque[front];
        deque[front] = null;
        front = increment(front);
        return r;
    }

    public Object removeLast(){
        if (isEmpty()) throw new EmptyDequeException();
        Object r = deque[back - 1];
        deque[back - 1] = null;
        back = decrement(back);
        return r;
    }

    protected int increment(int index){
        return (index + 1) % deque.length;
    }

    protected int decrement(int index){
        // int newIndex = index - 1;
        // if (newIndex >= 0){
        //     return newIndex;
        // }
        // else{
        //     return deque.length - 1;
        // }
        if (index == 0){
            return deque.length - 1;
        }
        else{
            return index - 1;
        }
    }

    public String toString(){
        String string = "[";
        for (int i = 0; i < deque.length; i++){
            string += deque[i] + " ";
        }
        string = string.substring(0, string.length() - 1) + "]";
        return string;
    }
}
