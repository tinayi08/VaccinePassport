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
}
