import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercises {
    public static void main(String[] args) {


        // BJP4 Exercise 14.1: splitStack
        /*
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

        // BJP4 Exercise 14.2: stutter
        /*
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(14);
        stack.push(9);

        stutter(stack);
        System.out.println(stack);
        */

        // BJP4 Exercise 14.3: copyStack
        /*
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(14);
        stack.push(9);
        System.out.println(copyStack(stack));
        System.out.println(stack);
        */

        // BJP4 Exercise 14.4: collapse
        /*
         Stack<Integer> stack = new Stack<>();
         stack.push(1);
         stack.push(2);
         stack.push(3);
         stack.push(4);
         stack.push(5);

         System.out.println(stack);
         collapse(stack);
         System.out.println(stack);
        */

        // BJP4 Exercise 14.5: equals
        /*
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(5);
        Stack<Integer> stack3 = new Stack<>();
        stack3.push(2);
        stack3.push(3);
        stack3.push(4);
        stack3.push(5);
        stack3.push(6);
        stack3.push(6);

        System.out.println(equals(stack1, stack2));
        */

        // BJP4 Exercise 14.6: rearrange
        /*
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(5);
        queue.add(4);
        queue.add(17);
        queue.add(6);
        queue.add(83);
        queue.add(1);
        queue.add(84);
        queue.add(16);
        queue.add(37);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(4);
        queue2.add(6);
        queue2.add(84);
        queue2.add(16);

        queue2.add(3);
        queue2.add(5);
        queue2.add(17);
        queue2.add(83);
        queue2.add(1);
        queue2.add(37);

        System.out.println("Queue: " + queue);
        System.out.println("Model Queue (After): " + queue2);
        System.out.println("\n");
        rearrange(queue);
        System.out.println("Queue: " + queue);
        */

        // BJP4 Exercise 14.7: reverseHalf
        /*
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(8);
        queue.add(7);
        queue.add(2);
        queue.add(9);
        queue.add(18);
        queue.add(12);
        queue.add(0);

        System.out.println("Queue (before): " + queue);
        reverseHalf(queue);
        System.out.println("Queue (after): " + queue);
        */

        // BJP4 Exercise 14.8: isPalindrome
        /*
        Queue<Integer> queuePal = new LinkedList<>();
        queuePal.add(3);
        queuePal.add(8);
        queuePal.add(17);
        queuePal.add(9);
        queuePal.add(17);
        queuePal.add(8);
        queuePal.add(3);

        System.out.println("Palindrome: " + queuePal);
        System.out.println(isPalindrome(queuePal));
        */

        // BJP4 Exercise 14.9: switchPairs
        /*
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(8);
        stack.add(17);
        stack.add(9);
        stack.add(99);
        stack.add(9);
        stack.add(17);
        stack.add(8);
        stack.add(3);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(14);
        stack.add(42);

        System.out.println("Stack (before): " + stack);
        switchPairs(stack);
        System.out.println("Stack (after): " + stack);
        */

        // BJP4 Exercise 14.10: isConsecutive
        /*
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(7);
        stack.add(8);
        stack.add(9);
        stack.add(10);
        stack.add(12);

        System.out.println("Stack (before): " + stack);
        System.out.println(isConsecutive(stack));
        System.out.println("Stack (after): " + stack);
        */

        // BJP4 Exercise 14.11: reorder






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
        /*
                BJP4 Exercise 14.4: collapse
        Write a method collapse that takes a stack of
        integers as a parameter and that collapses it
        by replacing each successive pair of integers
        with the sum of the pair. For example, suppose
        a stack stores these values:

        bottom [7, 2, 8, 9, 4, 13, 7, 1, 9, 10] top

        The first pair should be collapsed into 9 (7 + 2),
        the second pair should be collapsed into 17 (8 + 9),
        the third pair should be collapsed into 17 (4 + 13)
        and so on to yield:

        bottom [9, 17, 17, 8, 19] top
        If the stack stores an odd number of elements,
        the final element is not collapsed. For example,
        the stack:

        bottom [1, 2, 3, 4, 5] top
        Would collapse into:

        bottom [3, 7, 5] top
        With the 5 at the top of the stack unchanged.

        You may use one queue as auxiliary storage.
         */
        Queue<Integer> queue = new LinkedList<>();


        // store stack in queue
        for (int i = stack.size(); i > 0; i--) {
            queue.add(stack.pop());
        }

        // if queue has odd number of elements, push the top element to the
        // stack
        if (queue.size() % 2 != 0) {
            stack.push(queue.remove());
        }


        // add the pairs of (remaining, if odd) elements until queue is empty
        for (int i = queue.size() / 2; i > 0; i--) {
            stack.push(queue.remove() + queue.remove());
        }

        // push the queue elements back into the stack (order is now reversed)
        for (int i = queue.size(); i > 0; i--) {
            stack.push(queue.remove());
        }

        // add the stack elements back to the queue, then push back to stack
        // to get elements in the appropriate order
        for (int i = stack.size(); i > 0; i--) {
            queue.add(stack.pop());
        }

        for (int i = queue.size(); i > 0; i--) {
            stack.push(queue.remove());
        }

    }


    public static boolean equals(Stack<Integer> stack1,
                                 Stack<Integer> stack2) {
        /*
        returns true if the two stacks are equal and that returns false
        otherwise.

        To be considered equal, the two stacks would have to store
        the same sequence of integer values in the same order.

        Your method is to examine the two stacks but must return them to their
        original state before terminating.
         */
        boolean flag = true;

        if (stack1.size() != stack2.size()) {
            return flag = false;
        }

        Stack<Integer> aux = new Stack<>();

        while (!stack1.isEmpty()) {
            // fill aux with els from the stacks
            aux.push(stack1.pop());
            aux.push(stack2.pop());
        }

        while (!aux.isEmpty()) {
            int stack2El = aux.pop();
            int stack1El = aux.pop();

            // if stack els aren't equal, flag is false
            if (stack1El != stack2El) {
                flag = false;
            }
            // re-fill the stacks from aux
            stack2.push(stack2El);
            stack1.push(stack1El);
        }

        return flag;
    }


    public static void rearrange(Queue<Integer> queue) {
        /*
        Write a method rearrange that takes a queue of integers as a
        parameter and rearranges the order of the values so that all
        of the even values appear before the odd values and that
        otherwise preserves the original order of the list.
         */

        Stack<Integer> aux = new Stack<>();
        int oSize = queue.size();

        // Keep evens, add odds to aux stack
        for (int i = 0; i < oSize; i++) {
            int elPeek = queue.peek();
            if (elPeek % 2 == 0) {
                queue.add(queue.remove());
            } else {
                aux.add(queue.remove());
            }
        }

        // Add the odds back into the queue (backwards)
        int auxSize = aux.size();
        for (int i = 0; i < auxSize; i++) {
            queue.add(aux.pop());
        }

        // Re-add odds to the aux stack
        for (int i = 0; i < oSize; i++) {
            int elPeek = queue.peek();
            if (elPeek % 2 == 0) {
                queue.add(queue.remove());
            } else {
                aux.add(queue.remove());
            }
        }

        // Add the odds back into the queue (now in order)
        for (int i = 0; i < auxSize; i++) {
            queue.add(aux.pop());
        }
    }


    public static void reverseHalf(Queue<Integer> queue) {
        /*
        Write a method reverseHalf that reverses the order of half
        of the elements of a Queue of integers. Your method should
        reverse the order of all the elements in odd-numbered
        positions (position 1, 3, 5, etc.) assuming that the first
        value in the queue has position 0.
         */

        int oSize = queue.size();
        Stack<Integer> aux = new Stack<>();

        // store els at odd-num positions in aux
        for (int i = 0; i < oSize; i++) {
            int el = queue.remove();

            if (i % 2 != 0) {
                aux.add(el);
                queue.add(el);
            } else {
                queue.add(el);
            }
        }

        // re-add els from aux to queue in reverse order
        for (int i = 0; i < oSize; i++) {
            int el = queue.remove();

            if (i % 2 != 0) {
                queue.add(aux.pop());
            } else {
                queue.add(el);
            }
        }
    }


    public static boolean isPalindrome(Queue<Integer> queue) {
        /*
        returns true if the numbers in the queue represent a
        palindrome (and false otherwise). A sequence of numbers
        is considered a palindrome if it is the same in reverse order.

        You
        may not make any assumptions about how many elements
        are in the queue and your method must restore the queue
        so that it stores the same sequence of values after the
        call as it did before.
         */

        // if empty, return true
        if (queue.isEmpty()) {
            return true;
        }

        boolean flag = true;
        int oSize = queue.size();
        Stack<Integer> aux = new Stack<>();


        // keep queue in place, store queue els in aux
        for (int i = 0; i < oSize; i++) {
            int qEl = queue.remove();
            aux.add(qEl);
            queue.add(qEl);
        }

        // Go through the Queue and Aux, checking for equality
        while (!aux.isEmpty()) {
            int queueRem = queue.remove();

            if (aux.pop() != queueRem) {
                flag = false;
            }
            queue.add(queueRem);

        }

        return flag;
    }


    public static void switchPairs(Stack<Integer> stack) {
        /*
        switches successive pairs of numbers starting at
        the bottom of the stack.

        If there are an odd number of values in the stack,
        the value at the top of the stack is not moved.

        Do not make assumptions about how many elements
        are in the stack.
         */
        int oSize = stack.size();
        int top = 0;
        boolean flag = false;
        Queue<Integer> aux = new LinkedList<>();

        // add stack items to aux (now reversed)
        while (!stack.isEmpty()) {
            aux.add(stack.pop());
        }

        // re-add stack items from aux (still reversed)
        while (!aux.isEmpty()) {
            stack.add(aux.remove());
        }

        // re-add stack items to aux (now in order)
        while (!stack.isEmpty()) {
            aux.add(stack.pop());
        }

        int aSize = aux.size();

        // re-add stack items to stack (in order)
        for (int i = aSize/2; i >= 0; i--) {
            if (oSize % 2 != 0 && i == 0) { // stack has odd num of els
                stack.add(aux.remove());
            } else if (i > 0){ // stack has even num of els
                int auxRem = aux.remove();
                stack.add(aux.peek());
                stack.add(auxRem);
                aux.remove();
            }
        }
    }


    public static boolean isConsecutive(Stack<Integer> stack) {
        /*
        returns whether or not the stack contains a sequence
        of consecutive integers starting from the bottom of
        the stack (returning true if it does, returning false
        if it does not). Consecutive integers are integers
        that come one after the other, as in 5, 6, 7, 8, 9, etc.

        Notice that we look at the numbers starting at the
        bottom of the stack. The following sequence of values
        would be consecutive except for the fact that it appears
        in reverse order, so the method would return false:

        bottom [3, 2, 1] top

        Your method must restore the stack so that it stores
        the same sequence of values after the call as it did
        before.
         */

        Queue<Integer> aux = new LinkedList<>();
        boolean flag = true;

        if (stack.size() < 2) {
            return true;
        }

        // stack to aux (reversed)
        while (!stack.isEmpty()) {
            aux.add(stack.pop());
        }

        // aux to stack (still reversed)
        while (!aux.isEmpty()) {
            stack.add(aux.remove());
        }

        // stack to aux (in original order)
        while (!stack.isEmpty()) {
            aux.add(stack.pop());
        }

        // aux to stack (in original order)
        int oSize = aux.size();
        for (int i = oSize; i > 0; i--) {
            int curr = aux.remove();
            stack.add(curr);

            // flag if a pair of nums aren't consecutive
            if (i > 1 && curr + 1 != aux.peek()) {
                flag = false;
            }
        }

        return flag;
    }


}
