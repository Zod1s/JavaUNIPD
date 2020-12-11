public class QuadraticTester{
    public static void main(String[] args){
        if (args.length < 3 || args[2] == null){
            throw new IllegalArgumentException();
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        Quadratic q = new Quadratic(a, b, c);
        System.out.println(q);
        System.out.println(q.getSolution1());
        System.out.println(q.getSolution2());
    }
}
