import static java.lang.Integer.parseInt;

public class Exercises {
    public static void main(String[] args) {

        // ***Ex. 3 ***
        // writeSequence(5);

        // ***Ex. 6 ***
        // writeSquares(8);

        // ***Ex. 7 ***
        // writeChars(4);

        // ***Ex. 8 ***
        // multiplyEvens(4); 384 2 * 4 * 6 * 8 = 384

        // ***Ex. 9 ***
        // multiplyEvens(4); 384 2 * 4 * 6 * 8 = 384

        // ***Ex. 10.***
        // int i = 1234567;
        // int j = 67;
        // System.out.println(digitMatch(i, j));

        // ***Ex. 11.***
        // System.out.println(repeat("hi ho! ", 5));

        // ***Ex. 12.***
        // System.out.println(isReverse("CSE143", "341esc"));

        // ***Ex. 13 ***
        // System.out.println(indexOf("Barack Obama", "BAR"));

        // ***Ex. 14 ***
        System.out.println(evenDigits(4109));

    }

    public static void writeSequence(int n) {
        String out = (n + 1) / 2 + " ";
        if (n < 1) {
            throw new IllegalArgumentException();
        } else if (n == 1) {
            System.out.println("1 ");
        } else {
            System.out.println(out);
            if (n != 2) {
                writeSequence(n - 2);
            }
            System.out.println(out);
        }
    }

    public static void writeSquares(int n) {
        // Ex 12.6
        if (n < 1) {
            throw new IllegalArgumentException();
        } else if (n == 1) {
            System.out.print("1");
        } else {
            if (n % 2 == 0) {
                // n is even, print squares in ascending order
                writeSquares(n - 1);
                System.out.print(", " + n * n);
            } else {
                // n is odd, print squares in descending order
                System.out.print(n * n + ", ");
                writeSquares(n - 1);
            }
        }
    }

    public static void writeChars(int n) {
        // Ex 12.17
        // Write a method writeChars that accepts an integer parameter n and
        // that prints out n characters as follows. The middle character of the
        // output should always be an asterisk ("*"). If you are asked to write
        // out an even number of characters, then there will be two asterisks in
        // the middle ("**"). Before the asterisk(s) you should write out
        // less-than characters ("<"). After the asterisk(s) you should write
        // out greater-than characters (">").

        // writeChars(1);	*
        // writeChars(2);	**
        // writeChars(3);	<*>
        // writeChars(4);	<**>
        // writeChars(5);	<<*>>
        // writeChars(6);	<<**>>
        // writeChars(7);	<<<*>>>
        // writeChars(8);	<<<**>>>

        // Your method should throw an IllegalArgumentException if passed a
        // value less than 1. Note that the output does not advance to the next
        // line.

        if (n < 1) {
            throw new IllegalArgumentException();
        } else {
            // if n greater than 1...
            if (n % 2 == 0) {
                // if n is even...
                if (n == 2) {
                    // base case: n is 2
                    System.out.print("**");
                } else {
                    // recursive case:
                    System.out.print("<");
                    writeChars(n - 2);
                    System.out.print(">");
                }
            } else {
                // if n is odd...
                if (n == 1) {
                    // base case: n is 1
                    System.out.print("*");
                } else {
                    // recursive case:
                    System.out.print("<");
                    writeChars(n - 2);
                    System.out.print(">");
                }
            }
        }
    }

    public static int multiplyEvens(int n) {
        // Ex 12.8

        // Write a method multiplyEvens that returns the product of the first n
        // even integers. For example:

        // Call	          Output Reason
        // multiplyEvens(1); 2	 2 = 2
        // multiplyEvens(2); 8	 2 * 4 = 8
        // multiplyEvens(3); 48	 2 * 4 * 6 = 48
        // multiplyEvens(4); 384 2 * 4 * 6 * 8 = 384

        // You should throw an IllegalArgumentException if passed a value less
        // than or equal to 0.

        if (n <= 0) {
            throw new IllegalArgumentException();
        } else {
            if (n == 1) {
                return 2;
            } else {
                return (n + n) * multiplyEvens(n - 1);
            }
        }
    }

    public static double sumTo(int n) {
        // Ex. 12.9
        // Write a method sumTo that accepts an integer parameter n and returns
        // the sum of the first n reciprocals. In other words:

        // sumTo(n) returns: 1 + 1/2 + 1/3 + 1/4 + ... + 1/n

        // For example, the call of sumTo(2) should return 1.5. The method
        // should return 0.0 if passed the value 0 and should throw an
        // IllegalArgumentException if passed a value less than 0.

        if (n < 0) {
            throw new IllegalArgumentException();
        } else {
            if (n == 0) {
                return 0.0;
            } else if (n == 1) {
                return 1;
            } else {
                return (double) 1/n + sumTo(n - 1);
            }
        }
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
        // Ch. 12 Ex. 13

        if (string2.length() > string1.length()) {
            return -1;
        }

        return indexOf(string1, string2, 0);
    }

    private static int indexOf(String string1, String string2, int count) {
        String s1Sub = string1.substring(0, string2.length());

        if (string2.equals(s1Sub)) {
            return count;
        } else if (string1.length() == 1){
            return -1;
        } else {
            count++;
            if (count > string1.length()) {
                return -1;
            }
            return indexOf(string1.substring(1), string2, count);
        }
    }

    public static int evenDigits(int n) {
        // Ch. 12 Ex. 14

        // Write a method evenDigits that accepts an integer parameter n and that
        // returns the integer formed by removing the odd digits from n. The
        // following table shows several calls and their expected return values:

        // Call	                  Valued Returned
        // evenDigits(8342116);	  8426
        // evenDigits(4109);	    40
        // evenDigits(8);	         8
        // evenDigits(-34512);	   -42
        // evenDigits(-163505);	   -60
        // evenDigits(3052);	     2
        // evenDigits(7010496);	    46
        // evenDigits(35179);	     0
        // evenDigits(5307);	     0
        // evenDigits(7);	         0

        // If a negative number with even digits other than 0 is passed to the
        // method, the result should also be negative, as shown above when
        // -34512 is passed. Leading zeros in the result should be ignored and
        // if there are no even digits other than 0 in the number, the method
        // should return 0, as shown in the last three outputs.

        int index = 0;
        return evenDigits(n, index);
    }

    private static int evenDigits(int n, int index) {
        String nString = String.valueOf(n);

        if (index >= nString.length()) { // end of number, even numbers
            // base case 1/2.
            return n;
        }

        if (nString.charAt(index) == '-') { // digit is negative
            // recursive case 1/3.
            index++;
            return evenDigits(n, index);

        } else if (nString.charAt(index) % 2 == 0
                || nString.charAt(index) == 0) { // digit is even
            // recursive case 2/3.
            index++;
            return evenDigits(n, index);

        } else {
            // covert to StringBuilder to delete character, convert back to int
            StringBuilder nStringB = new StringBuilder(nString);
            nStringB.deleteCharAt(index);
            nString = nStringB.toString();

            if (nString.equals("")) { // end of number, no even numbers
                // base case 2/2.
                return 0;

            } else { // digit is odd
                // recursive case 3/3
                n = Integer.parseInt(nString);
                return evenDigits(n, index);
            }
        }
    }

    public static void waysToClimb(int stairs) {
        // Ch. 12 Ex. 18

        // In this problem, the scenario we are evaluating is the following:
        // You're standing at the base of a staircase and are heading to the
        // top. A small stride will move up one stair, and a large stride
        // advances two. You want to count the number of ways to climb the
        // entire staircase based on different combinations of large and small
        // strides. For example, a staircase of three steps can be climbed in
        // three different ways: three small strides, one small stride followed
        // by one large stride, or one large followed by one small.
        //
        // Write a recursive method waysToClimb that takes a non-negative
        // integer value representing a number of stairs and prints each unique
        // way to climb a staircase of that height, taking strides of one or two
        // stairs at a time. Your method should output each way to climb the
        // stairs on its own line, using a 1 to indicate a small stride of 1
        // stair, and a 2 to indicate a large stride of 2 stairs. For example,
        // the call of waysToClimb(3) should produce the following output:

        // [1, 1, 1]
        // [1, 2]
        // [2, 1]
        // The call of waysToClimb(4) should produce the following output:
        //
        // [1, 1, 1, 1]
        // [1, 1, 2]
        // [1, 2, 1]
        // [2, 1, 1]
        // [2, 2]
        // The order in which you output the possible ways to climb the stairs
        // is not important, so long as you list the right overall set of ways.
        // There are no ways to climb zero stairs, so your method should produce
        // no output if 0 is passed. Do not use any loops in solving this
        // problem.

    }
}