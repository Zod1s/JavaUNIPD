import java.util.Scanner;

public class DNA{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Inserire una sequenza di DNA: ");
        String dna = s.nextLine().toUpperCase();
        boolean valid = true;
        String newDna = "";
        for (int i = 0; i < dna.length() && valid; i++){
            if (dna.charAt(i) != 'A' && dna.charAt(i) != 'T' && dna.charAt(i) != 'C' && dna.charAt(i) != 'G'){
                valid = false;
            }
            else{
                switch(dna.charAt(i)){
                case 'A':
                    newDna = 'T' + newDna;
                    break;
                case 'T':
                    newDna = 'A' + newDna;
                    break;
                case 'C':
                    newDna = 'G' + newDna;
                    break;
                default:
                    newDna = 'C' + newDna;
                    break;
                }
            }
        }
        if (valid){
            System.out.println(newDna);
        }
        else{
            System.out.println("DNA non valido");
        }
        s.close();
    }
}
