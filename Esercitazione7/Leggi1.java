import java.util.*;
import java.io.*;
public class Leggi1{
    public static void main(String[] args){
        try{
            FileReader f = new FileReader("input.txt");
            Scanner parser = new Scanner(f);
            while (parser.hasNextLine()){
                System.out.println(parser.nextLine());
            }
            parser.close();
            f.close();
        }
        catch(IOException e){
            System.err.println(e);
        }
    }
}
