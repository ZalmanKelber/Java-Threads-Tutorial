class MyTask {
    public void executeTask() {
        for (int i = 0; i < 2; i++) {
            System.out.println("printing task no " + i + " on printer 2");
        }
    }
}

public class App {

    private static MyTask myTask = new MyTask();

    //main thread
    public static void main(String[] args) {
        //following executed by main thread in a sequence
        //Job1 -> Job2 -> Job3 -> Job4

        //Job1
        System.out.println("Application Started");

        //Job2
        myTask.executeTask();

        //Job3
        for (int i = 0; i < 4; i++) {
            System.out.println("printing task no " + i + " on printer 1");
        }

        //Job4
        System.out.println("Application Finished");
    }
}
