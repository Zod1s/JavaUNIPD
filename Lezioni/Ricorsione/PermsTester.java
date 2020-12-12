public class PermsTester{
    public static void main(String[] args){
        String s = "abcd";
        String[] p = Permutations.perm(s);
        for (int i = 0; i < p.length; i++){
            System.out.println(p[i]);
        }
    }
}
