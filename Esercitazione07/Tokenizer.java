import java.util.*;
import java.io.*;
public class Tokenizer{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci due file, il primo di lettura e il secondo di scrittura: ");
        String read = s.next();
        String write = s.next();
        try(FileReader f = new FileReader(read); Scanner parser = new Scanner(f); PrintWriter p = new PrintWriter(write);){
            while (parser.hasNextLine()){
                String line = parser.nextLine();
                Scanner parser2 = new Scanner(line);
                while (parser2.hasNext()){
                    String word = parser2.next().toLowerCase();
                    Scanner parser3 = new Scanner(word).useDelimiter("[']+");
                    String word1 = parser3.next();
                    if (!word1.equals(word)){
                        String head = word1.substring(0, 1);
                        String tail = word1.substring(1);
                        word = head.toUpperCase() + tail;
                        p.print(word+"'");
                        String word2 = parser3.next();
                        head = word2.substring(0, 1);
                        tail = word2.substring(1);
                        word = head.toUpperCase() + tail;
                        p.print(word+" ");
                    }
                    else{
                        String head = word.substring(0, 1);
                        String tail = word.substring(1);
                        word = head.toUpperCase() + tail;
                        p.print(word+" ");
                    }
                    parser3.close();
                }
                parser2.close();
                p.print("\n");
            }
            s.close();
        }
        catch (FileNotFoundException e){
            System.err.println(e);
            System.exit(1);
        }
        catch (IOException e){
            System.err.println(e);
        }
    }
}
