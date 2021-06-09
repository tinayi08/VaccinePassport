import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplayPerson {

    Scanner scan = new Scanner(System.in);

    public int searchBirth(String search) {

        System.out.println("Please enter the birth " + search + ":");
        int birth = scan.nextInt();
        return birth;
    }

    public String searchName(String search) {

        System.out.println("Please enter the " + search + " name:");
        String name = scan.next();
        return name;
    }

    public int searchOption() {

        System.out.println("\nPlease select from the following options:");
        System.out.println("1. Enter First/Last Name only");
        System.out.println("2. Enter First/Last Name & Date of Birth");
        int option = new Utility().getValidIntInput(2);

        return option;
    }

    /**
     * It will iterate through the ArrayList of data.
     * It will display all elements of the ArrayList
     * @param data
     * @param title
     */
    public void displayPerson(ArrayList<Person> data, String title) {
        System.out.println();
        System.out.println(title);
        if (data == null || data.isEmpty()) {
            System.out.println("There are no matching results.");
            return;
        }
        for (Person person : data) {
            System.out.println(person.toString());
        }
    }
}
