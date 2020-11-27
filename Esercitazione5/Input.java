import java.util.Scanner;

public class Input{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una riga di testo: ");
        String str = s.nextLine();
        for (int i = str.length() - 1; i >= 0; i--){
            System.out.print(str.charAt(i));
        }
        System.out.print("\n");
        s.close();
    }
}
