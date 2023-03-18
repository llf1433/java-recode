public class MyLinkList {

    public static class ListNode {
        public int value;
        public ListNode prev;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode head;//头指针
    public ListNode tail;//尾指针

    //打印链表
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //从从尾部向前打印
    public void displayEnd() {
        ListNode cur = this.tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.prev;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (this.head == null) {
            this.head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
    }

    //尾插
    public void addLast(int value) {
        ListNode newNode = new ListNode(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }


    //指定位置插入
    public void addIndex(int index, int value) {
        if (index < 0 || index > size()) {
            System.out.println("位置不合法！");
            return;
        }

        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == this.size()) {
            addLast(value);
            return;
        }
        ListNode newNode = new ListNode(value);
        ListNode cur = findIndexListNode(index);
        cur.prev.next = newNode;
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev = newNode;

    }

    private ListNode findIndexListNode(int index) {
        ListNode cur = head;
        while(index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }


    //长度
    public int size() {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    //清空链表
    public void clear() {
        ListNode cur = this.head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        tail = null;
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        //链表为空就不查
        if (this. head == null) {
            return false;
        }
        ListNode cur = this.head;
        while(cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        //1. key在中间 2. key在两端 3.只有一个结点时
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                if (cur == head) { // 头结点时
                    this.head = this.head.next;
                    if (head == null) { //只有一个结点时
                        this.tail = null;
                    } else {
                        this.head.prev = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) { //尾结点
                        cur.next.prev = cur.prev;
                    }
                }

                return;
            }
            cur = cur.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        //1. key在中间 2. key在两端 3.只有一个结点时
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                if (cur == head) { // 头结点时
                    this.head = this.head.next;
                    if (head == null) { //只有一个结点时
                        this.tail = null;
                    } else {
                        this.head.prev = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) { //尾结点
                        cur.next.prev = cur.prev;
                    }
                }
                //去除remove的return,则循环
            }
            cur = cur.next;
        }
    }

}



