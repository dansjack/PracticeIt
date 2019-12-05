public class Exercises {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.add(10);
        list.add(20);
        list.add(30);
        // list.add(40);
        // list.add(50);

        System.out.println(list);
        System.out.println(list.deleteBack());
        System.out.println(list.deleteBack());
        System.out.println(list.deleteBack());
        System.out.println(list);
    }
}
