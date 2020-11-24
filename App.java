public class App {

    //main thread
    public static void main(String[] args) {
        //following executed by main thread in a sequence
        //Job1 -> Job2 -> Job3

        //Job1
        System.out.println("Application Started");

        //Job2
        for (int i = 0; i < 4; i++) {
            System.out.println("executing task no " + i);
        }

        //Job3
        System.out.println("Application Finished");
    }
}
