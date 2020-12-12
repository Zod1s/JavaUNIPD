import java.util.Scanner;
public class Strings{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire due stringhe uan per riga:");
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        boolean isSubString = false;
        if (s2.length() == 0){
            isSubString = true;
        }
        else{
            for (int i = 0; i < (s1.length() - s2.length()) && !isSubString; i++){
                int j = 0;
                boolean match = true;
                while (j < s2.length() && match){
                    if (s2.charAt(j) != s1.charAt(i + j)){
                        match = false;
                    }
                    j++;
                }
                isSubString = match;
            }
        }
        System.out.println("E' sottostringa: "+isSubString);
    }
}
