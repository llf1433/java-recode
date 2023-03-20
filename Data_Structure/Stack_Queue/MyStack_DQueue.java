/**
 * 两个队列实现一个栈
 */

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_DQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack_DQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(x);
        } else if (!q2.isEmpty()){
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }


    public int pop() {
        if (empty()) {
            return -1;
        }
        if (!q1.isEmpty()) {
            int size = q1.size();//
            for (int i = 0; i < size - 1; i++) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else {
            int size = q2.size();//
            for (int i = 0; i < size - 1; i++) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }


    public int top() {
        if (empty()) {
            return -1;
        }
        if (!q1.isEmpty()) {
            int ret = -1;
            int size = q1.size();//
            for (int i = 0; i < size; i++) {
                ret = q1.poll();
                q2.offer(ret);
            }
            return ret;
        } else {
            int size = q2.size();//
            int ret = -1;
            for (int i = 0; i < size; i++) {
                ret = q2.poll();
                q1.offer(ret);
            }

            return ret;
        }
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}