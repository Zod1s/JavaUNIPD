public class ArrayTable implements TableInterface{
    private Object[] table;
    private int size;
    public ArrayTable(){
        table = new Object[100];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void insert(int key, Object value){
        if (key < 0 || key >= 100){
            throw new InvalidPositionTableException();
        }
        table[key] = value;
        size++;
    }

    public void remove(int key){
        if (key < 0 || key >= 100){
            throw new InvalidPositionTableException();
        }
        table[key] = null;
        size--;
    }

    public Object find(int key){
        if (key < 0 || key >= 100){
            throw new InvalidPositionTableException();
        }
        return table[key];
    }
}
