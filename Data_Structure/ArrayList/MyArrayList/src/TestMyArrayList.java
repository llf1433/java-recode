public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(99);
        myArrayList.add(100);
        myArrayList.add(101);
        myArrayList.display();
        System.out.println(myArrayList.contains(101));
        System.out.println("========================");

        try {
            myArrayList.set(1,999);
        } catch (EmptyException | PosWrongfulException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        myArrayList.display();
        try {
            myArrayList.remove(999);
        } catch (EmptyException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        myArrayList.display();
        System.out.println("========================");
        myArrayList.clear();
        myArrayList.display();
        System.out.println(myArrayList.isEmpty());
    }
}
