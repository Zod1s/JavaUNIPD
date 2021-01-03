package ADTs.Stack;
public class FixedArrayStack implements StackInterface{
    protected Object[] stack;
    protected int size;

    public FixedArrayStack(int _size){
        stack = new Object[_size];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void push(Object elem){
        if (size == stack.length){
            throw new FullStackException();
        }
        stack[size++] = elem;
    }

    public Object pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Object r = stack[--size];
        stack[size + 1] = null;
        return r;
    }

    public Object top(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }
}
