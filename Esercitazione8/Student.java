import java.util.InputMismatchException;
// import java.util.NumberFormatException;

public class Student{
    private String name;
    private int written;
    private int oral;

    public Student(String n, int w, int o){
        name = n;
        written = w;
        oral = o;
    }

    public Student(String s){
        String[] contents = s.split(" ");
        name = contents[0];
        try{
            written = Integer.parseInt(contents[1]);
            oral = Integer.parseInt(contents[2]);
        }
        catch(InputMismatchException e){
            throw new InputMismatchException();
        }
        catch(NumberFormatException e){
            throw new NumberFormatException();
        }
    }
    
    public String getName(){
        return name;
    }

    public int average(){
        return (written + oral) / 2;
    }

    public String toString(){
        return name + " " + written + " " + oral;
    }
}
