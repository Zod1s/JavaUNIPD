public class Stack{
    private Comparable[] stack;
    private int size;

    public Stack(){
        stack = new Comparable[1];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void push(Comparable obj){
        if (obj == null) throw new IllegalArgumentException();
        if (size == stack.length){
            Comparable[] temp = new Comparable[size * 2];
            System.arraycopy(stack, 0, temp, 0, size);
            stack = temp;
        }

        stack[size++] = obj;
    }

    public Comparable pop(){
        if (isEmpty()) throw new IllegalArgumentException();
        return stack[--size];
    }

    public Comparable top(){
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