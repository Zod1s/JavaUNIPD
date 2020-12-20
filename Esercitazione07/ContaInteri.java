import java.util.*;
public class ContaInteri{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int c = 0;
        while (s.hasNext()){
            try {
                int i = s.nextInt();
                c++;
            }
            catch (InputMismatchException e){
                s.nextLine();
            }
        }
        System.out.println(c);
        s.close();
    }
}
