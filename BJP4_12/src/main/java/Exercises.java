import static java.lang.Integer.parseInt;

public class Exercises {
    public static void main(String[] args) {
        // ***Ex. 10.***
        // int i = 1234567;
        // int j = 67;
        // System.out.println(digitMatch(i, j));

        // ***Ex. 11.***
        // System.out.println(repeat("hi ho! ", 5));

        // ***Ex. 12.***
        // System.out.println(isReverse("CSE143", "341esc"));

        // ***Ex. 13 ***
        System.out.println(indexOf("Barack Obama", "McCain"));

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

        // Base cases:
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
            // Recursive cases:
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

    public static String repeat(String s, int n) {
        // Write a recursive method repeat that accepts a string s and an
        // integer n as parameters and that returns a String consisting of n
        // copies of s. For example:

        // Call	                      Value Returned
        // repeat("hello", 3)	      "hellohellohello"
        // repeat("this is fun", 1)	  "this is fun"
        // repeat("wow", 0)	          ""
        // repeat("hi ho! ", 5)	      "hi ho! hi ho! hi ho! hi ho! hi ho! "

        // You should solve this problem by concatenating String objects using
        // the + operator. String concatenation is an expensive operation, so it
        // is best to minimize the number of concatenation operations you
        // perform. For example, for the call repeat("foo", 500), it would be
        // inefficient to perform 500 different concatenation operations to
        // obtain the result. Most of the credit will be awarded on the
        // correctness of your solution independent of efficiency. The remaining
        // credit will be awarded based on your ability to minimize the number
        // of concatenation operations performed.

        // Your method should throw an IllegalArgumentException if passed any
        // negative value for n. You are not allowed to construct any structured
        // objects other than Strings (no array, List, Scanner, etc.) and you
        // may not use any loops to solve this problem; you must use recursion.

        if (n < 0) {
            throw new IllegalArgumentException("I can't go for that!");
        }

        if (n == 0) {
            return "";
        } else {
            return s + repeat(s, n - 1);
        }
    }

    public static boolean isReverse(String s1, String s2) {
        // Ch 12. Ex 12

        // Write a recursive method isReverse that accepts two strings as a
        // parameter and returns true if the two strings contain the same
        // sequence of characters as each other but in the opposite order
        // (ignoring capitalization), and false otherwise. For example, the
        // string "hello" backwards is "olleh", so a call of
        // isReverse("hello", "olleh") would return true. Since the method is
        // case-insensitive, you would also get a true result from a call of
        // isReverse("Hello", "oLLEh"). The empty string, as well as any
        // one-letter string, is considered to be its own reverse. The string
        // could contain characters other than letters, such as numbers, spaces,
        // or other punctuation; you should treat these like any other
        // character. The key aspect is that the first string has the same
        // sequence of characters as the second string, but in the opposite
        // order, ignoring case. The table below shows more examples:


        // Call	                            Value Returned
        // isReverse("CSE143", "341esc")....true
        // isReverse("Madam", "MaDAm")......true
        // isReverse("Q", "Q")..............true
        // isReverse("", "")................true
        // isReverse("e via n", "N aIv E")..true
        // isReverse("Go! Go", "OG !OG")....true
        // isReverse("Obama", "McCain").....false
        // isReverse("banana", "nanaba")....false
        // isReverse("hello!!", "olleh")....false
        // isReverse("", "x")...............false
        // isReverse("madam I", "i m adam").false
        // isReverse("ok", "oko")...........false

        // You may assume that the strings passed are not null. You are not
        // allowed to construct any structured objects other than Strings (no
        // array, List, Scanner, etc.) and you may not use any loops to solve
        // this problem; you must use recursion. If you like, you may declare
        // other methods to help you solve this problem, subject to the previous
        // rules.

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.length() != s2.length()) {
            // if string lengths don't match, false
            return false;
        }

        if (s1.length() == 1 && !s1.equals(s2)) {
            return false;
        } else if (s1.length() == 1 || s1.equals("")) {
            return true;
        }

        if (s1.charAt(0) == s2.charAt(s2.length() - 1)) {
            return isReverse(s1.substring(1), s2.substring(0, s2.length() - 1));

        } else {
            return false;
        }
    }

    public static int indexOf(String string1, String string2) {
        // *********** INCOMPLETE **********

        // returns the starting index of the first occurrence of the second
        // String inside the first String (or -1 if not found).

        if (string1.length() < string2.length()) {
        }

        if (string2.equals(string1.substring(0, string2.length()))) {
            return 0;
        } else {
            return 1 + indexOf(string1.substring(1), string2);

        }
    }
}