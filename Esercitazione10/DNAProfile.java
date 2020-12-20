import java.util.*;
import java.io.*;
public class DNAProfile{
    public static void main(String[] args){
        if (args.length < 2 || args[1] == null) throw new IllegalArgumentException();
        String susPath = args[0];
        String dnaPath = args[1];
        try(FileReader susFile = new FileReader(susPath); FileReader dnaFile = new FileReader(dnaPath);
            Scanner susParser = new Scanner(susFile); Scanner dnaParser = new Scanner(dnaFile);){
            String dna = dnaParser.nextLine();
            String line = susParser.nextLine();

            Scanner parser = new Scanner(line);
            parser.next();

            String[] str = new String[1];
            int index = 0;
            while(parser.hasNext()){
                str[index++] = parser.next();
                if (index == str.length){
                    String[] temp = new String[index * 2];
                    System.arraycopy(str, 0, temp, 0, str.length);
                    str = temp;
                }
            }
            parser.close();
            str = resize(str, index);
            
            Suspect[] suspects = new Suspect[1];
            index = 0;
            while(susParser.hasNextLine()){
                suspects[index++] = new Suspect(susParser.nextLine());
                if (index == suspects.length){
                    Suspect[] temp = new Suspect[index * 2];
                    System.arraycopy(suspects, 0, temp, 0, suspects.length);
                    suspects = temp;
                }
            }
            suspects = resize(suspects, index);

            int[] repSus = new int[str.length];
            for (int i = 0; i < str.length; i++){
                repSus[i] = rep(dna, str[i]);
            }

            Suspect suspect = new Suspect("", repSus);
            boolean found = false;
            for (int i = 0; i < 3 && !found; i++){
                if (suspects[i].equals(suspect)){
                    System.out.println("Il colpevole e' "+suspects[i].getName());
                    found = true;
                }
            }
            if (!found){
                System.out.println("Nessun sospetto trovato");
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
            System.err.println(e);
        }
        catch(IOException e){
            System.err.println("IO Exception");
            System.err.println(e);
        }
    }

    public static int rep(String dna, String str){
        int strL = str.length();
        int dnaL = dna.length();
        int maxR = 0;
        for (int index = 0; index < (dnaL - strL); index++){
            int curR = 0;
            boolean finish = false;
            for (int i = index; i < (dnaL - strL) && !finish; i += strL){
                String sub = dna.substring(i, i + strL);
                if (str.equals(sub)){
                    curR += 1;
                }
                else{
                    finish = true;
                    maxR = Math.max(maxR, curR);
                }
            }
        }
        return maxR;
    }

    public static int[] resize(int[] a, int newL){
        int[] newA = new int[newL];
        if (newL >= a.length){
            System.arraycopy(a, 0, newA, 0, a.length);
        }
        else{
            System.arraycopy(a, 0, newA, 0, newL);
        }
        return newA;
    }

    public static String[] resize(String[] a, int newL){
        String[] newA = new String[newL];
        if (newL >= a.length){
            System.arraycopy(a, 0, newA, 0, a.length);
        }
        else{
            System.arraycopy(a, 0, newA, 0, newL);
        }
        return newA;
    }

    public static Suspect[] resize(Suspect[] a, int newL){
        Suspect[] newA = new Suspect[newL];
        if (newL >= a.length){
            System.arraycopy(a, 0, newA, 0, a.length);
        }
        else{
            System.arraycopy(a, 0, newA, 0, newL);
        }
        return newA;
    }
}
