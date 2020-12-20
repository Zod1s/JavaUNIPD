import java.util.Scanner;

public class IsMagicSquare{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire i numeri di un quadrato magico in ordine: ");
        int[] array = new int[1];
        int index = 0;
        while(s.hasNextInt()){
            while(s.hasNextInt()){
                array[index] = s.nextInt();
                index++;
                if (index >= array.length){
                    array = ArrayUtil.resize(array, array.length*2);
                }
            }
        }
        array = ArrayUtil.resize(array, index);
        int l = array.length;
        int lSqrt = (int)Math.sqrt(l);
        if (lSqrt * lSqrt != l){
            System.out.println("Il numero di numeri non e' un quadrato");
        }
        else{
            boolean foundErr = false; 
            for (int i = 0; i < l && !foundErr; i++){
                if (array[i] > l || array[i] < 1){ // verifica che siano in [1, n^2]
                    foundErr = true;
                }
                for (int j = 0; j < l && !foundErr; j++){ // verifica che non ci siano duplicati
                    if (i != j && array[i] == array[j]){
                        foundErr = true;
                    }
                }
            }
            if (foundErr){
                System.out.println("I numeri inseriti non sono validi");
            }
            // se non ci sono duplicati e sono tutti in [1, n^2] allora i numeri sono,
            // essendo tutti interi, tutti i valori da [1, n^2]
            else{
                int[][] square = new int[lSqrt][lSqrt];
                int sum = 0;
                boolean isSumValid = true;
                for (int i = 0; i < lSqrt; i++){
                    for (int j = 0; j < lSqrt; j++){
                        square[i][j] = array[lSqrt * i + j];
                    }
                }
                for (int i = 0; i < lSqrt; i++){
                    sum += square[0][i];
                }
                int partSum = 0;
                int partSum1 = 0;
                for (int i = 0; i < lSqrt && isSumValid; i++){
                    partSum = 0;
                    for (int j = 0; j < lSqrt; j++){
                        partSum += square[i][j];
                    }
                    if (partSum != sum){
                        isSumValid = false;
                    }
                }
                for (int j = 0; j < lSqrt && isSumValid; j++){
                    partSum = 0;
                    for (int i = 0; i < lSqrt; i++){
                        partSum += square[i][j];
                    }
                    if (partSum != sum){
                        isSumValid = false;
                    }
                }
                for (int i = 0; i < lSqrt && isSumValid; i++){
                    partSum += square[i][i];
                    partSum1 += square[lSqrt - i - 1][i];
                }
                if (partSum != sum && partSum1 != sum){
                    isSumValid = false;
                }
                if (isSumValid){
                    System.out.println("Il quadrato magico e' valido");
                }
                else{
                    System.out.println("Il quadrato magico non e' valido");
                }
            }
        }
    }
}
