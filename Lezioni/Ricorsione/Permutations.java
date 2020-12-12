public class Permutations{
    public static String[] perm(String str){
        if (str == null) throw new IllegalArgumentException();
        if (str.length() < 2){
            return new String[] {str};
        }
        int k = 0;
        String[] perms = new String[factorial(str.length())];
        for (int i = 0; i < str.length(); i++){
            String shorterStr = str.substring(0, i) + str.substring(i + 1);
            String[] shorterPerms = perm(shorterStr);
            for (int j = 0; j < shorterPerms.length; j++){
                perms[k++] = str.charAt(i) + shorterPerms[j];
            }
        }
        return perms;
    }

    public static int factorial(int a){
        int i = 1;
        for (int j = 2; j <= a; j++){
            i *= j;
        }
        return i;
    }
}
