import usrdataconv.Output;
import java.util.Scanner;

public class ConsoleWorker {
    private static String close = "BYE";

    public static void processUserInput() {
        System.out.println("Input: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (input.equalsIgnoreCase(close)) {
            System.out.println("Goodbye!");
            System.exit(0);}
        else {
            Output findOutput = new Output(input);
            System.out.println("Output: ");
            System.out.println(findOutput.getStringResult());
        }
    }

    public static void greet() {
        System.out.println("Hello! \n" +
                "If you need to close the application print " + close);
    }
}
