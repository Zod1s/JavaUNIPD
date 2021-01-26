class Permutation{
    public static String[] getPermutationsNew(String word){
        if (word == null) throw new IllegalArgumentException();
        if (word.length() < 2) return new String[] {word};
        int k = 0;
        String[] permutations = new String[fattorialeIt(word.length())];
        for (int i = 0; i < word.length(); i++) {
            String shorterWord = word.substring(0, i) + word.substring(i + 1);
            String[] shorterWordPermutations = getPermutationsNew(shorterWord);

            for (int j = 0; j < shorterWordPermutations.length; j++) {
                permutations[k++] = word.charAt(i) + shorterWordPermutations[j];
            }
        }
        return permutations;
    }

    public static int fattorialeIt(int n){
        if (n < 0) throw new IllegalArgumentException();
        int result = 1;
        for (int k = 2; k <= n; k++)
            result *= k;
        return result;
    }

    public static void main(String[] args){
        String[] per = getPermutationsNew(args[0]);
        int i = 1;
        System.out.println("s: " + args[0]);
        System.out.println("Permutations: ");
        for (String s : per)
            System.out.println(i++ + " " + s);
    }
}