class MySuperClass {
    public void printMessage() {
        System.out.println("printing message from super class");
    }
}

class MyTask extends MySuperClass implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            printMessage();
            System.out.println("printing task no " + i + " on printer 2");
        }
    }
}

public class App {

    //main thread
    public static void main(String[] args) {
        //Two threads will run simultaneously so that Job2 is executed at the same
        //time as Job3 and Job4
        //Job1 -> Job3 -> Job4
        //Job1 -> Job2

        //Job1
        System.out.println("--Application Started--");

        Runnable r = new MyTask();
        Thread myTask = new Thread(r); //child thread or worker thread

        //Job2
        myTask.start(); //will interally start run method

        //Job3
        for (int i = 0; i < 10; i++) {
            System.out.println("printing task no " + i + " on printer 1");
        }

        //Job4
        System.out.println("--Application Finished--");
    }
}
