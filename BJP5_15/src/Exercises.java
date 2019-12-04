public class Exercises {
    public static void main(String[] args) {
        ArrayIntList arrayIntList = new ArrayIntList();
        arrayIntList.add(5);
        arrayIntList.add(2);
        arrayIntList.add(2);
        arrayIntList.add(-5);
        arrayIntList.add(4);
        arrayIntList.add(3);
        arrayIntList.add(2);
        arrayIntList.add(4);
        arrayIntList.add(1);
        arrayIntList.add(1);
        arrayIntList.add(1);
        arrayIntList.add(0);
        arrayIntList.add(2);
        arrayIntList.add(17);







        System.out.println(arrayIntList);
        ArrayIntList list2 =  arrayIntList.fromCounts();
        System.out.println(list2);


    }
}
