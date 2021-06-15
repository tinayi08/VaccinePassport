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



    /**
     *
     * This method sets up an initial bach of people to have in the ArrayList of data.
     * No vaccine information has been added yet.
     */
    public void setUpDataTesting() {

        //add people into the array to have some people in there
        //practice purposes only - will use text file or DB later on

        boolean saveItToDatabase = true;
        Person one = new Person("Tina", "Lee", 4, 3, 1993, saveItToDatabase);
        Person two = new Person("Angela", "Jones", 11, 4, 1994, saveItToDatabase);
        Person three = new Person("Alexa", "Smith", 9, 22, 1998, saveItToDatabase);
        Person four = new Person("Jay", "Kealy", 5, 22, 1965, saveItToDatabase);
        Person five = new Person("Amy", "Perry", 1, 22, 1965, saveItToDatabase);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990, saveItToDatabase);
        Person seven = new Person("Kameron","Clarke", 4, 2, 1991, saveItToDatabase);
        Person eight = new Person("Amy", "Lee", 1, 22, 1965, saveItToDatabase);
        Person nine = new Person("Amy", "Lee", 3, 22, 1994, saveItToDatabase);
        Person ten = new Person("amy", "lee", 3, 4, 1999, saveItToDatabase);

    }




}
