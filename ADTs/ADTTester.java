import ADTs.Map.*;
public class ADTTester {
    public static void main(String[] args){
        MapArray map = new MapArray();
        map.put("Primo", 1);
        map.put("Secondo", 2);
        map.put("Terzo", 3);
        Object a = map.put("Terzo", 4);
        System.out.println(a);
    }
}