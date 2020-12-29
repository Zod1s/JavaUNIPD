public class DequeStack extends ArrayDeque{
    public DequeStack(){
        super();
    }

    public void push(Object element){
        addLast(element);
    }

    public Object pop(){
        return removeLast();
    }

    public Object top(){
        return getLast();
    }
}
