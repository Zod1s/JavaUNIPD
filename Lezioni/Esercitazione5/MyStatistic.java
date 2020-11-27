import java.util.*;
public class MyStatistic{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        // System.out.println("Inserire numeri");
        int[] vals = new int[1];
        int index = 0;
        while(s.hasNextInt()){
            vals[index] = s.nextInt();
            index++;
            if (index >= vals.length){
                int[] valst = new int[vals.length * 2];
                for (int i = 0; i < index; i++){
                    valst[i] = vals[i];
                }
                vals = valst;
            }
        }
        double average = 0;

        for (int i = 0; i < index; i++){
            average += vals[i];
        }
        average /= index;
        int sum = 0;
        for (int i = 0; i < index; i++){
            sum += (vals[i] - average) * (vals[i] - average);
        }
        sum /= index;
        double dev = Math.sqrt(sum);
        System.out.println("StdDev: "+dev);
        s.close();
    }
}
