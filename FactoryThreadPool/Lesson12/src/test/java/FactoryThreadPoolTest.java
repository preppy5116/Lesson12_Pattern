import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryThreadPoolTest {

    FactoryThreadPool factoryThreadPool = new FactoryThreadPool();
    ThreadPool fixedThreadPool;
    ThreadPool scalableThreadPool;
    ThreadPool unknownThreadPool;

    @Test
    void givenFixedThreadPool_whenExecuteTask_thenHasStaticCountOfThreads() throws  InterruptedException {
        unknownThreadPool = factoryThreadPool.getThreadPool(ThreadPoolType.FIXED_THREAD_POOL, 4, 0);

            for (int i = 0; i < 8; i++)
                unknownThreadPool.execute(new Work(i));

        unknownThreadPool.start();

            assertEquals(4, unknownThreadPool.getThreadCount());
            Thread.sleep(2000);
            assertEquals(4, unknownThreadPool.getThreadCount());

        unknownThreadPool.interrupt();
    }

    @Test
    void givenScalableThreadPool_whenExecuteTask_thenHasMaxThreads() throws InterruptedException {
        scalableThreadPool = factoryThreadPool.getThreadPool(ThreadPoolType.SCALABLE_THREAD_POOL, 2, 4);

        for (int i = 0; i < 8; i++)
            scalableThreadPool.execute(new Work(i));

        scalableThreadPool.start();
        assertEquals(4, scalableThreadPool.getThreadCount());
        Thread.sleep(3000);

        assertEquals(2, scalableThreadPool.getThreadCount());

        scalableThreadPool.interrupt();
    }

    @Test
    void givenFixedThreadPool_whenExecuteTask_thenHasStaticThreads() throws InterruptedException{
        fixedThreadPool = factoryThreadPool.getThreadPool(ThreadPoolType.FIXED_THREAD_POOL, 4, 0);


        for (int i = 0; i < 8; i++)
            fixedThreadPool.execute(new Work(i));

        fixedThreadPool.start();

        assertEquals(4, fixedThreadPool.getThreadCount());
        Thread.sleep(2000);
        assertEquals(4, fixedThreadPool.getThreadCount());

        fixedThreadPool.interrupt();
    }
}