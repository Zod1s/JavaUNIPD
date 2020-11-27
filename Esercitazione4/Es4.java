import java.util.Scanner;

public class Es4{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        /* System.out.println("Tre parole: ");
        String a = s.next();
        String b = s.next();
        String c = s.next();
        System.out.println(c+"\n"+b+"\n"+a); */

        /* System.out.println("Due numeri: ");
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println("Somma: "+(a+b));
        System.out.println("Prodotto: "+(a*b));
        System.out.println("Media: "+((a+b)/2.0));
        if (a >= b){
            System.out.println("Massimo: "+a);
            System.out.println("Minimo: "+b);
        }
        else{
            System.out.println("Massimo: "+b);
            System.out.println("Minimo: "+a);
        }
        int diff = a - b;
        if (diff < 0) diff = -diff;
        System.out.println("Modulo della differenza: "+diff);*/

        /* double a = s.nextDouble();
        double b = s.nextDouble();
        boolean c = Numeric.approxEqual(a,b);
        if (c) System.out.println("Sono vicini");
        else System.out.println("Non sono vicini");*/

        /*System.out.println("Numero pari: ");
        int a = s.nextInt();
        if (a % 2 != 0){
            System.out.println("Deve essere pari: ");
            a = s.nextInt();
            if (a % 2 != 0){
                System.out.println("Deve essere pari");
            }
            else{
                System.out.println("Il numero "+a+" e' pari");
            }
        }
        else{
                System.out.println("Il numero "+a+" e' pari");
        }*/

        /* System.out.println("Anno: ");
        int anno = s.nextInt();
        if (anno < 0){
            System.out.println("Deve essere non negativo");
        }
        else{
            if ((anno % 4 == 0 && anno % 100 != 0) || (anno > 1582 && anno % 400 == 0)){
                System.out.println(anno+" e' bisestile");
            }
            else System.out.println("Non e' bisestile");
        } */

        /* System.out.println("Inserire tre stringhe: ");
        String a = s.next();
        String b = s.next();
        String c = s.next();
        int ab = a.compareTo(b); // positivo se a > b, negativo se a < b
        int bc = b.compareTo(c); // positivo se b > c, negativo se b < c
        int ac = a.compareTo(c); // positivo se a > c, negativo se a < c
        if (ab < 0 && bc < 0){
            System.out.println(a+"\n"+b+"\n"+c);
        }
        else if (ab < 0 && bc > 0 && ac < 0){
            System.out.println(a+"\n"+c+"\n"+b);
        }
        else if (bc < 0 && ac > 0){
            System.out.println(b+"\n"+c+"\n"+a);
        }
        else if (bc < 0 && ac < 0){
            System.out.println(b+"\n"+a+"\n"+c);
        }
        else if (bc > 0 && ab > 0){
            System.out.println(c+"\n"+b+"\n"+a);
        }
        else {
            System.out.println(c+"\n"+a+"\n"+b);
        } */

        System.out.print("Tre interi: ");
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        int med = 0;
        if (a == max) med = Math.max(b, c);
        else if (b == max) med = Math.max(a, c);
        else med = Math.max(a, b); 
        String type = "";
        String angles = "";
        boolean isValid = min + med > max;
        if (!isValid){
            System.out.println("Non e' un triangolo valido");
        }
        else{
            if (min == med && med == max){
                System.out.println("Triangolo equilatero");
            }
            else {
                if (min == med || med == max){
                    type = "isoscele ";
                }
                else{
                    type = "scaleno ";
                }
                if (min*min + med*med == max*max){
                    angles = "rettangolo";
                }
                else if (min*min + med*med > max*max){
                    angles = "acutangolo";
                }
                else {
                    angles = "ottusangolo";
                }
                System.out.println("Triangolo "+type+angles);
            }
        }

        /* String giorniMese = "312831303130313130313031";
        System.out.println("Inserire una data: ");
        int giorno = s.nextInt();
        int mese = s.nextInt();
        if (Integer.parseInt(giorniMese.substring((mese - 1)*2, (mese - 1)*2+2)) < giorno){
            System.out.println("Data non valida");
        }
        else{
            String iso = "";
            if (mese < 10){
                iso += "0" + mese;
            }
            else iso += mese;
            if (giorno < 10){
                iso += "0" + giorno;
            }
            else iso += giorno;

            if (iso.compareTo("0321") >= 0 && iso.compareTo("0420") <= 0){
                System.out.println("ARIETE");
            }
            else if (iso.compareTo("0421") >= 0 && iso.compareTo("0520") <= 0){
                System.out.println("TORO");
            }
            else if (iso.compareTo("0521") >= 0 && iso.compareTo("0621") <= 0){
                System.out.println("GEMELLI");
            }
            else if (iso.compareTo("0622") >= 0 && iso.compareTo("0722") <= 0){
                System.out.println("CANCRO");
            }
            else if (iso.compareTo("0723") >= 0 && iso.compareTo("0823") <= 0){
                System.out.println("LEONE");
            }
            else if (iso.compareTo("0824") >= 0 && iso.compareTo("0922") <= 0){
                System.out.println("VERGINE");
            }
            else if (iso.compareTo("0923") >= 0 && iso.compareTo("1022") <= 0){
                System.out.println("BILANCIA");
            }
            else if (iso.compareTo("1023") >= 0 && iso.compareTo("1122") <= 0){
                System.out.println("SCORPIONE");
            }
            else if (iso.compareTo("1123") >= 0 && iso.compareTo("1221") <= 0){
                System.out.println("SAGITTARIO");
            }
            else if (iso.compareTo("1222") >= 0 || iso.compareTo("0120") <= 0){
                System.out.println("CAPRICORNO");
            } 
            else if (iso.compareTo("0121") >= 0 && iso.compareTo("0219") <= 0){
                System.out.println("AQUARIO");
            }
            else if (iso.compareTo("0220") >= 0 && iso.compareTo("0320") <= 0){
                System.out.println("PESCI");
            }
            System.out.println("Amore:    4/5\nAmicizia: 3/5\nLavoro:   3/5");
        }*/
    }
}
