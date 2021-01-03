package ADTs.Table;
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

    public Object remove(int key){
        if (key < 0 || key >= 100){
            throw new InvalidPositionTableException();
        }
        Object r = table[key];
        table[key] = null;
        size--;
        return r;
    }

    public Object get(int key){
        if (key < 0 || key >= 100){
            throw new InvalidPositionTableException();
        }
        return table[key];
    }
}