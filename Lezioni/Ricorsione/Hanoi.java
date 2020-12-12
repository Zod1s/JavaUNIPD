public class Hanoi{
    public static void hanoi(int from, int to, int temp, int dim){
        if (dim > 0){
            hanoi(from, temp, to, dim-1);
            System.out.println("Sposta " + dim + " da T" + from + " a T" + to);
            hanoi(temp, to, from, dim-1);
        }
    }

    public static void main(String[] args){
        System.out.println("Soluzione con n = " + args[0]);
        hanoi(1, 2, 3, Integer.parseInt(args[0]));
    }
}
