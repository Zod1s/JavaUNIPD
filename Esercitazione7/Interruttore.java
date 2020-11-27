public class Interruttore{
    private boolean state;
    private static boolean lamp = false;
    
    public Interruttore(){
        state = false;
    }

    public boolean getStatusInterruttore(){
        return state;
    }

    public boolean isBulbOn(){
        return lamp;
    }

    public void changeStatus(){
        state = !state;
        lamp = !lamp;
    }

    public String printStatus(){
        return toString();
    }
    
    public String toString(){
        if (state){
            return "up";
        }
        else{
            return "down";
        }
    }
}
