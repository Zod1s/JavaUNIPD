import java.util.Scanner;
public class Suspect{
    private String name;
    private int[] seq;

    public Suspect(String name, int[] s){
        this.name = name;
        if (s.length == 0){
            throw new IllegalArgumentException();
        }
        seq = new int[s.length];
        System.arraycopy(s, 0, seq, 0, s.length);
    }

    public Suspect(String toParse){
        Scanner parser = new Scanner(toParse);
        name = parser.next();
        if (!parser.hasNextInt()){
            throw new IllegalArgumentException();
        }
        seq = new int[1];
        int index = 0;
        while(parser.hasNextInt()){
            seq[index++] = parser.nextInt();
            if (index == seq.length){
                int[] temp = new int[index * 2];
                System.arraycopy(seq, 0, temp, 0, seq.length);
                seq = temp;
            }
        }
        seq = DNAProfile.resize(seq, index);
    }

    public String getName(){
        return name;
    }

    public int[] getStrReps(){
        return seq;
    }

    public String toString(){
        String r = name;
        for (int i = 0; i < seq.length; i++){
            r += " " + seq[i];
        }
        return r;
    }

    public boolean equals(Object sus){
        Suspect s = (Suspect) sus;
        for (int i = 0; i < seq.length && i < s.seq.length; i++){
            if (seq[i] != s.seq[i]){
                return false;
            }
        }
        return (seq.length == s.seq.length);
    }
}
