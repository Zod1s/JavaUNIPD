import java.util.Random;
public class ArrayAlgorithmsTester{
    public static void main(String[] args){
        BankAccount[] bList = new BankAccount[10];
        Random r = new Random(1);
        for (int i = 0; i < bList.length; i++){
            bList[i] = new BankAccount(1 + r.nextInt(1000));
        }
        ArrayAlgorithms.selectionSort(bList);
        for (int i = 0; i < bList.length; i++){
            System.out.println(bList[i]);
        }
    }
}
