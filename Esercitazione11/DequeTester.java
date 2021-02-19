import java.util.Scanner;
public class DequeTester{
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // ArrayDeque deque1 = new ArrayDeque();
        // ArrayDeque deque2 = new ArrayDeque();
        // ArrayDeque deque3 = new ArrayDeque();
        // System.out.println("Inserire una sequenza di numeri (CTRL-D per terminare): ");
        // while (s.hasNextInt()){
        //     deque1.addLast(s.nextInt());
        // }

        // while (!deque1.isEmpty()){
        //     deque2.addFirst(deque1.removeLast());
        // }

        // while (!deque2.isEmpty()){
        //     deque3.addLast(deque2.removeFirst());
        // }

        // while(!deque3.isEmpty()){
        //     System.out.println(deque3.removeFirst());
        // }

        // s.close();

        DequeStack stack = new DequeStack();
        stack.push(10);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}