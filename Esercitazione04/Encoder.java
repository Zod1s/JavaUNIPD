import java.util.Scanner;

public class Encoder{
    public static String encode(String message, int offset){
        int l = message.length();
        message = message.toUpperCase();
        String newMessage = "";
        for (int i = 0; i < l; i++){
            char c = message.charAt(i);
            int n = ((int)c) - 65;
            c = (char)((offset + n) % 26 + 65);
            newMessage += Character.toString(c);
        }
        return newMessage;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una stringa: ");
        String mex = s.next();
        System.out.println("Inserire lo scorrimento: ");
        int offset = s.nextInt();
        System.out.println(encode(mex, offset));
    }
}
