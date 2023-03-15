public class Test {
    public static void main(String[] args) {
        MyLinkList list = new MyLinkList();
        list.addFirst(100);
        list.addFirst(99);
        list.addFirst(98);
        list.addLast(999);
        list.addLast(1);
        list.addIndex(2,114);
        list.display();
        list.delLast();
        list.display();
        System.out.println("长度：" + list.size());
    }
}