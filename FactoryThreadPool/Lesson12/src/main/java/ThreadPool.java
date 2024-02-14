public interface ThreadPool {
    void start();
    void execute(Runnable runnable);

    void interrupt();

    int getThreadCount();
    int getTaskCount();
}
