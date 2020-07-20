package Thread3.sync;

public class App {

  private int count = 0;

  public synchronized void increment() {
    count++;
  }

  public static void main(String[] args) {
    App app = new App();
    app.doWork();
  }

  private void doWork() {

    Thread t1 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 10000; i++) {
          increment();
          if (i == 999) {
            System.out.println("Numero 999 : " + i);
          }
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      public void run() {
        for (int i = 0; i < 10000; i++) {
          increment();
        }
      }
    });
    t1.start();
    t2.start();

    try {
      t1.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      t2.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("Count is: " + count);
  }

}
