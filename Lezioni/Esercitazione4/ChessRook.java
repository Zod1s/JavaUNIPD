public class ChessRook{
    private String square;
    public ChessRook(String square){
        this.square = square;
    }

    private static boolean isChessValidSquare(String chessSquare){
        char minL = 'a';
        char maxL = 'h';
        char minI = '1';
        char maxI = '8';
        if (chessSquare.length() == 2){
            char fst = chessSquare.charAt(0);
            char snd = chessSquare.charAt(1);
            if (fst >= minL && fst <= maxL && snd >= minI && snd <= maxI){
                return true;
            }
        }
        return false;
    }

    private boolean isRookReachableSquare (String chessSquare){
        if (isChessValidSquare(chessSquare)){       
            char fstN = chessSquare.charAt(0);
            char sndN = chessSquare.charAt(1);
            char fstP = square.charAt(0);
            char sndP = square.charAt(1);
            if (fstN == fstP || sndN == sndP){
                return true;
            }
        }
        return false;
    }

    public void moveToSquare(String square){
        if (isRookReachableSquare(square)){
                this.square = square;
            }
    }

    public String toString(){
        return "Torre in " + square;
    }
}
