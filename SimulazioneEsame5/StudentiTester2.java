// nome e cognome del candidato, matricola, data,       numero postazione
import java.util.*;
import java.io.*;

public class StudentiTester2{
    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("Inserire i nomi dei file");
            System.exit(1);
        }
        Studenti s1 = new Studenti();
        Studenti s2 = new Studenti();
        String done = "";
        Scanner c = new Scanner(System.in);
        try (Scanner file1 = new Scanner(new FileReader(args[0]))){
            while (file1.hasNextLine()){
                String nome = "";
                long mat = 0;
                Scanner riga = new Scanner(file1.nextLine());
                try{
                    mat = Long.parseLong(riga.next());
                }
                catch (NumberFormatException e){
                    System.err.println("Dati nei file non validi!");
                    System.exit(1);
                }
                riga.next();
                while (riga.hasNext())
                    nome += riga.next();
                s1.insert(mat,nome);
            }
        }
        catch (IOException e){
            System.err.println("Errore nei file");
            System.exit(1);
        }
        while (!(done.equalsIgnoreCase("q"))){
            System.out.println("Inserisci una matricola: ");
            done = c.nextLine();
            long mat = 0;
            String element;
            try{
                mat = Long.parseLong(done);
            }
            catch (NumberFormatException e){
                System.err.println("Matricola non valida");
                continue;
            }
            try{
                element = (String)s1.find(mat);
                s1.remove(mat);
                s2.insert(mat,element);
            }
            catch (DictionaryItemNotFoundException e){ 
                System.err.println("Numero di matricola non trovato");
            }
        }
        try (PrintWriter file2 = new PrintWriter(args[1])){
            file2.println(s2.toString());
        }
        catch (IOException e){
            System.err.println("Errore nel file!");
            System.exit(1);
        }
        c.close();
    }
}


class Studenti implements Dictionary{
    private Pair[] v;
    private int vSize;
    private final static int CAPACITY = 1;

    public Studenti(){
        v = new Pair[CAPACITY];
        makeEmpty();
    }
    /*
        verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    public boolean isEmpty(){
        return vSize == 0;
    }

    /*
        svuota il dizionario
    */
    public void makeEmpty(){
        vSize = 0;
    }

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia', il valore ad essa associato viene sovrascritto 
     col nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    public void insert(Comparable key, Object value){
        if (key == null || !(key instanceof Long) || value == null || !(value instanceof String)) new IllegalArgumentException();
        int index = 0;
        try{
            index = binarySearch(key);
            v[index] = new Pair((long) key, (String) value);
        }
        catch (DictionaryItemNotFoundException e){
            if (vSize == v.length)
                v = resize(2 * vSize);
            for (index = 0; index < vSize && key.compareTo(v[index].getMatr()) > 0; index++){}
            for (int i = vSize; i > index; i--)
                v[i] = v[i - 1];
            v[index] = new Pair((long) key,(String) value);
            vSize++;
        }
    }

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    public void remove(Comparable key){
        if (key == null || !(key instanceof Long)) throw new IllegalArgumentException();
        int index = binarySearch(key);
        for (int i = index; i < vSize - 1; i++){
            v[i] = v[i + 1];
        }
        vSize--;
    }

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    public Object find(Comparable key){
        if (key == null || !(key instanceof Long)) throw new IllegalArgumentException();
        int index = binarySearch(key);
        return v[index].getName();
    }
   
    public int size(){
        return vSize;
    }  
    
    public String toString(){
        String s = "";
        for (int i = 0; i < vSize; i++){
            s += "\n" + v[i];
        }
        return s;
    }   // ..... da completare .........
    
    private int binarySearch(Comparable key){
        if (key == null || !(key instanceof Long)) throw new IllegalArgumentException();
        if (vSize == 0) throw new DictionaryItemNotFoundException();
        int from = 0;
        int to = vSize;
        while (from < to){
            int mid = (from + to) / 2;
            Comparable midKey = v[mid].getMatr();
            if (key.compareTo(midKey) < 0){
                to = mid - 1;
            }
            else if (key.compareTo(midKey) > 0){
                from = mid + 1;
            }
            else{
                return mid;
            }
        }
        throw new DictionaryItemNotFoundException();
        /*if(from>=to) throw new DictionaryItemNotFoundException();
        int mid=(from+to)/2;
        Comparable midVal=v[mid].getMatr();
        if(midVal.compareTo(key)>0)
            return binarySearch(key,from,mid-1);
        else if(midVal.compareTo(key)<0)
            return binarySearch(key,mid+1,to);
        else
            return mid; */
    }

    private Pair[] resize(int dim){
        Pair[] nuovo = new Pair[dim];
        System.arraycopy(v, 0, nuovo, 0,vSize);
        return nuovo;
    }

    //classe privata Pair: non modificare!!
    private class Pair{
        public Pair(long matr, String name){
            this.matr = matr;
            this.name = name;
        }
        public long getMatr(){
            return matr;
        }
        public String getName(){
            return name;
        }
        /*
            Restituisce una stringa contenente
            - il numero di matricola, (numero long contenuto in "matr")
            - un carattere di separazione ( : )
            - il nome (stringa di una o piu` parole contenuta in "name")
        */
        public String toString(){
            return matr + " : " + name;
        }
        //campi di esemplare
        private long matr;
        private String name;
    }
}

interface Dictionary{
    /*
        verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();
    
    /*
        svuota il dizionario
    */
    void makeEmpty();

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia', il valore ad essa associato viene sovrascritto 
     col nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException {}