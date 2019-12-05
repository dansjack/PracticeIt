import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SuppressWarnings("DuplicatedCode")
public class Exercises {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(2);
        s1.push(8);
        s1.push(3);
        s1.push(19);
        s1.push(7);
        s1.push(3);
        s1.push(2);
        s1.push(3);
        s1.push(2);
        s1.push(7);
        s1.push(12);
        s1.push(-8);
        s1.push(-8);
        s1.push(4);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);


        // System.out.println(s1);
        // compressDuplicates(s1);
        // System.out.println(s1);

        System.out.println(q);
        interleave(q);
        System.out.println(q);
    }

    public static void interleave(Queue<Integer> q) {
        if (q.size() % 2 != 0) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> aux = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i+=2) {
            aux.push(q.remove());
        }

        for (int i = 0; i < size; i+=2) {
            q.add(aux.pop());
        }

        for (int i = 0; i < size; i+=2) {
            q.add(q.remove());
        }

        for (int i = 0; i < size; i+=2) {
            aux.push(q.remove());
        }

        for (int i = 0; i < size; i+=2) {
            q.add(aux.pop());
            q.add(q.remove());
        }
    }

    public static int removeMin(Stack<Integer> s) {
        Queue<Integer> aux = new LinkedList<>();
        int size = s.size();
        int minimum = s.peek();
        for (int i = 0; i < size; i++) {
            int curr = s.pop();
            if (curr < minimum) {
                minimum = curr;
            }
            aux.add(curr);
        }

        for (int i = 0; i < size; i++) {
            int curr = aux.remove();
            if (curr != minimum) {
                aux.add(curr);
            }
        }

        size = aux.size();
        for (int i = 0; i < size; i++) {
            s.push(aux.remove());
        }

        for (int i = 0; i < size; i++) {
            aux.add(s.pop());
        }

        for (int i = 0; i < size; i++) {
            s.push(aux.remove());
        }
        return minimum;
    }

    public static void mirrorHalves(Queue<Integer> q) {
        if (q == null || q.size() % 2 != 0) {
            throw new IllegalArgumentException();
        } else if (q.isEmpty()) {
            return;
        }

        Stack<Integer> aux = new Stack<>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            int curr = q.remove();
            q.add(curr);
            aux.push(curr);
        }

        for (int i = 0; i < size / 2; i++) {
            q.add(aux.pop());
        }

        for (int i = 0; i < size / 2; i++) {
            int curr = q.remove();
            q.add(curr);
            aux.push(curr);
        }

        for (int i = 0; i < size / 2; i++) {
            q.add(aux.pop());
        }
    }

    public static void splitStack(Stack<Integer> stack) {
        Queue<Integer> aux = new LinkedList<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            aux.add(stack.pop());
        }

        for (int i = 0; i < size; i++) {
            int curr = aux.remove();
            if (curr < 0) {
                stack.push(curr);
            } else {
                aux.add(curr);
            }
        }
        int auxSize = aux.size();
        for (int i = 0; i < auxSize; i++) {
            stack.push(aux.remove());
        }
    }

    public static void stutter(Stack<Integer> stack) {
        Queue<Integer> aux = new LinkedList<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int curr = stack.pop();
            aux.add(curr);
            aux.add(curr);
        }

        for (int i = 0; i < size * 2; i++) {
            stack.push(aux.remove());
        }

        for (int i = 0; i < size * 2; i++) {
            aux.add(stack.pop());
        }

        for (int i = 0; i < size * 2; i++) {
            stack.push(aux.remove());
        }
    }

    public static void collapse(Stack<Integer> stack) {
        Queue<Integer> aux = new LinkedList<>();
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            aux.add(stack.pop());
        }
        for (int i = 0; i < size; i++) {
            stack.push(aux.remove());
        }
        if (size % 2 != 0) {
            size--;
        }
        for (int i = 0; i < size; i+=2) {
            aux.add(stack.pop() + stack.pop());
        }
        if (!stack.isEmpty()) {
            aux.add(stack.pop());
        }
        size = aux.size();
        for (int i = 0; i < size; i++) {
            stack.push(aux.remove());
        }
    }

    public static Boolean equals(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> aux = new Stack<>();
        int size = s1.size();
        if (s1.isEmpty()) {
            return true;
        } else if (size != s2.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            aux.push(s1.pop());
            aux.push(s2.pop());
        }

        boolean flag = true;
        for (int i = 0; i < size; i++) {
            int curr2 = aux.pop();
            int curr1 = aux.pop();
            if (curr1 != curr2) {
                flag = false;
            }
            s1.push(curr1);
            s2.push(curr2);
        }
        return flag;
    }

    public static void rearrange(Queue<Integer> q) {
        Stack<Integer> aux = new Stack<>();
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            if (curr % 2 == 0) {
                q.add(curr);
            } else {
                aux.push(curr);
            }
        }
        size = q.size();
        int auxSize = aux.size();
        for (int i = 0; i < auxSize; i++) {
            q.add(aux.pop());
        }
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
        for (int i = 0; i < auxSize; i++) {
            aux.push(q.remove());
        }
        for (int i = 0; i < auxSize; i++) {
            q.add(aux.pop());
        }

    }

    public static void reverseHalf(Queue<Integer> q) {
        Stack<Integer> aux = new Stack<>();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            if (i % 2 == 0) {
                q.add(curr);
            } else {
                aux.push(curr);
            }
        }
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                q.add(q.remove());
            } else {
                q.add(aux.pop());
            }
        }
    }

    public static Boolean isPalindrome(Queue<Integer> q) {
        Stack<Integer> aux = new Stack<>();
        if (q.size() == 0) {
            return true;
        }

        int size = q.size();

        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            q.add(curr);
            aux.push(curr);
        }

        boolean flag = true;

        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            if (curr != aux.pop()) {
                flag = false;
            }
            q.add(curr);
        }
        return flag;
    }

    public static void switchPairs(Stack<Integer> s) {
        Queue<Integer> aux = new LinkedList<>();
        int size = s.size();

        for (int i = 0; i < size; i++) {
            aux.add(s.pop());
        }

        for (int i = 0; i < size; i++) {
            s.push(aux.remove());
        }

        for (int i = 0; i < size; i+=2) {
            if (i == size - 1) {
                aux.add(s.pop());
                break;
            }
            int curr1 = s.pop();
            int curr2 = s.pop();
            aux.add(curr2);
            aux.add(curr1);
        }

        for (int i = 0; i < size; i++) {
            s.push(aux.remove());
        }
    }

    public static Boolean isConsecutive(Stack<Integer> s) {
        Queue<Integer> aux = new LinkedList<>();
        if (s.size() < 2) {
            return true;
        }
        int size = s.size();

        for (int i = 0; i < size; i++) {
            aux.add(s.pop());
        }

        for (int i = 0; i < size; i++) {
            s.push(aux.remove());
        }

        for (int i = 0; i < size; i++) {
            aux.add(s.pop());
        }

        boolean flag = true;

        for (int i = 0; i < size; i++) {
            int curr = aux.remove();
            if (i != size - 1) {
                int next = aux.peek();
                if (curr != next - 1) {
                    flag = false;
                }
            }
            s.push(curr);
        }
        return flag;
    }

    public static void reorder(Queue<Integer> q) {
        Stack<Integer> aux = new Stack<>();
        int size = q.size();

        for (int i = 0; i < size; i++) {
            int curr = q.remove();
            if (curr < 0) {
                aux.push(curr);
            } else {
                q.add(curr);
            }
        }

        size = q.size();
        int auxSize = aux.size();

        for (int i = 0; i < auxSize; i++) {
            q.add(aux.pop());
        }

        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
    }

    public static void shift(Stack<Integer> s, int n) {
        Queue<Integer> aux = new LinkedList<>();
        int size = s.size();

        for (int i = 0; i < size; i++) { // reverse in q
            aux.add(s.pop());
        }

        for (int i = 0; i < size; i++) { // reverse in s
            s.push(aux.remove());
        }

        for (int i = 0; i < size; i++) { // in q
            aux.add(s.pop());
        }

        for (int i = 0; i < n; i++) { // split
            s.push(aux.remove());
        }

        for (int i = 0; i < n; i++) {
            aux.add(s.pop());
        }

        for (int i = 0; i < size; i++) { // in s
            s.push(aux.remove());
        }
    }

    public static void expunge(Stack<Integer> s) {
        if (s.size() < 1) {
            return;
        }
        Queue<Integer> aux = new LinkedList<>();
        int size = s.size();
        int flag = s.peek();

        for (int i = 0; i < size; i++) {
            int curr = s.pop();
            if (curr >= flag) {
                flag = curr;
                aux.add(curr);
            }
        }
        q2s(aux, s);
        s2q(s, aux);
        q2s(aux, s);
    }

    public static void reverseFirstK(int k, Queue<Integer> q) {
        if (k < 1) {
            return;
        }

        if (q == null || q.size() < k) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> aux = new Stack<>();
        int size = q.size();

        for (int i = 0; i < k; i++) {
            aux.push(q.remove());
        }

        s2q(aux, q);

        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
    }

    private static void q2s(Queue<Integer> q, Stack<Integer> s) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            s.push(q.remove());
        }
    }

    private static void s2q(Stack<Integer> s, Queue<Integer> q) {
        int size = s.size();
        for (int i = 0; i < size; i++) {
            q.add(s.pop());
        }
    }

    public static Boolean isSorted(Stack<Integer> s) {
        if (s.size() < 2) {
            return true;
        }
        int size = s.size();
        Queue<Integer> aux = new LinkedList<>();
        boolean flag = true;


        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                aux.add(s.pop());
                break;
            }
            int curr = s.pop();
            int next = s.peek();
            if (curr > next) {
                flag = false;
            }
            aux.add(curr);
        }

        q2s(aux, s);
        s2q(s, aux);
        q2s(aux, s);
        return flag;
    }

    public static void compressDuplicates(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        Queue<Integer> aux = new LinkedList<>();
        int size = s.size();
        int count = 1;

        for (int i = 0; i < size; i++) {
            int curr = s.pop();
            if (s.isEmpty()) {
                aux.add(curr);
                aux.add(count);
                break;
            }
            int next = s.peek();
            if (curr == next) {
                count++;
            } else {
                aux.add(curr);
                aux.add(count);
                count = 1;
            }
        }

        size = aux.size();
        for (int i = 0; i < size; i++) {
            s.push(aux.remove());
        }

        for (int i = 0; i < size; i++) {
            aux.add(s.pop());
        }

        for (int i = 0; i < size; i++) {
            s.push(aux.remove());
        }
    }




}
