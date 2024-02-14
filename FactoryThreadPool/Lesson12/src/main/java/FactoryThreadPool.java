public class FactoryThreadPool {
    public  ThreadPool getThreadPool(ThreadPoolType type, int minimalSize, int maximumSize)  {
        return switch (type) {
            case FIXED_THREAD_POOL -> new FixedThreadPool(minimalSize);
            case SCALABLE_THREAD_POOL -> new ScalableThreadPool(minimalSize, maximumSize);
        };
    }
    public  ThreadPool getNewScalableThreadPool ( int minimalSize, int maximumSize) {
        return  new ScalableThreadPool(minimalSize, maximumSize);
    }
    public  ThreadPool getNewFixedThreadPool ( int minimalSize) {
        return new FixedThreadPool(minimalSize);
    }

}
