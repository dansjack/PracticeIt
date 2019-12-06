public class Exercises {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.add(18);
        list.add(7);
        list.add(4);
        list.add(24);
        list.add(11);

        System.out.println("list before: " + list);
        list.stretch(2);
        System.out.println("list after: " + list);

    }
}
