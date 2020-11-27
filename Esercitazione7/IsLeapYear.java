import java.util.*;
public class IsLeapYear{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            int anno = -1;
            do{
                try{
                    // System.out.println("Inserire un anno (0 per uscire): ");
                    anno = s.nextInt();
                }
                catch (InputMismatchException e){
                    s.nextLine();
                }
            } while (anno < 0);

            if ((anno % 4 == 0 && anno % 100 != 0) || (anno > 1582 && anno % 400 == 0)){
                System.out.println(anno+" e' bisestile");
            }
            else {System.out.println(anno+" non e' bisestile");}
        }
        s.close();
    }
}
