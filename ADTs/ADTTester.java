import ADTs.Queue.*;
public class ADTTester {
    public static void main(String[] args){
        CircularVariableArrayQueue queue = new CircularVariableArrayQueue(1);
        queue.enqueue(10);
        queue.enqueue(11);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}