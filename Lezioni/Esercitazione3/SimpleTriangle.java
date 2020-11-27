public class SimpleTriangle{
    private int a;
    private int b;
    private int c;

    public SimpleTriangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int perimeter(){
        return a + b + c;
    }

    public double area(){
        double p = perimeter() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public String toString(){
        return "SimpleTriangle " + a + " " + b + " " + c; 
    }
}
