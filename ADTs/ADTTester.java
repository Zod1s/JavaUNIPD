import ADTs.Set.*;
public class ADTTester{
    public static void main(String[] args){
        SortedArraySet set = new SortedArraySet();
        set.add(1);
        set.add(5);
        set.add(2);
        Object[] s = set.toSortedArray();
        for (int i = 0; i < s.length; i++){
            System.out.println(s[i]);
        }
        System.out.println(set.contains(4));
        System.out.println(set.contains(1));
    }
}