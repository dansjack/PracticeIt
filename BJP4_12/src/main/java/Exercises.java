public class Exercises {
    public static void main(String[] args) {
        int i = 122344;
        int j = 12234;
        System.out.println(digitMatch(i, j));

    }

    public static int digitMatch(int d1, int d2) throws NumberFormatException {
        // Write a recursive method digitMatch that accepts two non-negative
        // integers as parameters and that returns the number of digits that
        // match between them. Two digits match if they are equal and have the
        // same position relative to the end of the number (i.e. starting with
        // the ones digit). In other words, the method should compare the last
        // digits of each number, the second-to-last digits of each number, the
        // third-to-last digits of each number, and so forth, counting how many
        // pairs match. For example, for the call of
        // digitMatch(1072503891, 62530841),
        // the method would compare as follows:

        // 1 0 7 2 5 0 3 8 9 1
        //     | | | | | | | |
        //     6 2 5 3 0 8 4 1
        // The method should return 4 in this case because 4 of these pairs
        // match (2-2, 5-5, 8-8, and 1-1).

        // Below are more examples:

        // Call	Value                Returned
        // digitMatch(38, 34)	      1
        // digitMatch(5, 5552)	      0
        // digitMatch(892, 892)	      3
        // digitMatch(298892, 7892)	  3
        // digitMatch(380, 0)	      1
        // digitMatch(123456, 654321) 0
        // digitMatch(1234567, 67)	  2

        // Your method should throw an IllegalArgumentException if either of
        // the two parameters is negative. You are not allowed to construct any
        // structured objects other than Strings (no array, List, Scanner, etc.)
        // and you may not use any loops to solve this problem; you must use
        // recursion.
        String s1 = String.valueOf(d1);
        String s2 =  String.valueOf(d2);

        if (d1 < 0 || d2 < 0) {
            throw new IllegalArgumentException();
        } else {
            if (s1.length() == 1 || s2.length() == 1) {
                if (s1.charAt(0) == s2.charAt(0)) {
                    return 1;
                } else {
                    return 0;
                }

        } else {
                // System.out.println("length1 " + s1.length());
                // System.out.println(s1.charAt(s1.length() - 1));
                // System.out.println("length2 " + s2.length());
                // System.out.println(s2.charAt(s2.length() - 1));
                if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
                    System.out.println("yes");
                    return 1 + digitMatch(Integer.parseInt(s1.substring(0, s1.length() - 1)) - 2, Integer.parseInt(s2.substring(0, s2.length() - 1)) - 2);
                } else {
                    System.out.println("nada");
                }
            }
        return 0;
    }
}
}