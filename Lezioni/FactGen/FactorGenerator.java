public class FactorGenerator{
    private int number;
    public FactorGenerator(int param){
        if (param <= 1){
            throw new IllegalArgumentException();
        }
        number = param;
    }

    public int nextFactor(){
        for (int i = 2; i <= number; i++){
            if (number % i == 0){
                number /= i;
                return i;
            }
        }
        throw new IllegalStateException();
        // se il for fallisce vuol dire che non ci sono più fattori
        //ed è stato chiamato in uno stato che non ha senso
    }

    public boolean hasNextFactor(){
        return (number != 1);
        // posso mettere diverso perché sicuramente number è diverso da 0 o da un numero negativo, essendo definito come un intero
        // maggiore di 1 e diviso poi per numeri positivi interi maggiori di 1
    }
}
