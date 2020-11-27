public class Exchange{
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("a: "+a);
        System.out.println("b: "+b);
    }
}
