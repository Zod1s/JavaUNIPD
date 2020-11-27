import java.util.*;
import java.io.*;
public class Leggi3{
    public static void main(String[] args){
        try{
            FileReader f = new FileReader("input.txt");
            Scanner parser = new Scanner(f).useDelimiter("[,?\\s]+");
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
