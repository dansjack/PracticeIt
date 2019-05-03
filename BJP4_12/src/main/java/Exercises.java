import static java.lang.Integer.parseInt;

public class Exercises {
    public static void main(String[] args) {
        int i = 1234567;
        int j = 67;
        System.out.println(digitMatch(i, j));

    }

    public static int digitMatch(int d1, int d2) throws IllegalArgumentException {
        // Ch. 12 Ex. 10
        
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
            // At least one integer is negative
            throw new IllegalArgumentException();
        }

        if ((s1.length() == 1 && s2.length() == 1) && s1.charAt(0) == s2.charAt(0)) {
            // The integers are both one digit long AND are equal to each other
            return 1;
        } else if (s1.length() == 1 && s2.length() == 1){
            return 0;
        }

        if (s1.length() > s2.length()) {
            // int 1 has more digits than int 2, subtract a digit from int 1
            s1 = s1.substring(1);
            return digitMatch(Integer.parseInt(s1), d2);

        } else if (s1.length() < s2.length()) {
            // int 2 has more digits than int 1, subtract a digit from int 2
            s2 = s2.substring(1);
            return digitMatch(d1, Integer.parseInt(s2));

        } else {
            int recursive = digitMatch(Integer.parseInt(s1.substring(0,
                    s1.length() - 1)), Integer.parseInt(s2.substring(0,
                    s2.length() - 1)));

            if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1)) {
                // last digits of ints 1 and 2 are equal, add one to the count
                return 1 + recursive;

            } else {
                return recursive;
            }
        }
    }
}