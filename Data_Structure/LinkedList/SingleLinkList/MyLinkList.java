import java.util.List;

public class MyLinkList {
    public static class ListNode {
        protected int value;//值
        protected ListNode next;//指向下一个结点

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

    //找到最后一个的前一个结点
    private ListNode findLastPrevNode() {
        ListNode cur = head;
        //int frequency = this.size() - 1;
        while (cur.next.next != null) {
            cur = cur.next;
            //frequency--;
        }
        return cur;
    }


    //删除指定的值
    public void remove(int key) {
        if (head == null) {
            return;
        }
        if (head.value == key) {
            delFist();//头删
            return;
        }
        ListNode cur = findPrevKey(key);
        if (cur == null) {
            System.out.println("找不到这个关键字！");
            return;
        }
        cur.next = cur.next.next;
    }

    private ListNode findPrevKey(int key) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.value == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除所有等于key的结点
    public void removeAllKey(int key) {
        if (head == null) {
            return;
        }

        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            if (cur.value == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
            if(head.value == key) {
                head = head.next;
            }
        }
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

    public void display(ListNode head) {
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

    //清除链表
    public void clear() {
        this.head = null;//暴力解
    }



    //判断是否存在循环(会改变链表)
    public boolean chkPaindrome(MyLinkList.ListNode A) {
        if (A == null) {
            return false;
        }
        if (A.next == null) {
            return true;
        }
        MyLinkList.ListNode fast = A;
        MyLinkList.ListNode slow = A;

        //寻找中间结点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        MyLinkList.ListNode cur = slow.next;
        while (cur != null) {
            MyLinkList.ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        MyLinkList.ListNode head = A;
        while (head != slow) {
            if (head.value  != slow.value) {
                return false;
            }

            //偶数判断
            if (head.next == slow) {
                return true;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    //寻找循环链表的入口点 --无环 return null
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //相遇
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;//无环
    }

}
