public class ArrayUtil{
    public static int[] resize(int[] a, int newL){
        int[] newA = new int[newL];
        if (newL >= a.length){
            System.arraycopy(a, 0, newA, 0, a.length);
        }
        else{
            System.arraycopy(a, 0, newA, 0, newL);
        }
        return newA;
    }

    public static double[] resize(double[] a, int newL){
        double[] newA = new double[newL];
        if (newL >= a.length){
            System.arraycopy(a, 0, newA, 0, a.length);
        }
        else{
            System.arraycopy(a, 0, newA, 0, newL);
        }
        return newA;
    }

    
    public static void display(int[] c){
        for (int i = 0; i < c.length; i++){
            System.out.print(c[i]+" ");
        }
        System.out.println();
    }

    public static void display(double[] c){
        for (int i = 0; i < c.length; i++){
            System.out.print(c[i]+" ");
        }
        System.out.println();
    }

}
