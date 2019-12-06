public class Exercises {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.add(1);
        list.add(8);
        list.add(19);
        list.add(4);
        list.add(17);

        System.out.println("list before: " + list);
        list.stutter();
        System.out.println("list after: " + list);

    }
}
