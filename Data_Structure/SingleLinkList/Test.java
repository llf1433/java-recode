
public class Test {

    public static MyLinkList.ListNode mergeTwoLists(MyLinkList.ListNode head1,
                                                    MyLinkList.ListNode head2) {
        MyLinkList.ListNode newH = new MyLinkList.ListNode();
        MyLinkList.ListNode cur = newH;
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return newH.next;
    }

    public static void main2(String[] args) {
        MyLinkList list1 = new MyLinkList();
        list1.addLast(11);
        list1.addLast(18);
        list1.addLast(20);
        list1.addLast(30);
        MyLinkList list2 = new MyLinkList();
        list2.addLast(9);
        list2.addLast(16);
        list2.addLast(19);
        list2.addLast(21);
        list2.addLast(26);
        list2.addLast(45);
        MyLinkList.ListNode ret = mergeTwoLists(list1.head,list2.head);
        list1.display(ret);


    }

    public static void main(String[] args) {
        MyLinkList list = new MyLinkList();
        list.addFirst(100);
        list.addFirst(99);
        list.addFirst(98);
        list.addLast(999);
        list.addLast(999);
        list.addLast(999);
        list.addLast(999);
        //list.display();
        //list.addIndex(2,114);
        //list.delLast();
        //list.remove(1111);
        list.removeAllKey(999);
        System.out.println("长度：" + list.size());

        list.display();
        list.clear();
        list.display();
        //list.remove(98);
        System.out.println("长度：" + list.size());
    }

}