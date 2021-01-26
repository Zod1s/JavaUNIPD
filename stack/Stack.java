public class Stack{
    private Object[] stack;
    private int size;

    public Stack(){
        stack = new Object[1];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void push(Object obj){
        if (obj == null) throw new IllegalArgumentException();
        if (size == stack.length){
            Object[] temp = new Object[size * 2];
            System.arraycopy(stack, 0, temp, 0, size);
            stack = temp;
        }

        stack[size++] = obj;
    }

    public Object pop(){
        if (isEmpty()) throw new IllegalArgumentException();
        return stack[--size];
    }

    public Object top(){
        if (isEmpty()) throw new IllegalArgumentException();
        return stack[size - 1];
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < size; i++){
            ret += stack[i] + " ";
        }
        return ret;
    }
}