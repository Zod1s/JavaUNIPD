import java.util.*;
import java.io.*;

public class InputOutput{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inFile = s.nextLine();
        String outFile = s.nextLine();
        try(FileReader file = new FileReader(inFile);
            Scanner parser = new Scanner(file);
            PrintWriter out = new PrintWriter(outFile)){
            while (parser.hasNextLine()){
                String line = parser.nextLine();
                line = reverse(line);
                out.println(line);
                parser.close();
            }
            s.close();
        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
            System.err.println(e);
        }
        catch(IOException e){
            System.err.println("IO exception");
            System.err.println(e);
        }
    }
    public static String reverse(String a){
        if (a.length() == 0) return "";
        return a.charAt(a.length() - 1) + reverse(a.substring(0, a.length() - 1));
    }
}
