import java.util.Scanner;

public class Es{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in); //crea l'oggetto s per accedere a stdin

        System.out.println("Nome e Cognome");
        String nome = s.next(); // assegna a nome la sequenza di caratteri inserita dall'inizio fino al primo spazio
        String cognome = s.next(); /* assegna a cognome la sequenza di caratteri inserita dallo spazio fino allo
                                      spazio successivo, che in questo caso coincide con la fine */

        System.out.println("Eta'");
        int eta = s.nextInt(); // assegna a eta l'eta' inserita come intero

        String pass = (nome.substring(0, 1) + cognome.substring(0, 1)).toLowerCase() + eta;
        // pass è l'iniziale del nome, l'iniziale del cognome e l'eta' concatenate e tutto minuscolo
        System.out.println("Pass: "+pass);
    }
}

// non posso usare charAt() per ottenere l'iniziale perché non è definito l'operatore di concatenazione tra char
// potrei fare "" + n.charAt(0) + ...
