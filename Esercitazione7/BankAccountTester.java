import java.util.*;
public class BankAccountTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        BankAccount b = new BankAccount();
        boolean done = false;
        while (!done){
            System.out.println("Comando (Q, B, D x, W x, A x): ");
            String command = s.next();
            if (command.toUpperCase().equals("Q")){
                done = true;
                System.out.println("Arrivederci");
            }
            else if (command.toUpperCase().equals("B")){
                System.out.println(b);
            }
            else if (command.toUpperCase().equals("D")){
                double param;
                boolean got = false;
                do{
                    try{
                        param = s.nextDouble();
                        got = true;
                        boolean did = b.deposit(param);
                        if (did){
                            System.out.println("Versamento effettuato: "+param);
                        }
                        else{
                            System.out.println("Versamento non corretto");
                        }
                    }
                    catch (InputMismatchException e){
                        got = true;
                    }
                } while (!got);
            }
            else if (command.toUpperCase().equals("W")){
                double param;
                boolean got = false;
                do{
                    try{
                        param = s.nextDouble();
                        got = true;
                        boolean did = b.withdraw(param);
                        if (did){
                            System.out.println("Prelievo effettuato: "+param);
                        }
                        else{
                            System.out.println("Prelievo non consentito");
                        }
                    }
                    catch (InputMismatchException e){
                        got = true;
                    }
                } while (!got);
            }
            else if (command.toUpperCase().equals("A")){
                double param;
                boolean got = false;
                do{
                    try{
                        param = s.nextDouble();
                        got = true;
                        double dep = param/100 * b.getBalance();
                        boolean did = dep > 0;
                        if (did){
                            b.deposit(dep);
                            System.out.println("Interessi depositati: "+dep);
                        }
                        else{
                            System.out.println("Interesse non corretto");
                        }
                    }
                    catch (InputMismatchException e){
                        got = true;
                    }
                } while (!got);
            }
        }
        s.close();
    }
}
