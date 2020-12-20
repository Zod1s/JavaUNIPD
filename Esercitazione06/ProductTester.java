import java.util.Scanner;
public class ProductTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire il nome del primo prodotto: ");
        String n1 = s.next();
        System.out.println("Inserire il prezzo del primo prodotto: ");
        double p1 = s.nextDouble();
        System.out.println("Inserire il nome del secondo prodotto: ");
        String n2 = s.next();
        System.out.println("Inserire il prezzo del secondo prodotto: ");
        double p2 = s.nextDouble();

        Product pp1 = new Product(n1, p1);
        Product pp2 = new Product(n2, p2);
        if (pp1.getPrice() < pp2.getPrice()){
            System.out.println(pp2);
            System.out.println(pp1);
        }
        else{
            System.out.println(pp1);
            System.out.println(pp2);
        }
        
        System.out.print("Tasso: ");
        double rate = s.nextDouble();
        if (pp1.getPrice() < pp2.getPrice()){
            pp2.reducePrice(rate);
        }
        else{
            pp1.reducePrice(rate);
        }

        if (pp1.getPrice() < pp2.getPrice()){
            System.out.println(pp2);
            System.out.println(pp1);
        }
        else{
            System.out.println(pp1);
            System.out.println(pp2);
        }
        s.close();
    }
}
