import java.util.Scanner;

public class ExpressionCalculator{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire un'espressione");
        String input = s.nextLine();
        Evaluator e = new Evaluator(input);
        int value = e.getTermValue();
        System.out.println(value);
        s.close();
    }
}