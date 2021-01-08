import java.util.*;
public class ListReverse{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        LinkedList list = new LinkedList();
        boolean done = false;
        int n = 0;
        do{
            System.out.println("Inserisci un numero intero maggiore di 0");
            try{
                n = s.nextInt();
                if (n > 0){
                    done = true;
                }
                else{
                    System.out.println("Non è un numero positivo");
                }
            }
            catch(NoSuchElementException e){
                System.out.println("Non è un numero intero");
            }
        } while(!done);
        for (int i = 0; i < n; i++){
            list.addLast(i);
        }
        printReverse(list.getIterator());
        s.close();
    }

    public static void printReverse(ListIterator l){
        Object[] array = new Object[1];
        int size = 0;
        while (l.hasNext()){
            array[size++] = l.next();
            if (size == array.length){
                Object[] temp = new Object[size * 2];
                System.arraycopy(array, 0, temp, 0, size);
                array = temp;
            }
        }
        for (int i = size - 1; i >= 0; i--){
            System.out.println(array[i]);
        }
    }
}