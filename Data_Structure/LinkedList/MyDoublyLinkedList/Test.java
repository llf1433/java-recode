public class Test {
    public static void main(String[] args) {
        MyLinkList list = new MyLinkList();
        /*list.addFirst(9);
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);*/
        list.addFirst(1);
        list.addFirst(4);

        list.addLast(1);
        list.addLast(1);
        //list.addIndex(5,101);
        list.display();
        //list.remove(9);
        list.removeAllKey(1);
        //list.clear();
        list.display();
        //list.displayEnd();
    }
}
