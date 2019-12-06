public class Exercises {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.add(2);
        list.add(4);
        list.add(18);
        list.add(1);
        list.add(30);
        list.add(-4);

        System.out.println("list before: " + list);
        list.compress(2);
        System.out.println("list after: " + list);

    }
}
