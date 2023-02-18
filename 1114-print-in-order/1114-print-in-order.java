class Foo {
    Semaphore semForSecond = new Semaphore(0);
    Semaphore semForThird = new Semaphore(0);
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semForSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semForSecond.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semForThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semForThird.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}