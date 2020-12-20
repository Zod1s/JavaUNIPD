public class Array{
    public static void main(String[] args){
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++){
            a[i] = i+1;
        }
        method(a);
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for (int i = a.length - 1; i >= 0; i--){
            System.out.print(a[i]+" ");
        }
        int a = 1;
        System.out.println(a);
        method(a);
        System.out.println(a);
        // int[] a = {1,2,3,4,5,6,7,8,9,10};
        // int[] b = ArrayUtil.resize(a, 12);
        // ArrayUtil.display(b);
    }

    public static void method(int[] ar){
        for (int i = 0; i < ar.length; i++){
            ar[i] += 1;
        }
    }

    public static void method(int b){
        b += 1;
    }
}
