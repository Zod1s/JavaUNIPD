import java.util.*;
import java.io.*;
public class Leggi2{
    public static void main(String[] args){
        try{
            FileReader f = new FileReader("input.txt");
            Scanner parser = new Scanner(f);
            while (parser.hasNext()){
                System.out.println(parser.next());
            }
            parser.close();
            f.close();
        }
        catch (IOException e){
            System.err.println(e);
        }
    }
} 
