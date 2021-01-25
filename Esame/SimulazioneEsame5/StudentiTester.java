// nome e cognome del candidato, matricola, data, numero postazione

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

public class StudentiTester{
    public static void main(String[] args){
      // ....... da completare ............
        if (args.length != 2) throw new IllegalArgumentException();
        String toRead = args[0];
        String toWrite = args[1];
        Studenti stud1 = new Studenti();
        Studenti stud2 = new Studenti();
        try (Scanner s = new Scanner(System.in); FileReader reader = new FileReader(toRead); Scanner parser = new Scanner(reader); PrintWriter writer = new PrintWriter(toWrite);){
            while (parser.hasNextLine()){
                Scanner line = new Scanner(parser.nextLine());
                long matr = line.nextLong();
                line.next();
                String name = line.next();
                while (line.hasNext()){
                    name += " " + line.next();
                }
                stud1.insert(matr, name);
            }
            System.out.println(stud1);

            boolean done = false;
            while (!done){
                System.out.println("Inserire un numero di matricola, Q per uscire");
                String cmd = s.nextLine();
                if (cmd.equalsIgnoreCase("Q")){
                    done = true;
                }
                else {
                    try{
                        long newMatr = Long.parseLong(cmd);
                        stud2.insert(newMatr, stud1.find(newMatr));
                        stud1.remove(newMatr);
                    }
                    catch (NumberFormatException e){
                        System.err.println("Errore nella lettura della matricola");
                    }
                    catch (DictionaryItemNotFoundException e){
                        System.err.println("Elemento non presente nel dizionario");
                    }
                }
            }

            writer.print(stud2);
        }
        catch (FileNotFoundException e){
            System.err.println("Non trovato il file");
        }
        catch (IOException e){
            System.err.println("Generico errore IO");
        }
    }
}


class Studenti implements Dictionary{
    //costruttori e metodi pubblici ......da completare ......
    private Pair[] dict;
    private int size;

    public Studenti(){
        dict = new Pair[1];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void insert(Comparable key, Object value){
        if (key == null || !(key instanceof Long) || value == null || !(value instanceof String)) throw new IllegalArgumentException();
        try{
            remove(key);
        }
        catch (DictionaryItemNotFoundException e){
            // lasciato vuoto
        }

        if (size == dict.length){
            Pair[] temp = new Pair[2 * size];
            System.arraycopy(dict, 0, temp, 0, size);
            dict = temp;
        }

        dict[size++] = new Pair((Long) key, (String) value);
        for (int i = size - 2; i >= 0; i--){
            if (dict[i].getMatr() > dict[i + 1].getMatr()){
                Pair temp = dict[i];
                dict[i] = dict[i + 1];
                dict[i + 1] = temp;
            }
            else{
                break;
            }
        }
    }

    public void remove(Comparable key){
        if (key == null || !(key instanceof Long)) throw new IllegalArgumentException();
        int index = binSearch(key);
        for (int i = index; i < size - 1; i++){
            dict[i] = dict[i + 1];
        }
        dict[--size] = null;
    }

    public Object find(Comparable key){
        if (key == null || !(key instanceof Long)) throw new IllegalArgumentException();
        int index = binSearch(key);
        return dict[index].getName();
    }

    private int binSearch(Comparable key){
        long k = (Long) key;
        int low = 0;
        int high = size;
        while (low < high){
            int mid = (low + high) / 2;
            if (dict[mid].getMatr() == k){
                return mid;
            }
            else if (dict[mid].getMatr() < k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        throw new DictionaryItemNotFoundException();
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < size; i++){
            ret += dict[i] + "\n";
        }
        return ret;
    }   // ..... da completare .........
    
    //campi di esemplare  ..... da completare ......


    //classe privata Pair: non modificare!!
    private class Pair{
        public Pair(long matr, String name){
            this.matr=matr;
            this.name=name;
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