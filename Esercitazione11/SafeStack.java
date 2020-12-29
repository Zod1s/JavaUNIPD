public class SafeStack implements SafeStackInterface{
    private String[] stack;
    private int size;

    public SafeStack(int _size){
        stack = new String[_size];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void push(String elem){
        if (size == stack.length){
            String[] temp = new String[size * 2];
            System.arraycopy(stack, 0, temp, 0, size);
            stack = temp;
        }
        stack[size++] = elem;
    }

    public String pop(){
        String r = top();
        size--;
        return r;
    }

    public String top(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }
}
