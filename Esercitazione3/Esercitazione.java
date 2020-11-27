import java.util.Scanner;

public class Esercitazione{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        /*
        System.out.print("Nome: ");
        String name = s.nextLine();
        System.out.println("Ciao "+name);
        */
        /*
        System.out.println("Numeri: ");
        double a = s.nextDouble();
        double b = s.nextDouble();
        double c = s.nextDouble();
        double d = a + b + c;
        System.out.println(a+" + "+b+" + "+c+" = "+d);
        */
        /*
        System.out.print("metti un aggettivo: ");
        String adj = s.nextLine();
        String aDj = adj.substring(0, 1).toUpperCase() + adj.substring(1);
        String dim = adj.substring(0, adj.length() - 1) + "in" + adj.substring(adj.length() -  1);
        String sup = adj.substring(0, adj.length() - 1) + "issim" + adj.substring(adj.length() -  1);
        System.out.print(aDj+"\n"+dim+"\n"+sup+"\n");
        */
        
        System.out.print("Primo orario: ");
        String ora1 = s.nextLine();
        System.out.print("Secondo orario: ");
        String ora2 = s.nextLine();
        int orario1 = Integer.parseInt(ora1.substring(0,2)) * 60 + Integer.parseInt(ora1.substring(2));
        int orario2 = Integer.parseInt(ora2.substring(0,2)) * 60 + Integer.parseInt(ora2.substring(2));
        final int V = 24 * 60;
        int diff1 = V - orario1;
        int diff2 = orario2;
        int ore = ((diff1 + diff2) % V) / 60;
        int minuti = ((diff1 + diff2) % V) % 60;
        System.out.println("Tempo trascorso: "+ore+" ore e "+minuti+" minuti");

        /*
        String mesi = "Gennaio  Febbraio Marzo    Aprile   Maggio   Giugno   " +
            "Luglio   Agosto   SettembreOttobre  Novembre Dicembre ";
        System.out.print("Inserisci il numero del mese(1-12): ");
        int mese = s.nextInt();
        String m = mesi.substring(9 * (mese - 1), 9 * mese);
        System.out.println(m);
        */
        /*
        MyRectangle r = new MyRectangle(1,1,10,10);
        r.resize(0.5);
        System.out.println(r);
        */
        s.close();
    }
}

class MyRectangle{
    int x, y, w, h;
    public MyRectangle(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public int getWidth(){return w;}
    public int getHeight(){return h;}

    public void resize(double mult){
        w *= mult;
        h *= mult;
    }

    public void translate(int dx, int dy){
        x += dx;
        y += dy;
    }

    public String toString(){
        return "Rettangolo: x = "+x+", y = "+y+", w = "+w+", h = "+h;
    }
}
