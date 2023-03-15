import java.util.List;

public class MyLinkList {
    public static class ListNode {
        protected int value;//值
        private ListNode next;//指向下一个结点

        public ListNode() {

        }

        public ListNode(int value) { //带参构造
            this.value = value;
            this.next = null;
        }
    }

    ListNode head = null;//头指针

    //头插结点
    public void addFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //尾插
    public void addLast(int value) {
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode cur = head;//临时指向
        while (cur.next != null) {
            cur = cur.next;
        }
        //此时cur到达最后一个结点
        cur.next = new ListNode(value);
    }

    //指定插入
    public void addIndex (int index, int value) throws IndexWrongFulException {
        if (index < 0 || index > this.size()) {
            throw new IndexWrongFulException("插入位置不合法！");
        }
        if (index == 0) {
            this.addFirst(value);
            return;
        }
        if (index == this.size()) {
            this.addLast(value);
            return;
        }
        ListNode cur = findIndexPrevNode(index);
        ListNode newNode = new ListNode(value);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    //找到指定位置前一个
    private ListNode findIndexPrevNode(int index) {
        ListNode cur = head;
        while (index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //删除头节点
    public void delFist() {
        if (head != null) {
            this.head = head.next;
        }
        return;
    }

    //删除尾结点
    public void delLast() {
        if (head == null) {
            return;
        }
        if (this.size() == 1) {
            delFist();
            return;
        }
        ListNode cur = findLastPrevNode();
        cur.next = null;
    }

    private ListNode findLastPrevNode() {
        ListNode cur = head;
        //int frequency = this.size() - 1;
        while (cur.next.next != null) {
            cur = cur.next;
            //frequency--;
        }
        return cur;
    }

    //打印链表
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //链表长度
    public int size() {
        ListNode cur = head;
        int count = 0; // 计数器
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }



}
