import java.util.Scanner;
public class TrisTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        boolean done = false;
        char[] symbols = {'X', 'O'};
        while (!done){
            int index = 0;
            Tris tris = new Tris();
            while(tris.getCount() < 9 && !tris.isWinning('X') && !tris.isWinning('O')){
                char sym = symbols[index];
                boolean set = false;
                while (!set){
                    System.out.println(tris);
                    System.out.println("Giocatore "+sym+", dove vuoi inserire il simbolo?: ");
                    int x = s.nextInt();
                    int y = s.nextInt();
                    set = tris.setCharInPosition(x, y, sym);
                }
                index = (index + 1) % 2;
            }
            if (tris.isWinning('X')){
                System.out.println("X ha vinto");
                System.out.println(tris);
            }
            else if (tris.isWinning('O')){
                System.out.println("O ha vinto");
                System.out.println(tris);
            }
            else{
                System.out.println("Pareggio");
            }
            System.out.println("Vuoi giocare? (S/N): ");
            String opt = s.next();
            if (opt.toUpperCase().equals("N")){
                done = true;
            }
        }
        s.close();
    }
}
