public class ChessKnight{
    private String square;
    public ChessKnight(String initialSquare){
        square = initialSquare;
    }

    public boolean isChessValidSquare(String chessSquare){
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

    public boolean isKnightReachableSquare (String chessSquare){
        if (isChessValidSquare(chessSquare)){       
            char fstN = chessSquare.charAt(0);
            char sndN = chessSquare.charAt(1);
            char fstP = square.charAt(0);
            char sndP = square.charAt(1);
            if (Math.abs(fstN - fstP) == 2 && Math.abs(sndN - sndP) == 1){
                return true;
            }
            else if (Math.abs(fstN - fstP) == 2 && Math.abs(sndN - sndP) == 1){
                return true;
            }
        }
        return false;
    }

    public void moveToSquare(String chessSquare){
        if (isKnightReachableSquare(chessSquare)){
            square = chessSquare;
        }
    }

    public String toString(){
        return "Cavallo in " + square;
    }
}
