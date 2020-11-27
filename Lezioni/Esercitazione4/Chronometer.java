public class Chronometer{
    private boolean running, ready;
    private double time;
    private double savedTime;
    public Chronometer(){
        running = false;
        ready = false;
        time = 0;
        savedTime = 0;
    }

    public boolean isRunning(){
        return running;
    }

    public boolean isTimeReady(){
        return ready;
    }

    public void reset(){
        savedTime = 0;
    }

    public void start(){
        time = (double)System.currentTimeMillis();
        running = true;                                          
    }

    public void stop(){
        double end = (double)System.currentTimeMillis();
        savedTime = end - time;
        savedTime /= 1000;
        running = false;
        ready = true;
    }

    public String toString(){
        String r = "Chronometer";
        if (running){
            return r + " running, time: " + String.format("%.4f", savedTime) + "s";
        }
        else if (ready){
            return r + " ready, time: " + String.format("%.4f", savedTime) + "s";
        }
        else{
            return r + " off, time: " + String.format("%.4f", savedTime) + "s";
        }
    }
}


