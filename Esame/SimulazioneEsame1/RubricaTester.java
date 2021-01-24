// nome e cognome del candidato, matricola, data, numero della postazione
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

public class RubricaTester{
    public static void main(String[] args){
        // ....... da completare ............
        if (args.length != 2){
            System.out.println("Devono esserci esattamente 2 argomenti");
            throw new IllegalArgumentException();
        }
        String toRead = args[0];
        String toWrite = args[1];
        Rubrica r1 = new Rubrica();
        Rubrica r2 = new Rubrica();
        try(Scanner s = new Scanner(System.in); FileReader reader = new FileReader(toRead); Scanner file = new Scanner(reader); PrintWriter writer = new PrintWriter(toWrite);){
            while (file.hasNextLine()){
                String toParse = file.nextLine();
                Scanner parser = new Scanner(toParse);
                String name = parser.next();
                parser.next();
                long num = parser.nextLong();
                r1.insert(name, num);
                parser.close();
            }
            System.out.println(r1);

            while(true){
                System.out.println("Inserire un nome dalla prima rubrica");
                String input = s.nextLine();
                if (input.equalsIgnoreCase("Q")){
                    break;
                }
                try{
                    r2.insert(input, r1.find(input));
                    r1.remove(input);
                }
                catch (MapItemNotFoundException e){
                    System.out.println("Nome non trovato");
                }
            }
            String r2S = r2.toString();
            Scanner parser = new Scanner(r2S);
            while (parser.hasNextLine()){
                writer.println(parser.nextLine());
            }
            parser.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Nome dei file non corretti");
        }
        catch (IOException e){
            System.out.println("Generica eccezione IO");
        }
    }
}


class Rubrica implements Map{
    private Pair[] map;
    private int size;

    public Rubrica(){
        map = new Pair[1];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }
    //metodi di Rubrica ......da completare ......

    public void insert(Comparable key, Object num){
        if (key == null || !(key instanceof String) || !(num instanceof Long)) throw new IllegalArgumentException();
        Pair p = new Pair((String) key, (Long) num);
        try{
            remove(key);
        }
        catch (Exception e){

        }
        if (size == map.length){
            Pair[] temp = new Pair[2 * size];
            System.arraycopy(map, 0, temp, 0, size);
            map = temp;
        }
        map[size++] = p;
        for (int i = size - 2; i >= 0; i--){
            if (map[i + 1].getName().compareTo(map[i].getName()) < 0){
                Pair temp = map[i];
                map[i] = map[i + 1];
                map[i + 1] = temp;
            }
        }
    }

    public void remove(Comparable key){
        if (key == null || !(key instanceof String)) throw new IllegalArgumentException();
        int index = binSearch(key);
        for (int i = index; i < size; i++){
            map[i] = map[i + 1];
        }
        size--;
    }

    public Object find(Comparable key){
        if (key == null || !(key instanceof String)) throw new IllegalArgumentException();
        return map[binSearch(key)].getPhone();
    }

    private int binSearch(Comparable key){
        int low = 0;
        int high = size;
        while (low < high){
            int mid = (low + high) / 2;
            Object m = map[mid].getName();
            if (key.equals(m)){
                return mid;
            }
            else if (key.compareTo(m) < 0){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        throw new MapItemNotFoundException();
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < size; i++){
            ret += map[i].toString() + "\n";
        }
        return ret;
    }   // ..... da completare .........

    //campi di esemplare di Rubrica ..... da completare ......


    //classe privata Pair: non modificare!!
    private class Pair{
        //campi di esemplare
        private String name;
        private long phone;
        public Pair(String aName, long aPhone){
            name= aName;
            phone = aPhone;
        }
        public String getName(){
            return name;
        }
        public long getPhone(){
            return phone;
        }
        /*
            Restituisce una stringa contenente
            - la nome, "name"
            - un carattere di separazione ( : )
            - il numero telefonico, "phone"
        */
        public String toString(){
            return name + " : " + phone;
        }
    }
}


interface Map{
    /*
        verifica se la mappa contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();
    
    /*Map
        svuota la mappa
    */
    void makeEmpty();

    /*
     Inserisce un elemento nella mappa. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta alla mappa; 
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dalla mappa l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata MapItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nella mappa l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata MapItemNotFoundException
    */
    Object find(Comparable key);
}

class MapItemNotFoundException extends RuntimeException {}
