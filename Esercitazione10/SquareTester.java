import java.util.Scanner;
public class SquareTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] fst = s.nextLine().split(" ");
        String[] snd = s.nextLine().split(" ");
        if (fst.length != 3 || snd.length != 3) throw new IllegalArgumentException();

        int x1 = Integer.parseInt(fst[0]);
        int y1 = Integer.parseInt(fst[1]);
        int l1 = Integer.parseInt(fst[2]);
        Square sq1 = new Square(x1, y1, l1);
        
        int x2 = Integer.parseInt(snd[0]);
        int y2 = Integer.parseInt(snd[1]);
        int l2 = Integer.parseInt(snd[2]);
        Square sq2 = new Square(x2, y2, l2);
        
        if (sq1.getArea() < sq2.getArea()){
            System.out.println(sq1);
            System.out.println(sq2);
        }
        else{
            System.out.println(sq2);
            System.out.println(sq1);
        }
        
        String[] fstS = s.nextLine().split(" ");
        String[] sndS = s.nextLine().split(" ");

        if (fstS.length != 2 || sndS.length != 2) throw new IllegalArgumentException();
        int w1 = Integer.parseInt(fstS[0]);
        int h1 = Integer.parseInt(fstS[1]);

        int w2 = Integer.parseInt(sndS[0]);
        int h2 = Integer.parseInt(sndS[1]);

        sq1.setSize(w1, h1);
        sq2.setSize(w2, h2);

        if (sq1.getArea() < sq2.getArea()){
            System.out.println(sq1);
            System.out.println(sq2);
        }
        else{
            System.out.println(sq2);
            System.out.println(sq1);
        }
    }
}
