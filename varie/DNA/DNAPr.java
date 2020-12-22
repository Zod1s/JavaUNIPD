import java.util.*;
import java.io.*;

public class DNAPr{
    public static void main(String[] args){
        try(FileReader readNomi = new FileReader(args[0]); Scanner nomiScan = new Scanner(readNomi);
            FileReader readSequenza = new FileReader(args[1]); Scanner sequenzaScan =new Scanner(readSequenza)){
            int nSTR; // dato che inizializzi entrambe nel intestazione del for, non serve inizializzarle anche qui
            int nPersone;

            Scanner riga;
            String sequenzaDNA = sequenzaScan.nextLine();
            sequenzaDNA = sequenzaDNA.toUpperCase();

            // char ch; non serve definirlo all'inizio, ma basta definirlo quando serve
            String[] str = new String[100];
            Sospetti[] persone = new Sospetti[100];
            int[] nSTRPresenti;
            Sospetti persona;
            boolean trovato = false;

            if(nomiScan.hasNextLine())
                riga = new Scanner(nomiScan.nextLine());
            else throw new IllegalArgumentException(); //nel caso in cui il file fosse vuoto	

            //if(riga.hasNext())
            riga.next();
            //else throw new IllegalArgumentException(); //nel caso in cui il file fosse vuoto
            for(nSTR = 0; riga.hasNext(); nSTR++){
                if(str.length <= nSTR)
                    ArrayUtil.resize(str, str.length * 2);
                str[nSTR] = riga.next().toUpperCase();
            }

            // for(int i = 0; i < nSTR; i++){ // stampa le varie STR
            //     System.out.println(str[i]);
            // }

            for(nPersone = 0; nomiScan.hasNextLine(); nPersone++){
                riga = new Scanner(nomiScan.nextLine());

                if(persone.length<=nPersone)
                    ArrayUtil.resize(persone,persone.length*2);

                //if(riga.hasNext())
                persona = new Sospetti(riga.next());
                //else throw new IllegalArgumentException();	
                persone[nPersone] = persona;  
                while(riga.hasNext())
                    persone[nPersone].addSTR(Integer.parseInt(riga.next()));
            }

            nSTRPresenti = new int[nSTR];
            while(sequenzaDNA.length() >= 4){
                // System.out.println(sequenzaDNA+"\n");
                char ch = sequenzaDNA.charAt(0); // dato che ogni a ogni ciclo aggiorni la variabile e non la usi all'esterno, basta definirla qui
                for(int j = 0; j < nSTR; j++){
                    if(ch == str[j].charAt(0)){
                        // System.out.println(ch + "==" + str[j].charAt(0) + " ora li confrontano");
                        if(confronto(str[j], sequenzaDNA)){
                            // System.out.println("sono uguali, quindi incremento nSTRPresenti[j]"+nSTRPresenti[j]);
                            nSTRPresenti[j]++;
                            // System.out.println("ora è uguale a "+nSTRPresenti[j]);
                        }
                    }
                }
                sequenzaDNA = sequenzaDNA.substring(1);
            }

            for(int i = 0; i < nPersone; i++){
                if(persone[i].verifica(nSTRPresenti)){
                    trovato = true;
                    System.out.println("Il colpevole e': "+persone[i].getNome());
                }
            }

            if(!trovato){
                System.out.println("Il colpevole non e' stato trovato");
            }
        }
        catch (FileNotFoundException e){
            System.err.println("File non trovato");
        }
        catch (IOException e){
            System.err.println("Errore nella chiusura del file");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Inserire come parametri i nomi dei file");
        }
        catch (IllegalArgumentException e){
            System.err.println("Contenuto del file errato!");
        }
    }

    private static boolean confronto(String s1, String s2){
        // if(s2.length() != 4)
        s2 = s2.substring(0,4); // se la lunghezza è già 4 o inferiore restituisce la stringa, 
                                // altrimenti dà la sottostringa da 0 a 4 escluso, quindi non serve il controllo
        // else if(s1.length() != 4)
        s1 = s1.substring(0,4);
        System.out.println("confronto tra: "+s1 +" e "+s2);
        return s1.equals(s2);
    }
}
