import ADTs.Stack.*;

public class ADTTester {
    public static void main(String[] args){
        VariableSizeStack stack = new VariableSizeStack(1);
        stack.push(10);
        stack.push(100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}