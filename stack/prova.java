import java.util.Scanner;

import java.io.*;
public class Es7lab7{
    public static void main(String[] args){
        try{
            FileReader input = new FileReader("es7lab7.txt");
            Scanner n = new Scanner(input);
            while (n.hasNext()){
                String anno = n.next();
                int annon = -1;
                try{
                    annon = Integer.parseInt(anno);
                    if (annon < 0){
                        System.out.println("numero non valido");
                    }
                    else{
                        if (annon >= 1582){
                            if (annon % 4 == 0){
                                System.out.println("L'anno "+annon+" e' bisestile");
                            }
                            else{
                                if (annon % 100 == 0){
                                    if(annon % 400 == 0){
                                        System.out.println("L'anno "+annon+" e' bisestile");
                                    }
                                    else{
                                        System.out.println("L'anno "+annon+" non e' bisestile");
                                    }
                                }
                                else{
                                    System.out.println("L'anno "+annon+" non e' bisestile");
                                }
                            }
                        }
                        else{
                            System.out.println("Il calendario gregoriano venne adottato dopo il 1582.");
                        }
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Numero non intero");
                }
            }
            n.next();
        }
        catch(FileNotFoundException e){
            System.out.println("File non trovato");
        }
    }
}

