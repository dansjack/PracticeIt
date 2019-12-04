import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercises {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.push(6);
        s1.push(7);
        s1.push(8);
        s1.push(9);
        s1.push(10);



        System.out.println(s1);
        // isConsecutive(s1);
        System.out.println(isConsecutive(s1));
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

        Boolean flag = true;
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

        Boolean flag = true;

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

        Boolean flag = true;

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


}
