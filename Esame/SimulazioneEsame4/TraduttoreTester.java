// nome e cognome del candidato, matricola, data, numero della postazione

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.*;

public class TraduttoreTester{
    public static void main(String[] args){
      // ....... da completare ............
        if (args.length != 2) throw new IllegalArgumentException();
        String toRead = args[0];
        String toWrite = args[1];
        Traduttore trad1 = new Traduttore();
        Traduttore trad2 = new Traduttore();
        try (FileReader reader = new FileReader(toRead); Scanner parser = new Scanner(reader); Scanner s = new Scanner(System.in); PrintWriter writer = new PrintWriter(toWrite)){
            while (parser.hasNextLine()){
                Scanner line = new Scanner(parser.nextLine());
                try{
                    parseAdd(trad1, line);
                }
                catch (NoSuchElementException e){
                    System.err.println("Errore nel formato del primo file");
                    return;
                }
            }
            System.out.println(trad1);

            while (s.hasNextLine()){
                Scanner line = new Scanner(s.nextLine());
                try{
                    parseAdd(trad2, line);
                }
                catch (NoSuchElementException e){
                    System.err.println("Errore nel formato della stringa inserita");
                }
                System.out.println();
                System.out.println(trad2);
            }
            trad1.update(trad2);
            writer.print(trad1);
        }
        catch (FileNotFoundException e){
            System.err.println("File non trovato");
        }
        catch (IOException e){
            System.err.println("Eccezione IO");
        }
    }

    private static void parseAdd(Traduttore trad, Scanner parser){
        String word = parser.next();
        parser.next();
        String[] trads = new String[1];
        int i = 0;
        while (parser.hasNext()){
            trads[i++] = parser.next();
            if (i == trads.length){
                String[] temp = new String[2 * i];
                System.arraycopy(trads, 0, temp, 0, i);
                trads = temp;
            }
        }
        String[] temp = new String[i];
        System.arraycopy(trads, 0, temp, 0, i);
        trads = temp;
        parser.close();
        trad.insert(word, trads);
    }
}

class Traduttore implements DictionaryUD{
    private WordPair[] dict;
    private int size;
    //costruttori e metodi pubblici ......da completare ......

    public Traduttore(){
        dict = new WordPair[1];
        makeEmpty();
    }

    public void makeEmpty(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void insert(Comparable key, Object value){
        if (key == null || value == null || !(key instanceof String) || !(value instanceof String[])) throw new IllegalArgumentException();
        WordPair wp = new WordPair((String) key, (String[]) value);
        try{
            remove(key);
        }
        catch (DictionaryItemNotFoundException e){}

        if (size == dict.length){
            WordPair[] temp = new WordPair[2 * size];
            System.arraycopy(dict, 0, temp, 0, size);
            dict = temp;
        }

        dict[size++] = wp;
        for (int i = size - 2; i >= 0; i--){
            if (dict[i].getWord().compareTo(dict[i + 1].getWord()) > 0){
                WordPair temp = dict[i];
                dict[i] = dict[i + 1];
                dict[i + 1] = temp;
            }
            else{
                break;
            }
        }
    }

    public void remove(Comparable key){
        if (isEmpty()) throw new DictionaryItemNotFoundException();
        if (key == null || !(key instanceof String)) throw new IllegalArgumentException();
        int index = binSearch(key);
        for (int i = index; i < size - 1; i++){
            dict[i] = dict[i + 1];
        }
        dict[--size] = null;
    }

    public Object find(Comparable key){
        if (isEmpty()) throw new DictionaryItemNotFoundException();
        if (key == null || !(key instanceof String)) throw new IllegalArgumentException();
        return dict[binSearch(key)].getTranslations();
    }

    private int binSearch(Comparable key){
        String k = (String) key;
        int low = 0;
        int high = size;
        while (low < high){
            int mid = (low + high) / 2;
            if (dict[mid].getWord().equals(k)){
                return mid;
            }
            else if (dict[mid].getWord().compareTo(k) > 0){
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        throw new DictionaryItemNotFoundException();
    }

    public void update(DictionaryUD newdict){
        Traduttore td = (Traduttore) newdict;
        for (int i = 0; i < td.size; i++){
            insert(td.dict[i].getWord(), td.dict[i].getTranslations());
        }
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < size; i++){
            ret += dict[i] + "\n";
        }
        return ret;
    }   // ..... da completare .........
    
    //campi di esemplare  ..... da completare ......

    //classe privata WordPair: non modificare!!
    private class WordPair
    {   public WordPair(String word, String[] translations)
        {   this.word = word; 
            this.translations = translations;
        }
      
        public String getWord() 
        { return word; }
        public String[] getTranslations() 
        { return translations; }
        /*
            Restituisce una stringa contenente
            - la parola word
            - un carattere di separazione ( : )
            - gli elementi dell'array translations, separati da uno spazio
        */
        public String toString() 
        {   String retString = word + " :";
            for (int i = 0; i < translations.length; i++)
	        retString += " " + translations[i];
            return retString;
        }
        //campi di esemplare
        private String word;
        private String[] translations;
    }
}


interface DictionaryUD   //non modificare!!
{
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
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
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

    /* 
     Aggiorna il contenuto del dizionario (parametro implicito del metodo) con 
     il contenuto del dizionario newdict (parametro esplicito del metodo). 
     Piu' precisamente:
     a) se newdict contiene una chiave key non presente nel dizionario, la 
        coppia corrispondente (key value) viene scritta nel dizionario
     b) se newdict contiene una chiave key gia' presente nel dizionario, la 
        coppia (key value) presente nel dizionario viene sovrascritta da quella 
        di newdict 
    */
    void update(DictionaryUD newdict);
}

class DictionaryItemNotFoundException extends RuntimeException  {}
