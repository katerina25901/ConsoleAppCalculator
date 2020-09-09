public class ConsoleApplication {

    public static void main(String[] args) {
        boolean run = true;
        ConsoleWorker.greeting();
        while (run) {
            try {
                ConsoleWorker.userInputProcessing();
            } catch (Exception e) {
                run = false;
                System.out.println("Error: " + e.getMessage());
                System.out.println("Program will exit");
                System.exit(0);
            }
        }

    }

}
