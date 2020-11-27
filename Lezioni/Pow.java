import java.util.Scanner;
public class Pow{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire 2 numeri interi: ");
        
        int maxX = s.nextInt();
        int maxY = s.nextInt();
        int maxVal = (int)Math.round(Math.pow(maxX, maxY));
        int colWidth = 1 + Integer.toString(maxVal).length();

        int[][] powers = makePowers(maxX, maxY);
        display(powers, colWidth);
    }

    public static int[][] makePowers(int maxX, int maxY){
        int [][] matrix = new int[maxX][maxY];
        for (int i = 0; i < maxX; i++){
            for (int j = 0; j < maxY; j++){
                matrix[i][j] = (int)Math.round(Math.pow(i + 1, j + 1));
            }
        }
        return matrix;
    }

    public static void display(int[][] pows, int width){
        int x = pows.length;
        int y = pows[0].length;
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                String s = Integer.toString(pows[i][j]);
                while (s.length() < width){
                    s = " " + s;
                }
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
