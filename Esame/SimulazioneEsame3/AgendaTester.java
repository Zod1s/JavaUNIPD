// nome e cognome del candidato, matricola, data, numero della postazione

// import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class AgendaTester{
    public static void main(String[] args){
      // ....... da completare ............
        Agenda agenda = new Agenda();
        Scanner s = new Scanner(System.in);
        boolean done = false;
        while (!done){
            try{
                System.out.print("Inserire un comando [I, L, R, Q]: ");
                String cmd = s.nextLine();
                if (cmd.equalsIgnoreCase("Q")){
                    done = true;
                }
                else if (cmd.equalsIgnoreCase("I")){
                    System.out.println("Inserire un impegno nella forma [Priorità] [Impegno]");
                    Scanner parser = new Scanner(s.nextLine());
                    int pr = parser.nextInt();
                    Scanner parser2 = new Scanner(parser.nextLine());
                    String memo = parser2.next();
                    while (parser2.hasNext()){
                        memo += " " + parser2.next();
                    }
                    agenda.insert(pr, memo);
                    parser.close();
                    parser2.close();
                }
                else if (cmd.equalsIgnoreCase("R")){
                    try{
                        Object memo = agenda.removeMin();
                        System.out.println(memo);
                    }
                    catch (EmptyQueueException e){
                        System.err.println("L'agenda è vuota");
                    }
                }
                else if (cmd.equalsIgnoreCase("L")){
                    try{
                        Object memo = agenda.getMin();
                        System.out.println(memo);
                    }
                    catch (EmptyQueueException e){
                        System.err.println("L'agenda è vuota");
                    }
                }
                System.out.println("\nAgenda: ");
                System.out.println(agenda);
            }
            catch (NoSuchElementException e){
                System.err.println("Errore nell'inserimento, riprovare");
            }
            catch (NumberFormatException e){
                System.err.println("Errore nell'inserimento, riprovare");
            }
        }
        s.close();
    }
}

class Agenda implements PriorityQueue{
    private Impegno[] agenda;
    private int size;
    // private int front;
    // private int back;
    public Agenda(){
        agenda = new Impegno[1];
        makeEmpty();
    }
    //costruttori e metodi pubblici ......da completare ......

    public void makeEmpty(){
        size = 0;
        // front = 0;
        // back = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void insert (int key, Object value){
        if (value == null || !(value instanceof String) || key < 0 || key > 3) throw new IllegalArgumentException();
        if (size == agenda.length){
            Impegno[] temp = new Impegno[2 * size];
            System.arraycopy(agenda, 0, temp, 0, size);
            agenda = temp;
        }
        Impegno imp = new Impegno(key, (String) value);
        agenda[size++] = imp;
        for (int i = size - 2; i >= 0; i--){
            if (agenda[i].getPriority() <= agenda[i + 1].getPriority()){
                Impegno temp = agenda[i];
                agenda[i] = agenda[i + 1];
                agenda[i + 1] = temp;
            }
            else{
                break;
            }
        }
    }

    public Object removeMin() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException();
        Impegno temp = agenda[--size];
        agenda[size] = null; // per aiutare il garbage collector
        return temp.getMemo();
    }

    public Object getMin() throws EmptyQueueException{
        if (isEmpty()) throw new EmptyQueueException();
        return agenda[size - 1].getMemo();
    }

    public String toString(){
        String ret = "";
        for (int i = size - 1; i >= 0; i--){
            ret += agenda[i] + "\n";
        }
        return ret;
    }   // ..... da completare .........

    //campi di esemplare  ..... da completare ......

    /*
        classe privata Impegno: rappresenta gli elementi della classe Agenda ed
        e` costituita da coppie "chiave valore" in cui il campo chiave e` di
        tipo int e rappresenta la priorita` dell'impegno, e il campo valore e`
        una stringa contenente un promemoria dell'impegno. Si considerano 4 
        livelli di priorita`, numerati da 0 a 3. Conseguentemente il campo 
        chiave puo` assumere valori solo in questo intervallo, dove il valore 0  
        significa "massima priorita`" e il valore 3 significa "minima priorita`" 
    */
    private class Impegno //non modificare!!
    {   public Impegno(int priority, String memo)
        {   if (priority>3 || priority<0) throw new IllegalArgumentException();
            this.priority = priority;
            this.memo = memo;
        }
        // metodi (pubblici) di accesso
        public int getPriority()
        {   return priority; }
        public Object getMemo()
        {   return memo; }
        //metodo toString sovrascritto
        public String toString()
        {   return priority + " " + memo; }
        //campi di esemplare (privati) della classe Impegno
        private int priority; //priorita` dell'impegno (da 0 a 3)
        private String memo; //promemoria dell'impegno
    }    
}


/*  
    Interfaccia PriorityQueue (non modificare!!). 
    - Questo tipo di dato astratto definisce un contenitore di coppie 
      "chiave valore", dove il campo chiave e` un numero in formato int che 
      specifica il livello di priorita` della coppia mentre il campo valore 
      rappresenta il dato della coppia. 
    - Si assume che date due chiavi k1 e k2 tali che k1 < k2, allora k1 ha 
      priorita` piu` alta di k2.
    - Naturalmente possono essere presenti nel contenitore coppie diverse con 
      chiavi uguali, cioe` con uguale priorita`
*/
interface PriorityQueue //non modificare!!
{   /*
        svuota la coda di priorita`
    */
    void makeEmpty();
  
    /*
        restituisce true se la coda e' vuota, false altrimenti
    */
    boolean isEmpty();

    /*
        Metodo di inserimento
        Inserisce la coppia "chiave valore" nella coda di priorita`. Notare che 
        la coda di priorita` puo` contenere piu` coppie con la stessa chiave.
        Questo perche` il campo chiave non serve ad identificare univocamente
        un elemento (come nel caso di un dizionario), ma serve invece a definire
        la priorita` di un elemento. E` ovvio che piu` elementi possono avere 
        la stessa priorita`. 
    */
    void insert (int key, Object value);

    /*
        Metodo di rimozione
        Rimuove dalla coda la coppia con chiave minima, e restituisce un 
        riferimento al suo campo value. Se sono presenti piu` coppie con chiave
        minima, effettua la rimozione di una qualsiasi delle coppie con chiave 
        minima (ad es. la prima coppia con chiave minima che e` stata trovata)
        Lancia EmptyQueueException se la coda di priorita` e` vuota
    */
    Object removeMin() throws EmptyQueueException;

    /*
        Metodo di ispezione
        Restituisce un riferimento al campo value della coppia con chiave minima
        (ma *non* rimuove la coppia dalla coda).  Se sono presenti piu` coppie 
        con chiave minima, restituisce il campo value di una qualsiasi delle   
        coppie con chiave minima (ad esempio la prima coppia con chiave minima 
        che e` stata trovata). Lancia EmptyQueueException se la coda e` vuota
    */
    Object getMin() throws EmptyQueueException;
}

/*
    Eccezione lanciata dai metodi removeMin e getMin di PriorityQueue quando
    la coda di priorita` e` vuota 
*/
class EmptyQueueException extends RuntimeException {}
