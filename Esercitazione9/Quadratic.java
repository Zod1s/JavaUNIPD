public class Quadratic{
    //... campi di esemplare... da completare
    //...
    private double a;
    private double b;
    private double c;
    /*
      Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica
      e inizializza i campi di esemplare secondo i valori ricevuti
    */
    public Quadratic(double acoeff, double bcoeff, double ccoeff){
        a = acoeff;
        b = bcoeff;
        c = ccoeff;
        if (!hasSolutions()){
            System.out.println("Non ha soluzioni");
            throw new IllegalArgumentException();
        }
        else if(a == 0 && b == 0 && c == 0){
            System.out.println("Ha infinite soluzioni");
        }
    }
    /*
      Restituisce la prima delle due soluzioni dell'equazione quadratica,
      usando la ben nota formula...
    */
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public void setA(double newA){
        a = newA;
    }
    public void setB(double newB){
        b = newB;
    }
    public void setC(double newC){
        c = newC;
    }
    private double getDelta(){
        return b * b - 4 * a * c;
    }
    public double getSolution1(){
        if (a == 0 && b != 0){
            return (- c/b);
        }
        else if (a == 0 && b == 0 && c == 0){
            return -1;
        }
        else{
            return (-b + getDelta()) / (2 * a);
        }
    }
    /*
      Restituisce la seconda delle due soluzioni dell'equazione quadratica,
      usando la ben nota formula...
    */
    public double getSolution2(){        
        if (a == 0 && b != 0){
            return (- c/b);
        }
        else if (a == 0 && b == 0 && c == 0){
            return -1;
        }
        else{
            return (-b - getDelta()) / (2 * a);
        }
    }
    /*
      Restituisce il valore false se l'equazione non ha soluzioni
      (ovvero se il discriminante e` negativo)
    */
    public boolean hasSolutions(){
        return !(a == 0 && b == 0 && c!=0) && (getDelta() >= 0); 
    }

    public String toString(){
        return a + "x^2 + " + b + "x + " + c + " = 0";
    }
}
