import java.util.Scanner;

public class Decoder{
    public static String decode(String message, int offset){
        int l = message.length();
        // message = message.toUpperCase();
        String newMessage = "";
        for (int i = 0; i < l; i++){
            char c = message.charAt(i);
            int n = ((int)c) - 65;
            c = (char)((26 + n - offset) % 26 + 65);
            newMessage += Character.toString(c);
        }
        return newMessage;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una stringa: ");
        String mex = s.next();
        System.out.println("Inserire l'offset");
        int off = s.nextInt();
        System.out.println(decode(Encoder.encode(mex,off), off));
    }
}
