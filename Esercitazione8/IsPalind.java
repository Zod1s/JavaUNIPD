public class IsPalind{
    public static void main(String[] args){
        if (args[0] == null){
            throw new IllegalArgumentException();
        }
        else{
            String str = args[0];
            System.out.println(isPalind(str));
        }
    }
    public static boolean isPalind(String str){
        if (str.length() <= 1){
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)){
            return false;
        }
        return isPalind(str.substring(1, str.length() - 1));
    }
}
