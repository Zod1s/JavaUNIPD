package ADTs.Stack;
public class VariableSizeStack extends FixedArrayStack{
    public VariableSizeStack(int _size){
        super(_size);
    }

    public void push(Object elem){
        if (size == stack.length){
            Object[] temp = new Object[size * 2];
            for (int i = 0; i < size; i++){
                temp[i] = stack[i];
            }
            stack = temp;
        }
        super.push(elem);
    }
}