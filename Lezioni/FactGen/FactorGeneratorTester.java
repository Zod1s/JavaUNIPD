import java.util.*;
public class FactorGeneratorTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n;
        do {
            System.out.println("Inserire un numero intero maggiore di 1: ");
            try{
                n = s.nextInt(); // puo' lanciare un'eccezione InputMismatchException
            }
            catch(InputMismatchException e){
                n = 0;
                s.nextLine();
            }
        } while (n < 2);
        FactorGenerator fg = new FactorGenerator(n); // n >= 2, quindi non lancia eccezioni
        while (fg.hasNextFactor()){
            System.out.println(fg.nextFactor());
        }
        s.close();
    }
}
