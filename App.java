class Printer {
    public void simulatePrint(int pages, String docName) {
        for (int i = 0; i < pages; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println("print " + docName + ": page " + i);
        }
    }
}

class MyThread extends Thread {

    private Printer printer;

    public MyThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        synchronized (printer) {
            printer.simulatePrint(10, "TaoTeChing.pdf");
        }
    }
}

class MyOtherThread extends Thread {

    private Printer printer;

    public MyOtherThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        synchronized (printer) {
            printer.simulatePrint(18, "Kabbalah.pdf");
        }
    }
}

public class App {

    //main thread
    public static void main(String[] args) {
        System.out.println("--Application Started--");

        //one reference to printer object
        Printer printer = new Printer();

        //threads store single access to printer object
        MyThread myThread = new MyThread(printer);
        MyOtherThread myOtherThread = new MyOtherThread(printer);
        myThread.start();
//        try {
//            myThread.join();
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
        myOtherThread.start();

        System.out.println("--Application Finished--");
    }
}
