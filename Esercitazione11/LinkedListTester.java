import java.util.*;
public class LinkedListTester{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Random random = new Random(0);
        LinkedList list = new LinkedList();
        boolean done = false;
        int n = 0;
        do{
            System.out.println("Inserire un numero intero maggiore di 0: ");
            try{
                n = s.nextInt();
                if (n > 0){
                    done = true;
                }
                else{
                    System.out.println("Non è un numero intero maggiore di 0");
                }
            }
            catch(NoSuchElementException e){
                System.out.println("Non è stato inserito un intero");
                s.nextLine();
            }
        } while(!done);
        // System.out.println(n);
        for (int i = 0; i < n; i++){
            int next = random.nextInt(100) + 1;
            if (i % 2 == 0){
                list.addFirst(next);
            }
            else{
                list.addLast(next);
            }
            System.out.println("Next: " + next);
            System.out.println("List: " + list);
        }

        done = false;
        n = 0;
        do{
            System.out.println("Inserire dopo quale elemento vuoi inserire 1000: ");
            try{
                n = s.nextInt();
                done = true;
            }
            catch(NoSuchElementException e){
                System.out.println("Non è stato inserito un intero");
                s.nextLine();
            }
        } while(!done);
        ListIterator iter = list.getIterator();
        while (iter.hasNext()){
            if (iter.next().equals(n)){
                iter.add(1000);
            }
        }
        System.out.println(list);

        done = false;
        n = 0;
        do{
            System.out.println("Inserire quale elemento vuoi eliminare: ");
            try{
                n = s.nextInt();
                done = true;
            }
            catch(NoSuchElementException e){
                System.out.println("Non è stato inserito un intero");
                s.nextLine();
            }
        } while(!done);
        iter = list.getIterator();
        while (iter.hasNext()){
            if (iter.next().equals(n)){
                iter.remove();
            }
        }
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        s.close();
    }
}