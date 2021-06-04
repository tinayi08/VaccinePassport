import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

    public int getValidIntInput (int option) {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        int selection = 0;
        while (!isValid) {
            try {
                selection = scan.nextInt();
                while (selection == 0 || selection > (option+1)) {
                    System.out.println("Please select a valid entry: 1 - " + option);
                    selection = scan.nextInt();
                }
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid entry: 1 - " + option);
                scan.next();
            }
        }
        return selection;
    }
}
