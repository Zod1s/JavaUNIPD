import java.util.Scanner;
public class isPalindrome{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Inserire una stringa: ");
        String str = s.nextLine();
        boolean ispal = true;
        int l = str.length();
        for (int i = 0; i < l && ispal; i++){
            if (str.charAt(i) != str.charAt(l - i - 1)){
                ispal = false;
            }
        }
        if (ispal){
            System.out.println("La stringa " + str + " e' palindroma");
        }
        else{
            System.out.println("La stringa " + str + " non e' palindroma");
        }
    }
}
