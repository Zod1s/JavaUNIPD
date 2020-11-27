import java.util.*; // problemi con findAndReplace, non vede i delimiters
public class MyWordProcessor{
    private String text;
    public MyWordProcessor(){
        text = "";
    }

    public void add(String line){
        text += "\n" + line;
    }

    public int findAndReplace(String find, String replace){
        Scanner parser = new Scanner(text);
        int c = 0;
        String tempText = "";
        int index = 0;
        while (parser.hasNext()){
            String dels = "";
            boolean done = false;
            while (text.charAt(index) == ' ' || text.charAt(index) == '\n' || text.charAt(index) == '\r'){
                dels += Character.toString(text.charAt(index));
                index++;
            }
            String word = parser.next();
            if (word.equals(find)){
                word = replace;
                c++;
            }
            tempText += dels + word;
            index += word.length();
        }
        text = tempText;
        parser.close();
        return c;
    }

    public String maxString(){
        Scanner parser = new Scanner(text);
        String max = "";
        while (parser.hasNext()){
            String w = parser.next();
            if (max.compareTo(w) < 0){
                max = w;
            }
        }
        parser.close();
        return max;
    }

    public int size(){
        Scanner parser = new Scanner(text);
        int c = 0;
        while (parser.hasNextLine()){
            parser.nextLine();
            c++;
        }
        parser.close();
        return c;
    }

    public String toString(){
        return text;
    }

    public String[] toWords(){
        System.out.println("Funzione");
        Scanner parser = new Scanner(text);
        String[] words = new String[1];
        int index = 0;
        while(parser.hasNext()){
            words[index] = parser.next();
            index++;
            if (index >= words.length){
                String[] ws = new String[words.length * 2];
                for (int i = 0; i < index; i++){
                    ws[i] = words[i];
                }
                words = ws;
            }
        }
        String[] ws = new String[index];
        for (int i = 0; i < index; i++){
            ws[i] = words[i];
        }
        parser.close();
        return ws;
    }

    public int wordSize(){
        Scanner parser = new Scanner(text);
        int c = 0;
        while (parser.hasNext()){
            parser.next();
            c++;
        }
        parser.close();
        return c;
    }
}
