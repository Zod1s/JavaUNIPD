import java.util.*;
public class InterruttoreTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        boolean done = false;
        Interruttore int1 = new Interruttore();
        Interruttore int2 = new Interruttore();
        while (!done){
            int d = -1;
            System.out.println("Interruttore 1: "+int1);
            System.out.println("Interruttore 2: "+int2);
            if (int1.isBulbOn()){
                System.out.println("Lampadina accesa");
            }
            else{
                System.out.println("Lampadina spenta");
            }
            do{
                try{
                    System.out.println("Scegli interruttore 1 o 2 (0 per uscire)");
                    d = s.nextInt();
                }
                catch (InputMismatchException e){
                    s.nextLine();
                }
            } while (d < 0 || d > 2);
            if (d == 0){
                done = true;
            }
            else if (d == 1){
                int1.changeStatus();
            }
            else{
                int2.changeStatus();
            }
        }
        s.close();
    }
}
