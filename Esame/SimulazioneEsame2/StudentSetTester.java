// nome e cognome del candidato, matricola, data, numero della postazione
import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class StudentSetTester{
    public static void main(String[] args){
      // ....... da completare ............
        if (args.length != 1) throw new IllegalArgumentException();
        String toRead = args[0];
        Scanner s = new Scanner(System.in);
        StudentSet set = new StudentSet();
        try (FileReader reader = new FileReader(toRead); Scanner parser = new Scanner(reader);){
            while (parser.hasNextLine()){
                String surname = parser.next();
                String name = parser.next();
                parser.next();
                int mat = parser.nextInt();
                Student stud = new Student(surname, name, mat);
                set.add(stud);
                parser.nextLine();
            }
            System.out.println(set);
            while (s.hasNextLine()){
                System.out.println("Inserire un comando da tastiera");
                String command = s.nextLine();
                Scanner cmdParser = new Scanner(command);
                String cmd1 = "";
                String cmd2 = "";
                try{
                    cmd1 = cmdParser.next();
                    cmd2 = cmdParser.next();
                }
                catch (NoSuchElementException e){
                    System.err.println("Devono essere [l] [l]");
                }
                cmdParser.close();
                System.out.println(set.subSet(cmd1, cmd2));
            }
        }
        catch (IOException e){
            System.err.println("IOException");
            System.err.println(e);
        }
        s.close();
    }
}

class StudentSet implements SortedSet{
    private Student[] set;
    private int vSize;
    //costruttori e metodi pubblici ......da completare ......

    public StudentSet(){
        set = new Student[1];
        makeEmpty();
    }

    public void makeEmpty(){
        vSize = 0;
    }

    public boolean isEmpty(){
        return (vSize == 0);
    }

    public int size(){
        return vSize;
    }

    public void add(Comparable key){
        if (key == null || !(key instanceof Student)) throw new IllegalArgumentException();
        if (!contains(key)){
            if (vSize == set.length){
                Student[] temp = new Student[vSize * 2];
                System.arraycopy(set, 0, temp, 0, vSize);
                set = temp;
            }
            set[vSize++] = (Student) key;
            for (int i = vSize - 2; i >= 0; i--){
                if (set[i].compareTo(set[i + 1]) > 0){
                    Student temp = set[i];
                    set[i] = set[i + 1];
                    set[i + 1] = temp;
                }
            }
        }
    }

    public boolean contains(Comparable key){
        if (key == null || !(key instanceof Student)) throw new IllegalArgumentException();
        int low = 0;
        int high = vSize;
        while (low < high){
            int mid = (low + high) / 2;
            if (set[mid].compareTo(key) == 0){
                return true;
            }
            else if (set[mid].compareTo(key) > 0){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }

    public Comparable[] toArray(){
        Comparable[] arr = new Comparable[vSize];
        System.arraycopy(set, 0, arr, 0, vSize);
        return arr;
    }

    public SortedSet subSet(Comparable fromObj, Comparable toObj){
        StudentSet newSet = new StudentSet();
        for (int i = 0; i < vSize; i++){
            Student st = set[i];
            if (fromObj.compareTo(st.getCognome()) <= 0 && toObj.compareTo(st.getCognome()) > 0){
                newSet.add(st);
            }
        }
        return newSet;
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < vSize; i++){
            ret += set[i].toString() + "\n";
        }
        return ret;
    }          // ..... da completare .........

    //campi di esemplare ..... da completare ......
}

interface SortedSet     //non modificare!!
{   // verifica se l'insieme contiene almeno un elemento
    boolean isEmpty(); 

    // svuota l'insieme
    void makeEmpty();
  
    // restituisce il numero di elementi nell'insieme
    int size();
  
    /*
        Inserisce l'oggetto comparabile obj nell'insieme se non e` gia` 
        presente, altrimenti fallisce silenziosamente.
    */
    void add(Comparable obj);
  
    /*
        Restituisce true se e solo se l'oggetto comparabile obj appartiene  
        all'insieme. Verranno considerate ottime le soluzioni per cui questo 
        metodo ha prestazioni O(log n) 
    */
    boolean contains(Comparable obj);
  
    /*
        Restituisce un array di oggetti comparabili contenente i riferimenti a 
        tutti gli elementi presenti nell'insieme
    */
    Comparable[] toArray();

    /*
        Riceve due riferimenti ad oggetti comparabili e restituisce un
        riferimento ad un nuovo insieme, che contiene tutti e soli gli elementi
        dell'insieme di partenza (cioe` il parametro implicito del metodo) 
        compresi tra fromObj (incluso) e toObj (escluso). 
        Se fromObj non appartiene all'insieme di partenza, il primo elemento 
        del nuovo insieme sara` il primo elemento maggiore di fromObj trovato
        nell'insieme di partenza.
        Se fromObj e toObj sono uguali, o se toObj e` piu` piccolo di fromObj,
        il nuovo insieme sara` vuoto
    */
    SortedSet subSet(Comparable fromObj, Comparable toObj);

}

class Student implements Comparable   //non modificare!!
{   public Student (String c, String n, int m) 
    {   cognome = c;
        nome = n;
        matricola = m;
    }

    public String getCognome()
    {   return cognome; }

    public String getNome()
    {   return nome; }

    public int getMatricola()
    {   return matricola; }


    /*
      I dati dello studente vengono stampati nel formato
      "cognome        nome          : n.matricola"
      Per il campo cognome e per il campo nome vengono allocati maxlength=15
      caratteri
    */
    public String toString()
    {   int maxlength = 15;
        String sep1 = "";
        for (int i = 0; i < maxlength - cognome.length(); i++) sep1 += " ";
        String sep2 = "";
        for (int i = 0; i < maxlength - nome.length(); i++) sep2 += " ";
        return cognome + sep1 + nome + sep2 + ": " + matricola; 
    }

    /*
     Lo studente x e` "maggiore" dello studente y se il cognome di x segue
     quello di y secondo l'ordinamento lessicografico. Se i due cognomi sono
     uguali, allora x e` "maggiore" di y se il nome di x segue quello di y 
     secondo l'ordinamento lessicografico. Se anche i nomi sono uguali
     (due studenti omonimi) allora x e` "maggiore" di y se la sua matricola
     e` piu` grande di quella di y.
     Esempio1:
     (DeMorgan Augustus : 511123) e` maggiore di (Babbage Charles : 599987)
     Esempio2:
     (Bernoulli Nicolaus : 577789) e` maggiore di (Bernoulli Jacob : 500098)
     Esempio3:
     (Bernoulli Nicolaus : 588890) e` maggiore di (Bernoulli Nicolaus : 577789)

    */
    public int compareTo(Object other)
    {   Student aStudent = (Student) other;
        int comp = cognome.compareTo( ((Student) other).cognome);
        if (comp == 0) comp = nome.compareTo(((Student) other).nome);
        if (comp == 0) comp = matricola - ((Student) other).matricola;
        return comp;
    }

    /*
      Due studenti x e y sono "uguali" solo se hanno lo stesso cognome e lo 
      stesso nome e lo stesso numero di matricola. 
      Esempio:
     (Babbage Charles : 599987) e` uguale a (Babbage Charles : 599987)

    */
    public boolean equals(Object other)
    {   return this.compareTo(other) == 0;
    }

    private String cognome;
    private String nome;
    private int matricola;
}