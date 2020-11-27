import java.util.Scanner;

public class NegBinaryFormatPos{
    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        System.out.println("Inserire il numero [-128 - -1]: ");
        int number = n.nextByte() + 256;
        String start = "0b1";
        start += ((number % 128) / 64) + "" + ((number % 64) / 32) +
             ((number % 32) / 16) + "_" +
             ((number % 16) / 8) + ((number % 8) / 4) +
             ((number % 4) / 2) + "" + (number % 2);
        System.out.println(start);
    }
}
