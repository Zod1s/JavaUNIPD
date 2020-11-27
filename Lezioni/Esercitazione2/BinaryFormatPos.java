import java.util.Scanner;

public class BinaryFormatPos{
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        System.out.println("Inserire il numero [0-127]: ");
        int number = n.nextByte();
        n.close(); //chiude lo Scanner
        String start = "0b0";
        start += "" + (number / 64) + ((number % 64) / 32) +
             ((number % 32) / 16) + "_" +
             ((number % 16) / 8) + ((number % 8) / 4) +
             ((number % 4) / 2) + (number % 2);
        System.out.println(start);
    }
}
