public class SimpleCar{
    private double speed;
    private int gear;
    public static final double INITIAL_SPEED = 10;
    public static final int MIN_GEAR = 0;
    public static final int MAX_GEAR = 6;
    public static final double SPEED_INCREMENT_PERCENT = 0.5;
    public static final double SPEED_DECREMENT_PERCENT = 0.3;

    public SimpleCar(){
        speed = 0;
        gear = 0;
    }

    public String toString(){
        return "SimpleCar: marcia = "+gear+" ,velocita' = "+speed;
    }

    public void brake(){
        if (speed <= 5) speed = 0;
        else speed *= (1 - SPEED_DECREMENT_PERCENT);
    }

    public void gearDown(){
        if (gear > MIN_GEAR){
            gear--;
        }
    }

    public void gearUp(){
        if (gear < MAX_GEAR){
            gear++;
        }
    }

    public void speedUp(){
        if (speed == 0){
            speed = INITIAL_SPEED;
        }
        else{
            speed *= (1 + SPEED_INCREMENT_PERCENT);
        }
    }
}
