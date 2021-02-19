public class DequeStack extends ArrayDeque{
    public DequeStack(){
        super();
    }

    public void push(Object element){
        super.addLast(element);
    }

    public Object pop(){
        if (isEmpty()){
            throw new IllegalArgumentException();
        }
        return super.removeLast();
    }

    public Object top(){
        if (isEmpty()){
            throw new IllegalArgumentException();
        }
        return super.getLast();
    }
    
    public void addFirst(Object element){
        return;
    }

    public void addLast(Object element){
        return;
    }

    public Object getFirst(){
        return null;
    }

    public Object getLast(){
        return null;
    }

    public Object removeFirst(){
        return null;
    }

    public Object removeLast(){
        return null;
    }
}