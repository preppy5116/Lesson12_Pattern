public class FactoryThreadPool {
    public  ThreadPool getThreadPool(ThreadPoolType type, int minimalSize, int maximumSize) {
        return switch (type) {
            case FIXED_THREAD_POOL -> new FixedThreadPool(minimalSize);
            case SCALABLE_THREAD_POOL -> new ScalableThreadPool(minimalSize, maximumSize);
            default -> throw new IllegalArgumentException("Wrong threadPool type " + type);
        };
    }
}
