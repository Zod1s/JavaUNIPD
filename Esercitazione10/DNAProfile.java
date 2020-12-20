import java.util.*;
import java.io.*;
public class DNAProfile{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("File dei sospettati");
        String susPath = s.nextLine();
        System.out.println("File del DNA");
        String dnaPath = s.nextLine();
        try(FileReader susFile = new FileReader(susPath);
            FileReader dnaFile = new FileReader(dnaPath);
            Scanner susParser = new Scanner(susFile);
            Scanner dnaParser = new Scanner(dnaFile);){
            String dna = dnaParser.nextLine();
            String line = susParser.nextLine();
            Scanner parser = new Scanner(line);
            parser.next();
            String[] str = new String[3];
            for (int i = 0; i < 3; i++){
                str[i] = parser.next();
                System.out.println(str[i]);
            }
            parser.close();
            Suspect[] suspects = new Suspect[3];
            for (int i = 0; i < 3; i++){
                suspects[i] = new Suspect(susParser.nextLine());
                System.out.println(suspects[i]);
            }
            int[] repSus = new int[3];
            for (int i = 0; i < 3; i++){
                repSus[i] = rep(dna, str[i]);
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
        s.close();
    }

    public static int rep(String dna, String str){
        return -1;
    }
}

class Suspect{
    private String name;
    private int s1, s2, s3;
    public Suspect(String name, int[] s){
        this.name = name;
        this.s1 = s[0];
        this.s2 = s[1];
        this.s3 = s[2];
    }

    public Suspect(String toParse){
        Scanner parser = new Scanner(toParse);
        name = parser.next();
        s1 = parser.nextInt();
        s2 = parser.nextInt();
        s3 = parser.nextInt();
    }

    public String toString(){
        return name + " " + s1 + " " + s2 + " " + s3;
    }
    
    public boolean equals(Object sus){
        Suspect s = (Suspect) sus;
        return (s.s1 == s1 && s.s2 == s2 && s.s3 == s3);
    }
}
