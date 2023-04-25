package test;

/**
 *  懒汉模式的 单例模式
 *  加锁/解锁是一件开销比较高的事情. 而懒汉模式的线程不安全只是发生在首次创建实例的时候.
 *  因此后续使用的时候, 不必再进行加锁了.
 *  外层的 if 就是判定下看当前是否已经把 instance 实例创建出来了.
 *  同时为了避免 "内存可见性" 导致读取的 instance 出现偏差, 于是补充上 volatile .
 */
public class SingletonLazy {
    private volatile static SingletonLazy instance = null;
    public static SingletonLazy getInstance() {
        //instance 未创建时
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                //instance 未初始化时
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    private SingletonLazy() {}

    public static void main(String[] args) {

    }
}
