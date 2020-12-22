public class Sospetti{
    private String nome;
    private int[] nSTR;

    public Sospetti(String name){
        nome = name;
        nSTR = new int[0];
    }

    public Sospetti(String name, int[] str){
        nome = name;
        if(str == null || str.length < 1) throw new IllegalArgumentException();
        nSTR = new int[str.length];
        for(int i = 0; i < str.length; i++)
            nSTR[i] = str[i];
    }

    public void addSTR(int n){
        nSTR = ArrayUtil.resize(nSTR, nSTR.length + 1);
        nSTR[nSTR.length - 1] = n;
    }

    public String getNome(){
        return nome;
    }

    public int[] getNstr(){
        return nSTR;
    }

    public boolean verifica(int[] elementi){
        if(elementi == null || elementi.length < 1) throw new IllegalArgumentException();
        if(elementi.length != nSTR.length) // qui devi mettere != invece di >, altrimenti potresti avere che elementi è più corto di nSTR e anche in quel caso devi ritornare false
            return false;
        for(int i = 0; i < elementi.length; i++){
            if(elementi[i] != nSTR[i])
                return false;
        }
        return true;
    }

    // aggiungo un metodo toString per vedere se le informazioni sono state parsate correttamente
    public String toString(){
        String r = nome;
        for (int i = 0; i < nSTR.length; i++){
            r += " " + nSTR[i];
        }
        return r;
    }
}