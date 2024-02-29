package icu.fdss;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSteAndGet() {
        // 创建一个ThreadLocal对象
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        // 开启两个线程
        new Thread(() -> {
            threadLocal.set("萧炎");
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }, "蓝色").start();

        new Thread(() -> {
            threadLocal.set("药尘");
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }, "绿色").start();
    }

}
