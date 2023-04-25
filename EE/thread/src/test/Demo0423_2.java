package test;

/**
 * 饿汉模式的 单例模式 的实现,类对象单个
 * 保证 Singleton 这个类只能创建一个
 */
class Singleton {
    /*
        创建实例,
        static 保证实例唯一,保证一定时间创建
     */

    private static Singleton instance = new Singleton();

    //外部只通过这个方法获取instance
    public static Singleton getInstance() {
        return instance;
    }

    //外部无法new 对象
    private Singleton() {}
}


public class Demo0423_2 {

}
