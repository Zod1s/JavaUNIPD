package ADTs.Set;
public interface SortedSetInterface extends SetInterface{
    void add(Comparable obj); // ho due metodi add che hanno firma diversa
    Comparable[] toSortedArray();
}