public class AverageDice{
    public static void main(String[] args){
        double sum = 0;
        for (int i = 0; i < 10000; i++){
            int d = (int)(1 + 6*Math.random()); // valore di un dado
            sum += d;
        }
        double avg = sum / 10000;
        System.out.println(avg);
    }
}
