/**
   Classe di prova della classe ChessKing
   
   @author A. Luchetta, C.Pizzi
   @version 20201125
*/
public class ChessKingTester
{
    public static void main(String[] args)
    {
        final String INITIAL_CHESS_SQUARE = "f5";
        final String MOVE1 = "f6";
        final String MOVE2 = "e6";
        final String MOVE3 = "e5";
        final String MOVE4 = "e4";
        final String MOVE5 = "f6";


        ChessKing b1 = new ChessKing(INITIAL_CHESS_SQUARE);
        System.out.println("La casella iniziale deve essere f5");
        System.out.println("Casella iniziale "+b1);

        System.out.println("Muovo in f6");
        b1.moveToSquare(MOVE1);
        System.out.print("Casella attuale: ");
        System.out.println(b1);

        System.out.println("Muovo in e6");
        b1.moveToSquare(MOVE2);
        System.out.println("Casella attuale");
        System.out.println(b1);

        System.out.println("Muovo in e5");
        b1.moveToSquare(MOVE3);
        System.out.print("Casella attuale ");
        System.out.println(b1);

        System.out.println("Muovo in e4");
        b1.moveToSquare(MOVE4);
        System.out.print("Casella attuale: ");
        System.out.println(b1);

        System.out.println("Muovo in f6");
        b1.moveToSquare(MOVE5);  // casa non raggiungibile
        System.out.print("Casella attuale: ");
        System.out.println(b1);

        System.out.println("Muovo in abc");
        b1.moveToSquare("abc");  // casa non valida
        System.out.print("Casella attuale: ");
        System.out.println(b1);

        System.out.println("Muovo in p9");
        b1.moveToSquare("p9");  // casa non valida
        System.out.print("Casella attuale: ");
        System.out.println(b1);
           
    }

    
}
