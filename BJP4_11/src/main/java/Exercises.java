import java.util.*;

public class Exercises {
    public static void main(String[] args) {

        List<Integer> list_countUnique = new ArrayList<>();
        list_countUnique.add(3);
        list_countUnique.add(7);
        list_countUnique.add(3);
        list_countUnique.add(-1);
        list_countUnique.add(2);
        list_countUnique.add(3);
        list_countUnique.add(7);
        list_countUnique.add(2);
        list_countUnique.add(15);
        list_countUnique.add(15);

        List<Integer> list_countCommon = new ArrayList<>();
        list_countCommon.add(-5);
        list_countCommon.add(15);
        list_countCommon.add(2);
        list_countCommon.add(-1);
        list_countCommon.add(7);
        list_countCommon.add(15)
        list_countCommon.add(36);

        Set<String> set_maxLength = new HashSet<>();
        set_maxLength.add("a");
        set_maxLength.add("do");
        set_maxLength.add("run");
        set_maxLength.add("four");
        set_maxLength.add("spanner");

        Set<Integer> set_hasOdd = new HashSet<>();
        set_hasOdd.add(4);
        set_hasOdd.add(3);
        set_hasOdd.add(2);

        Set<String> set_removeEvenLength = new HashSet<>();
        set_removeEvenLength.add("foo");
        set_removeEvenLength.add("buzz");
        set_removeEvenLength.add("bar");
        set_removeEvenLength.add("fork");
        set_removeEvenLength.add("bort");
        set_removeEvenLength.add("spoon");
        set_removeEvenLength.add("!");
        set_removeEvenLength.add("dude");

        List<String> list_contains3 = new ArrayList<>(set_removeEvenLength);
        list_contains3.add("fork");

        Map<String, String> map_isUnique = new HashMap<>();
        map_isUnique.put("Marty", "Stepp");
        map_isUnique.put("Stuart", "Reges");
        map_isUnique.put("Jessica", "Miller");
        map_isUnique.put("Amanda", "Camp");
        map_isUnique.put("Hal", "Perkins");

        Map<String, Integer> map1_intersect = new HashMap<>();
        map1_intersect.put("Janet", 87);
        map1_intersect.put("Logan", 62);
        map1_intersect.put("Whitaker", 46);
        map1_intersect.put("Alyssa", 100);
        map1_intersect.put("Stefanie", 80);
        map1_intersect.put("Jeff", 88);
        map1_intersect.put("Kim", 52);
        map1_intersect.put("Sylvia", 95);

        Map<String, Integer> map2_intersect = new HashMap<>();
        map2_intersect.put("Logan", 62);
        map2_intersect.put("Kim", 52);
        map2_intersect.put("Whitaker", 52);
        map2_intersect.put("Jeff", 88);
        map2_intersect.put("Stefanie", 80);
        map2_intersect.put("Brian", 60);
        map2_intersect.put("Lisa", 83);
        map2_intersect.put("Sylvia", 87);

        List<Integer> list_maxOccurences = new ArrayList<>();
        list_maxOccurences.add(3);
        list_maxOccurences.add(89);
        list_maxOccurences.add(32);
        list_maxOccurences.add(32);
        list_maxOccurences.add(76);
        list_maxOccurences.add(76);
        list_maxOccurences.add(76);
        list_maxOccurences.add(76);
        list_maxOccurences.add(76);
        list_maxOccurences.add(1);

        Map<Integer, String> map_reverse = new HashMap<>();
        map_reverse.put(42, "Marty");
        map_reverse.put(81, "Sue");
        map_reverse.put(17, "Ed");
        map_reverse.put(31, "Dave");
        map_reverse.put(56, "Ed");
        map_reverse.put(3, "Marty");
        map_reverse.put(29, "Ed");

        Map<String, Integer> map_rarest = new HashMap<>();
        map_rarest.put("Alyssa", 22);
        map_rarest.put("Char", 25);
        map_rarest.put("Dan", 25);
        map_rarest.put("Jeff", 20);
        map_rarest.put("Kasey", 20);
        map_rarest.put("Kim", 20);
        map_rarest.put("Mogran", 25);
        map_rarest.put("Ryan", 25);
        map_rarest.put("Steff", 22);


        // *** Ch 11. Ex. 6 ***

        // System.out.println(list_countUnique);
        // System.out.println(countUnique(list_countUnique));


        // *** Ch 11. Ex. 7 ***
        // System.out.println(countCommon(list_countUnique, list_countCommon));


        // *** Ch 11. Ex. 8 ***
        // System.out.println(maxLength(set_maxLength));


        // *** Ch 11. Ex. 9 ***
        // System.out.println(hasOdd(set_hasOdd));


        // *** Ch 11. Ex. 10 ***
        // removeEvenLength(set_removeEvenLength);
        // System.out.println(set_removeEvenLength);


        // *** Ch 11. Ex. 12 ***
        // System.out.println(contains3(list_contains3));


        // *** Ch 11. Ex. 13 ***
        // System.out.println(isUnique(map_isUnique));


        // *** Ch 11. Ex. 14 ***
        // System.out.println();
        // System.out.println(intersect(map1_intersect, map2_intersect));


        // *** Ch. 11. Ex. 15 ***
        System.out.println(maxOccurrences(list_maxOccurences));


        // *** Ch. 11. Ex. 18 ***
        // System.out.println(reverse(map_reverse));

        // *** Ch. 11 Ex. 19 ***
        // System.out.println(rarest(map_rarest));


    }

    public static int countUnique(List<Integer> list) {
        // Ch. 11 Ex. 6

        return new HashSet<>(list).size();
    }

    public static int countCommon(List<Integer> list1, List<Integer> list2) {
        // Ch 11. Ex. 7

        Set<Integer> s1 = new HashSet<>(list1);
        Set<Integer> s2 = new HashSet<>(list2);
        s1.retainAll(s2);

        return s1.size();
    }

    public static int maxLength(Set<String> s) {
        // Ch 11. Ex. 8

        if (s.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (String n: s) {
            if (n.length() > count) {
                count = n.length();
            }

        }

        return count;
    }

    public static boolean hasOdd(Set<Integer> set1) {
        // Ch 11. Ex. 9
        for (int n: set1) {
            if (n % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public static void removeEvenLength(Set<String> set) {
        // Ch. 11 Ex. 10
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public static boolean contains3(List<String> list) {
        // Ch. 11 Ex. 12
        Map<String, Integer> map = new HashMap<>();

        for (String s: list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (int count: map.values()) {
            if (count >= 3) {
                return true;
            }
        }

        return false;
    }

    public static boolean isUnique(Map<String, String> map) {
        // Ch. 11 Ex. 13
        return new HashSet<>(map.values()).size() == map.values().size();
    }

    public static Map<String, Integer> intersect(Map<String, Integer> map1,
                                                 Map<String, Integer> map2) {
        // Ch. 11 Ex. 15

        Map<String, Integer> mapIntersect = new HashMap<>(map1);
        mapIntersect.keySet().retainAll(map2.keySet());
        mapIntersect.values().retainAll(map2.values());

        return mapIntersect;
    }




    public static int maxOccurrences(List<Integer> list) {
        // Ch 11. Ex. 15

        if (list.size() < 1) {
            return 0;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        for (int idx: list) {
            if (!map.containsKey(idx)) {
                map.put(idx, 1);
            } else {
                map.put(idx, map.get(idx) + 1);
            }
        }
        int count = 0;
        for (int i: map.values()) {
            if ( i > count) {
                count = i;
            }
        }

        return count;
    }

    public static Map<String, Integer> reverse(Map<Integer, String> map) {
        // Ch. 11 Ex. 18

        Map<String, Integer> mapReverse = new HashMap<>();

        for (int key : map.keySet()) {
            mapReverse.put(map.get(key), key);
        }

        return mapReverse;
    }

    public static int rarest(Map<String, Integer> map) {
        // Ch. 11 Ex. 19

        // returns the integer value that occurs the fewest times in the map.
        // If there is a tie, return the smaller integer value.

        if (map.isEmpty()) {
            throw new IllegalArgumentException("There's been an exception folks!");
        }
        Iterator<Integer> itr = map.values().iterator();
        int count = 1000000000;
        while (itr.hasNext()) {
            if (itr.next() < count) {
                count = itr.next();
            }
        }
        System.out.println(count);
        return 0;
    }


}
