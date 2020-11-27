public class SimpleAircraft{
    private String model;
    private String state;
    private String airport;
    private SimpleAirRoute airRoute;
    private double maxLength;
    private double maxHeight;
    private double kilometers;
    private double maxKilometers;

    public SimpleAircraft(String m, String a, double maxL, double maxH, double maxKm){
        model = m;
        airport = a;
        maxLength = maxL;
        maxHeight = maxH;
        kilometers = 0;
        maxKilometers = maxKm;
        state = "LANDED";
        airRoute = null;
    }

    public double getMileage(){
        return kilometers;
    }

    public String getState(){
        return state;
    }

    public boolean goHangar(){
        if (!state.equals("FLYING")){
            state = "MAINENTANCE";
            kilometers = 0;
            airRoute = null;
            return true;
        }
        return false;
    }

    public boolean land(){
        if (state.equals("FLYING")){
            state = "LANDED";
            airport = airRoute.getToAirport();
            kilometers += airRoute.getAirRouteLength();
            if (kilometers >= maxKilometers){
                state = "MAINENTANCE";
            }
            return true;
        }
        return false;
    }

    public boolean setSchedule(SimpleAirRoute ar){
        if (state.equals("LANDED") && airport.equals(ar.getFromAirport()) && maxLength == ar.getAirRouteLength()
            && maxHeight == ar.getAirRouteMaxAltitude() && kilometers < maxKilometers){
            state = "SCHEDULED";
            airRoute = ar;
            return true;    
        }
        return false;
    }

    public boolean takeOff(){
        if (state.equals("SCHEDULED")){
            state = "FLYING";
            return true;
        }
        return false;
    }

    public String toString(){
        return "Aircraft "+model+", state: "+state+", air route: "+airRoute+", airport: "+airport+
            ", kilometers travelled: "+kilometers+", max kilometers: "+maxKilometers+", max altitude: "+
            maxHeight+", max length: "+maxLength+"\n\n";
    }
}
