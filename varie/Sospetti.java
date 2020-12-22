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
		if(elementi.length > nSTR.length)
			return false;
		for(int i = 0; i < elementi.length; i++){
			if(elementi[i] != nSTR[i])
				return false;
		}
		return true;
	}
}
