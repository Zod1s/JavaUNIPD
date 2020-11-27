/*
    L'insieme C dei numeri complessi e' l'insieme delle coppie ordinate (x,y) 
    con x e y appartenenti a R (insieme dei numeri reali).
    Dato il numero complesso z = x + i *y, i numeri reali x e y sono detti
    parte reale e parte immaginaria di z.
    Nei commenti che seguono, facciamo riferimento ai numeri complessi
        z = x + i*y, z1 = x1 + i*y1, z2 = x2 + i*y2
*/

public class MyComplex{
    //-------- variabili di esemplare
    private double real;
    private double imag;
    // inizializza il numero complesso al valore 0 + i0 (zero complesso)
    public MyComplex(){
        real = imag = 0;
    }

    // inizializza il numero complesso al valore re + i*im
    public MyComplex(double realPart, double imagPart){
        real = realPart;
        imag = imagPart;
    }

    //Somma a questo numero complesso il numero complesso z
    //somma di due complessi: z = z1+z2 = (x1+x2) + i(y1+y2)
    public MyComplex add(MyComplex z){
        return new MyComplex(real + z.real, imag + z.imag);
    }

    //Sottrae a questo numero complesso il numero complesso z
    //sottrazione di due complessi: z = z1-z2 = (x1-x2) +i(y1-y2)
    public MyComplex sub(MyComplex z){
        return new MyComplex(real - z.real, imag - z.imag);
    }

    //Moltiplica questo numero complesso per il numero complesso z
    //prodotto di due complessi: z = z1*z2 = (x1*x2 -y1*y2) + i*(x1*y2 + x2*y1)
    public MyComplex mult(MyComplex z){
        return new MyComplex(real * z.real - imag * z.imag, imag * z.real + real * z.imag);
    }

    //Divide questo numero complesso per il numero complesso z
    //divisione fra due complessi: z1/z2 = z1 *1/z2, per z2 != 0
    public MyComplex div(MyComplex z){
        if (z.mod() != 0){
            return mult(z.inv());
        }
        else{
            System.out.print("Error");
            return null;
        }
    }
          
    //Calcola il coniugato di questo numero complesso
    //coniugato del complesso z:  z^= x - i*y
    public MyComplex conj(){
        return new MyComplex(real, -imag);
    }
          
    //Calcola l'inverso rispetto al prodotto di un numero complesso
    //inverso del complesso z: 1/z = x/(|z|*|z|) -i*y/(|z|*|z|), per z != 0
    public MyComplex inv(){
        double m = mod();
        double sM = m*m;
        if (m != 0){
            return new MyComplex(real / sM, -imag / sM);
        }
        else{
            System.out.print("Error");
            return null;
        }
    }

    //Calcola il modulo di questo numero complesso
    //modulo del complesso z: |z| = sqrt( x*x + y*y).
    public double mod(){
        return Math.sqrt(real*real + imag*imag);
    }
           
    //Crea una stringa che rappresenta questo numero complesso
    //del tipo "x + i * y"
    public String toString(){
        return real + " + i * " + imag;
    }

    //-------- metodi di accesso ----------
          
    //Restituisce la parte immaginaria di un numero complesso
    public double getIm(){
        return imag;
    }

    //Restituisce la parte reale di un numero complesso
    public double getRe(){
        return real;
    }
}
