public class ArrayUtil{
    public static int[] resize(int[] vecchioArray, int nuovaLunghezza){
        if(vecchioArray == null || nuovaLunghezza < 0) throw new IllegalArgumentException();
        int lunghezza = vecchioArray.length;
        if(nuovaLunghezza < lunghezza)
            lunghezza = nuovaLunghezza;
        int[] nuovoArray = new int[nuovaLunghezza];
        for(int i = 0; i < lunghezza; i++){
            nuovoArray[i] = vecchioArray[i];
        }
        return nuovoArray;
    }

    public static Sospetti[] resize(Sospetti[] vecchioArray, int nuovaLunghezza){
        if(vecchioArray == null || nuovaLunghezza < 0) throw new IllegalArgumentException();
        int lunghezza = vecchioArray.length;
        if(nuovaLunghezza < lunghezza)
            lunghezza = nuovaLunghezza;
        Sospetti[] nuovoArray = new Sospetti[nuovaLunghezza];
        for(int i = 0; i < lunghezza; i++){
            nuovoArray[i] = vecchioArray[i];
        }
        return nuovoArray;
    }

    public static String[] resize(String[] vecchioArray, int nuovaLunghezza){
        if(vecchioArray == null || nuovaLunghezza < 0) throw new IllegalArgumentException();
        int lunghezza = vecchioArray.length;
        if(nuovaLunghezza < lunghezza)
            lunghezza = nuovaLunghezza;
        String[] nuovoArray = new String[nuovaLunghezza];
        for(int i = 0; i < lunghezza; i++){
            nuovoArray[i] = vecchioArray[i];
        }
        return nuovoArray;
    }
}
