// nome e cognome del candidato, matricola, data, numero della postazione
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiQueueTester{
    public static void main(String[] args){
        if (args.length != 1) throw new IllegalArgumentException();
        int n = Integer.parseInt(args[0]);
        ArrayMultiQueue queue = new ArrayMultiQueue(n);
        boolean done = false;
        Scanner s = new Scanner(System.in);
        while (!done){
            System.out.println("Inserire un comando [A, R, P, Q]");
            String cmd = s.nextLine();
            if (cmd.equalsIgnoreCase("Q")){
                done = true;
            }
            else if (cmd.equalsIgnoreCase("A")){
                System.out.println("Inserire un nome da inserire in coda");
                String name = s.nextLine();
                queue.add(name);
            }
            else if (cmd.equalsIgnoreCase("R")){
                System.out.println("Inserire l'indice della coda da rimuovere");
                boolean finish = false;
                int index;
                do{
                    try{
                        index = s.nextInt();
                        System.out.println("Elemento rimosso: " + queue.remove(index));
                        finish = true;
                        s.nextLine();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Nessun intero trovato");
                        s.nextLine();
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("Non è stato inserito un indice valido");
                        s.nextLine();
                    }
                    catch (EmptyQueueException e){
                        System.out.println("La coda selezionata è vuota");
                        s.nextLine();
                        finish = true;
                    }
                } while (!finish);
            }
            else if (cmd.equalsIgnoreCase("P")){
                System.out.println(queue);
            }
        }
        s.close();
    }
}

//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia Queue usando un array (array riempito
// solo in parte, oppure array riempito solo nella parte centrale, oppure
// array circolare), con o senza ridimensionamento. La classe sovrascrive 
// il metodo toString
// ....... da completare ............

class ArrayQueue implements Queue{
    private Object[] queue;
    private int front;
    private int back;
    private int vSize;
    //metodi pubblici dell'interfaccia Queue ......da completare ......
    // ...

    public ArrayQueue(){
        queue = new Object[1];
        makeEmpty();
    }

    public void makeEmpty(){
        front = 0;
        back = 0;
        vSize = 0;
    }

    public boolean isEmpty(){
        return (vSize == 0);
    }

    public int size(){
        return vSize;
    }

    public void enqueue(Object obj){
        if (obj == null) throw new IllegalArgumentException();
        if (increment(back) == front){
            Object[] temp = new Object[2 * queue.length];
            System.arraycopy(queue, 0, temp, 0, queue.length);
            queue = temp;
            if (back < front){
                System.arraycopy(queue, 0, queue, queue.length / 2, queue.length / 2);
                back += queue.length / 2;
            }
        }
        queue[back] = obj;
        back = increment(back);
        vSize++;
    }

    public Object dequeue() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException();
        Object ret = queue[front];
        front = increment(front);
        vSize--;
        return ret;
    }

    public Object getFront() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException();
        return queue[front];
    }

    //metodo toString ..... da completare .........
    public String toString(){
        // System.out.println("toString queue");
        String ret = "";
        int i = front;
        boolean done = false;
        while (!done){
            if (i == back){
                done = true;
            }
            else{
                ret += queue[i] + "\n";
                i = increment(i);
            }
        }
        return ret;
    }

    private int increment(int i){
        return (i + 1) % queue.length;
    }

    //campi di esemplare ..... da completare ......
}

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto coda

interface Queue{
    // Restituisce true se la coda e` vuota. Restituisce false se la coda
    // contiene almeno un elemento
    boolean isEmpty();

    // Svuota la coda
    void makeEmpty();
  
    // Restituisce il numero di elementi presenti nella coda
    int size();

    // Inserisce l'oggetto obj nella coda
    void enqueue(Object obj);

    // Elimina dalla coda il primo oggetto, e lo restituisce.
    // Lancia EmptyQueueException se la coda e` vuota
    Object dequeue() throws EmptyQueueException;

    // Restituisce il primo oggetto della coda, senza estrarlo
    // Lancia EmptyQueueException se la coda e` vuota
    Object getFront() throws EmptyQueueException;
}

//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia MultiQueue usando un array di N code. 
// La classe sovrascrive il metodo toString
// ....... da completare ............

class ArrayMultiQueue implements MultiQueue{
    private ArrayQueue[] queues;
    //costruttore ......da completare ......
    // crea una multicoda vuota, costituita da una sequenza di N code vuote,
    // con N > 0
    public ArrayMultiQueue(int N){
        queues = new ArrayQueue[N];
        for (int i = 0; i < N; i++){
            queues[i] = new ArrayQueue();
        }
        makeEmpty();
    }

    public boolean isEmpty(){
        for (int i = 0; i < queues.length; i++){
            if (!queues[i].isEmpty()){
                return false;
            }
        }
        return true;
    }

    public void makeEmpty(){
        for (int i = 0; i < queues.length; i++){
            queues[i].makeEmpty();
        }
    }

    private int findMin(){
        int min = 0;
        for (int i = 1; i < queues.length; i++){
            if (queues[min].size() > queues[i].size()){
                min = i;
            }
        }
        return min;
    }

    public void add(Object obj){
        int index = findMin();
        queues[index].enqueue(obj);
    }

    public Object remove(int i){
        if (i < 0 || i >= queues.length) throw new IllegalArgumentException();
        return queues[i].dequeue();
    }

    //metodi pubblici dell'interfaccia MultiQueue ......da completare ......
    // ...

    //metodo toString ..... da completare .........
    public String toString(){
        // System.out.println("toString multiqueue");
        String ret = "";
        for (int i = 0; i < queues.length; i++){
            ret += "Coda: " + i + "\n" + queues[i];
        }
        return ret;
    }

    //campi di esemplare ..... da completare ......
}

//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto "multicoda".
// Una multicoda e` una sequenza di N code. Ciascuna delle N code e` 
// identificata da un indice intero i, dove 0 <= i < N.

interface MultiQueue{
    // Restituisce true se la multicoda e` vuota, cioe` se tutte le N
    // code della multicoda sono vuote. Restituisce false se la multicoda
    // contiene almeno un elemento, cioe` se almeno una delle N code della
    // multicoda contiene almeno un elemento
    boolean isEmpty();

    // Svuota la multicoda, cioe` svuota tutte le N code della multicoda
    void makeEmpty();
  
    // Inserisce l'oggetto obj nella multicoda. Tra tutte le N code della
    // multicoda, l'oggetto viene accodato a quella che contiene il minor
    // numero di elementi. Nel caso in cui piu` code contengano un numero
    // di elementi pari al minimo, la scelta è indifferente
    void add(Object obj);

    // Disaccoda dalla i-esima coda il suo primo elemento e lo restituisce.
    // L'indice intero i specifica quale e` la coda da cui disaccodare il 
    // primo elemento. Di conseguenza i deve essere tale che 0 <= i < N.
    // Lancia EmptyQueueException se la la i-esima coda e` vuota
    Object remove(int i) throws EmptyQueueException;
}

// NON MODIFICARE!
// Eccezione lanciata da dequeue e getFront quando la coda e` vuota

class EmptyQueueException extends RuntimeException { }