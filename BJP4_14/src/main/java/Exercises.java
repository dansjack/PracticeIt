import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercises {
    public static void main(String[] args) {


        /*
        BJP4 Exercise 14.1: splitStack

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(-10);
        stack.push(15);
        stack.push(0);
        stack.push(-5);
        stack.push(100);
        System.out.println(stack);
        splitStack(stack);
        System.out.println(stack);
        */


        /*
        BJP4 Exercise 14.2: stutter

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(14);
        stack.push(9);

        stutter(stack);
        System.out.println(stack);
        */

        /*
        BJP4 Exercise 14.3: copyStack

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(14);
        stack.push(9);
        System.out.println(copyStack(stack));
        System.out.println(stack);
        */


    }

    public static void splitStack(Stack<Integer> stack) {
        // BJP4 Exercise 14.1: splitStack

        // Write a method splitStack that takes a
        // stack of integers as a parameter and splits
        // it into negatives and non-negatives.
        //
        // The numbers in the stack should be rearranged so
        // that all the negatives appear on the bottom
        // of the stack and all the non-negatives appear
        // on the top. In other words, if after this
        // method is called you were to pop numbers off
        // the stack, you would first get all the
        // non-negative numbers and then get all the
        // negative numbers.
        //
        // It does not matter what order
        // the numbers appear in as long as all the negatives
        // appear lower in the stack than all the non-negatives.
        //
        // You may use a single queue as auxiliary storage.
        Queue<Integer> queue = new LinkedList<>(stack);
        stack.clear();


        int i = 0;
        if (queue.isEmpty()) {
            i = 1;
        }

        while (i <= queue.size() + stack.size()) {

            int n = queue.remove();
            if (n < 0) {
                stack.push(n);
            } else {
                queue.add(n);
            }
            i++;
        }
        stack.addAll(queue);
    }


    public static void stutter(Stack<Integer> stack) {
        /*
                BJP4 Exercise 14.2: stutter

        Write a method stutter that takes a stack of integers as
        a parameter and replaces every value in the stack with
        two occurrences of that value. For example, suppose the
        stack stores these values:

        bottom [3, 7, 1, 14, 9] top
        Then the stack should store these values after the
        method terminates:

        bottom [3, 3, 7, 7, 1, 1, 14, 14, 9, 9] top
        Notice that you must preserve the original order. In
        the original list the 9 was at the top and would have
        been popped first. In the new stack the two 9s would be
        the first values popped from the stack. You may use a single
        queue as auxiliary storage to solve this problem.
        */

        Queue<Integer> queue = new LinkedList<>(stack);
        stack.clear();

        while (queue.size() > 0) {
            int pop = queue.remove();
            stack.add(pop);
            stack.add(pop);
        }
    }


    public static Stack<Integer> copyStack(Stack<Integer> stack) {

        /*
                BJP4 Exercise 14.3: copyStack

        Write a method copyStack that takes a stack of integers as
        a parameter and returns a copy of the original stack
        (i.e., a new stack with the same values as the original,
        stored in the same order as the original). Your method
        should create the new stack and fill it up with the same
        values that are stored in the original stack. It is not
        acceptable to return the same stack passed to the method;
        you must create, fill, and return a new stack.

        You will be removing values from the original stack to make
        the copy, but you have to be sure to put them back into the
        original stack in the same order before you are done. In
        other words, when your method is done executing, the
        original stack must be restored to its original state and
        you will return the new independent stack that is in the same
        state. You may use one queue as auxiliary storage.
        */

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stackCopy = new Stack<>();

        for (int i = stack.size(); i > 0; i--) { // stack --> stack copy
            stackCopy.push(stack.pop());
        }

        for (int i = stackCopy.size(); i > 0; i--) { // stack copy --> queue
            queue.add(stackCopy.pop());
        }

        for (int i = queue.size(); i > 0; i--) { // queue --> stack && stack copy
            int n = queue.remove();
            stack.push(n);
            stackCopy.push(n);
        }
        return stackCopy;
    }

    public static void collapse(Stack<Integer> stack) {
        //
    }



}
