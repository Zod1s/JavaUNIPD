import java.util.*;
import java.io.*;
public class StudentManager{
    public static void main(String[] args){
        try(FileReader reader = new FileReader("input.txt")){
            Scanner s = new Scanner(System.in);
            Scanner parser = new Scanner(reader);
            Student[] infos = new Student[1];
            int index = 0;
            while(parser.hasNextLine()){
                infos[index++] = new Student(parser.nextLine());
                if (index == infos.length){
                    Student[] temp = new Student[2 * index];
                    System.arraycopy(infos, 0, temp, 0, index);
                    infos = temp;
                }
            }
            parser.close();
            reader.close();
            Student[] temp = new Student[index];
            System.arraycopy(infos, 0, temp, 0, index);
            infos = temp;
            boolean done = false;
            while(!done){
                System.out.println("Inserire un comando (Q,S): ");
                String cmd = s.nextLine();
                if(cmd.equals("Q")){
                    done = true;
                }
                else if(cmd.equals("S")){
                    System.out.println("Inserire un cognome");
                    String cognome = s.nextLine();
                    index = -1;
                    boolean found = false;
                    for (int i = 0; i < infos.length && !found; i++){
                        if (infos[i].getName().equals(cognome)){
                            found = true;
                            index = i;
                        }
                    }
                    if (found){
                        System.out.println(infos[index].average());
                    }
                    else{
                        System.out.println("Studente non trovato");
                    }
                }
                else{
                    System.out.println("Comando non riconosciuto");
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("IO Exception");
        }
        //     System.out.println("Inserire un comando (Q, S): ");
        //     String cmd = s.nextLine();
        //     if (cmd.equals("Q")){
        //         done = true;
        //     }
        //     else if (cmd.equals("S")){
        //         System.out.println("Inserire un cognome");
        //         String cognome = s.nextLine();
        //         String studente = "";
        //         boolean found = false;
        //         for (int i = 0; i < infos.length && !found; i++){
        //             String cogn = new Scanner(infos[i]).next();
        //             if (cognome.equals(cogn)){
        //                 found = true;
        //                 studente += infos[i];
        //             }
        //         }
        //         if (!found){
        //             System.out.println("Studente non presente");
        //         }
        //         else{
        //             Scanner parser = new Scanner(studente);
        //             parser.next();
        //             int written = parser.nextInt();
        //             int oral = parser.nextInt();
        //             System.out.println((written + oral) / 2);
        //         }
        //     }
        //     else{
        //         System.out.println("Comando errato");
        //     }
        // }
    }
}
