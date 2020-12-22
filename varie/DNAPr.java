import java.util.*;
import java.io.*;
public class DNAPr{
	public static void main(String[] args){
		try(FileReader readNomi= new FileReader(args[0]);Scanner nomi=new Scanner(readNomi);FileReader readSequenza= new FileReader(args[1]);Scanner sequenzaScan=new Scanner(readSequenza)){
			int nSTR=0;
			int nPersone=0;
			Scanner riga;
			String sequenza=sequenzaScan.nextLine();
			sequenza=sequenza.toUpperCase();
			char ch;
			String[] STR=new String[100];
			Sospetti[] persone=new Sospetti[100];
			int[] nSTRPresenti;
			Sospetti persona;
			boolean trovato=false;
			
			if(nomi.hasNextLine())
				riga=new Scanner(nomi.nextLine());
			else throw new IllegalArgumentException(); //nel caso in cui il file fosse vuoto	
			
			//if(riga.hasNext())
				riga.next();
			//else throw new IllegalArgumentException(); //nel caso in cui il file fosse vuoto
			for(nSTR=0;riga.hasNext();nSTR++){
				if(STR.length<=nSTR)
					ArrayUtil.resize(STR,STR.length*2);
				STR[nSTR]=riga.next().toUpperCase();
			}
			for(int i=0;i<nSTR;i++){
			
				System.out.println(STR[i]);
			}
			
			for(nPersone=0;nomi.hasNextLine();nPersone++){
				riga=new Scanner(nomi.nextLine());
			
				if(persone.length<=nPersone)
					ArrayUtil.resize(persone,persone.length*2);
					
				//if(riga.hasNext())
					persona= new Sospetti(riga.next());
				//else throw new IllegalArgumentException();	
				persone[nPersone]= persona;  
				while(riga.hasNext())
					persone[nPersone].addSTR(Integer.parseInt(riga.next()));
			}
			
			nSTRPresenti= new int[nSTR];
			while(sequenza.length()>=4){
				System.out.println(sequenza+"\n");
				ch=sequenza.charAt(0);
				for(int j=0;j<nSTR;j++){
					if(ch==STR[j].charAt(0)){
						System.out.println(ch+"=="+STR[j].charAt(0)+" ora li confrontano");
						if(confronto(STR[j],sequenza)){
							System.out.println("sono uguali, quindi incremento nSTRPresenti[j]"+nSTRPresenti[j]);
							nSTRPresenti[j]++;
							System.out.println("ora è uguale a "+nSTRPresenti[j]);
						}
					}
				}
				sequenza=sequenza.substring(1);
			}
			
			for(int i=0;i<nPersone;i++){
				if(persone[i].verifica(nSTRPresenti)){
					trovato=true;
					System.out.println("Il colpevole e': "+persone[i].getNome());
				}
			}
			
			if(!trovato)
				System.out.println("Il colpevole non e' stato trovato");
		
		}catch (FileNotFoundException e){
			System.err.println("File non trovato");
		}catch (IOException e){
			System.err.println("Errore nella chiusura del file");
		}catch (ArrayIndexOutOfBoundsException e){
			System.err.println("Inserire come parametri i nomi dei file");
		}catch (IllegalArgumentException e){
			System.err.println("Contenuto del file errato!");
	}
}
	private static boolean confronto(String s1, String s2){
		if(s1.length()!=4)
			s2=s2.substring(0,4);
		else if(s1.length()!=4)
			s1=s1.substring(0,4);
		System.out.println("confronto tra: "+s1 +" e "+s2);
		return s1.equals(s2);
	}

}
