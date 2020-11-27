public class Tris{
    private char[][] grid;
    public Tris(){
        grid = new char[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                grid[i][j] = '.';
            }
        }
    }

    public char getCharInPosition(int row, int column){
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2){
            return grid[row][column];
        }
        else{
            System.out.println("Coordinate non valide");
            System.exit(1);
        }
        return ' ';
    }

    public int getCount(){
        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (grid[i][j] != '.'){
                    count++;
                }
            }
        }
        return count;
    }

    boolean isWinning(char c){
        boolean winning = false;
        for (int i = 0; !winning && i < 3; i++){
            if (grid[i][0] == c && grid[i][1] == c && grid[i][2] == c){
                winning = true;
            } 
        }
        for (int i = 0; !winning && i < 3; i++){
            if (grid[0][i] == c && grid[1][i] == c && grid[2][i] == c){
                winning = true;
            } 
        }
        if (!winning && grid[0][0] == c && grid[1][1] == c && grid[2][2] == c) winning = true;
        if (!winning && grid[0][2] == c && grid[1][1] == c && grid[2][0] == c) winning = true;
        return winning;
    }
    
    boolean setCharInPosition(int row, int column, char c){
        if (getCharInPosition(row, column) == '.'){
            grid[row][column] = c;
            return true;
        }
        else{
            System.out.println("Casella gia' occupata");
            return false;
        }
    }
    
    public String toString(){
        String[] lines = new String[3];
        for (int i = 0; i < 3; i++){
            lines[i] = "|";
            for (int j = 0; j < 3; j++){
                lines[i] += "" + grid[i][j];
            }
            lines[i] += "|";
        }
        return lines[0] + "\n" + lines[1] + "\n" + lines[2] + "\n";
    }
}
