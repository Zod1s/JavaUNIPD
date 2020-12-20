import java.util.*;
public class Risiko{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire i nomi dei due giocatori");
        String n1 = s.next();
        String n2 = s.next();
        Player p1 = new Player(n1);
        Player p2 = new Player(n2);
        p1.turn();
        p2.turn();
        System.out.println(p1);
        System.out.println(p2);
        int[] a = p1.sortDice();
        for (int i = 0; i < 3; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int[] b = p2.sortDice();
        for (int i = 0; i < 3; i++){
            System.out.print(b[i] + " ");
        }
        for (int i = 0; i < 3; i++){
            if (a[i] > b[i]){
                p1.addPoint();
            }
            else{
                p2.addPoint();
            }
        }
        System.out.println();
        if (p1.getScore() > p2.getScore()){
            System.out.println("Vince "+p1.getName()+" "+p1.getScore()+" a "+p2.getScore());
        }
        else{
            System.out.println("Vince "+p2.getName()+" "+p2.getScore()+" a "+p1.getScore());
        }
    } 
}
