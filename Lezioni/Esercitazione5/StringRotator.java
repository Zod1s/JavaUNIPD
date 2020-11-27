import java.util.*;
public class StringRotator{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una stringa: ");
        String str = s.nextLine();
        System.out.println("Inserire una rotazione: ");
        int rot = s.nextInt();
        rot = rot % str.length();
        if (rot == 0){
            System.out.println(str);
        }
        else if (rot > 0){
            while (rot != 0){
                String temp = str.substring(str.length()-1);
                String init = str.substring(0, str.length()-1);
                str = temp + init;
                // System.out.println(temp);
                
                rot--;
            }
            System.out.println(str);
        }
        else {
            rot = Math.abs(rot);
            while (rot != 0){
                String temp = str.substring(0, 1);
                String init = str.substring(1);
                str = init + temp;
                // System.out.println(temp);
                
                rot--;
            }
            System.out.println(str);
        }
        s.close();
    }
}
