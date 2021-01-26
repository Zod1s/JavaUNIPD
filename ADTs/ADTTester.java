import ADTs.Deque.*;
import ADTs.Deque.ArrayDeque;

import java.util.*;
public class ADTTester{
    public static void main(String[] args){
        ArrayDeque m = new ArrayDeque();
        m.addFirst(1);
        m.addFirst(2);
        m.addLast(3);
        System.out.println(m.getFirst());
        m.removeFirst();
        m.addLast(4);
        m.addLast(5);
        m.addFirst("5");
        System.out.println(m.removeLast());
        System.out.println(m.removeFirst());
    }
}