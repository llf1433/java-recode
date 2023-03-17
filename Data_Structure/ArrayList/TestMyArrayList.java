public class TestMyArrayList {
    public static void main1(String[] args) {
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
            myArrayList.remove(101);
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

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.display();
        //int ls = myArrayList.removeElement(3);
        int ls = myArrayList.removeDuplicates();
        myArrayList.display();
        System.out.println(ls);

    }
}
