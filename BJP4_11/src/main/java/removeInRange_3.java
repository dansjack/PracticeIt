import java.util.ArrayList;
import java.util.List;

public class removeInRange_3 {
    public static void main(String[] args) {
        // Write a method called removeInRange that accepts four parameters: a
        // List of integers, an element value, a starting index, and an ending
        // index. The method's behavior is to remove all occurrences of the
        // given element that appear in the list between the starting index
        // (inclusive) and the ending index (exclusive). Other values and
        // occurrences of the given value that appear outside the given index
        // range are not affected.
        //
        // For example, for the list
        // (0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16), a call of
        // removeInRange(list, 0, 5, 13) should produce the list
        // (0, 0, 2, 0, 4, 6, 8, 10, 12, 0, 14, 0, 16). Notice that the zeros
        // located at indices between 5 inclusive and 13 exclusive in the
        // original list (before any modifications were made) have been removed.
        List<Integer> newList = new ArrayList<>();
        newList.add(0);
        newList.add(0);
        newList.add(2);
        newList.add(0);
        newList.add(4);
        newList.add(0);
        newList.add(6);
        newList.add(0);
        newList.add(8);
        newList.add(0);
        newList.add(10);
        newList.add(0);
        newList.add(12);
        newList.add(0);
        newList.add(14);
        newList.add(0);
        newList.add(16);
        System.out.println(newList);
        removeInRange(newList, 0, 5, 13);
        System.out.println(newList);
    }

    public static void removeInRange(List<Integer> intList, int idxVal,
                                     int idxStart, int idxStop) {
        for (int i = idxStop - 1; i >= idxStart; i--) {
            // Start at the end of the slice and work towards the front
            if (intList.get(i) == idxVal) {
                // remove the value if it matches idxVal
                intList.remove(i);
            }
        }
    }
}
