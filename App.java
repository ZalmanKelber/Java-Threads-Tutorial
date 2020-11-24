class Printer {
    public void simulatePrint(int pages, String docName) {
        for (int i = 0; i < pages; i++) {
            try {
                Thread.sleep(1);
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
        printer.simulatePrint(10, "TaoTeChing.pdf");
    }
}

public class App {

    //main thread
    public static void main(String[] args) {
        System.out.println("--Application Started--");

        //one reference to printer object
        Printer printer = new Printer();

        //thread stores single access to printer object
        MyThread myThread = new MyThread(printer);
        myThread.start();

        System.out.println("--Application Finished--");
    }
}
