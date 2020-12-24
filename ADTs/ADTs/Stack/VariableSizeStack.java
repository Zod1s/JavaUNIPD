package ADTs.Stack;
public class VariableSizeStack extends FixedArrayStack{
    public VariableSizeStack(int _size){
        super(_size);
    }

    public void push(Object elem){
        if (size == stack.length){
            Object[] temp = new Object[size * 2];
            System.arraycopy(stack, 0, temp, 0, size);
            stack = temp;
        }
        super.push(elem);
    }
}