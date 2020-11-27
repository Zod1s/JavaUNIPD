import java.util.Scanner;

public class Input2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una parola per riga(CTRL-D per uscire): ");
        String str = "";
        while(s.hasNext()){
            str = s.nextLine() + " " + str;
        }
        for (int i = str.length() - 1; i >= 0; i--){
            System.out.print(str.charAt(i));
        }
        System.out.print("\n");
        s.close();
    }
}
