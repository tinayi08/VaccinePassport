import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplay {

    DBManager dbManger;

    public TestDisplay() {
        dbManger = new DBManager();
    }

    /*

    This method will take in a ArrayList and a string for a title.
    It will iterate through the ArrayList of data.
    It will display all elements of the ArrayList

    Later will be displayed by a GUI
     */
    public void displayPerson(ArrayList<Person> data, String title) {
        System.out.println(title);
        if (data == null || data.isEmpty()) {
            System.out.println("There are no matching results.");
            return;
        }
        for (Person person : data) {
            System.out.println(person.toString());
        }
    }

    /*

    This method sets up an initial bach of people to have in the ArrayList of data.
    No vaccine information has been added yet.

    Need to later change this into SQL
     */
    public void setUpDataTesting(ArrayList<Person> data) {
        //add people into the array to have some people in there
        //practice purposes only - will use text file or DB later on

        Person one = new Person("Tina", "Lee", 4, 3, 1993);
        Person two = new Person("Angela", "Lee", 11, 4, 1994);
        Person three = new Person("Alexa", "lee", 9, 22, 1998);
        Person four = new Person("Jay", "Lee", 5, 22, 1965);
        Person five = new Person("Amy", "Lee", 1, 22, 1965);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990);
        Person seven = new Person("Kameron"," Clarke", 4, 2, 1991);
        Person eight = new Person("Amy", "Lee", 1, 22, 1965);

        //change methods
        //dbManger.addPersonEntry(one);
        data.add(two);
        data.add(three);
        data.add(four);
        data.add(five);
        data.add(six);
        data.add(seven);
        data.add(eight);

    }

    /*

    Initial start of program. User has an option to select what the program does
     */
    public int menu() {
        System.out.println("Please select from the following options:");
        System.out.println("1. Enter a new individual to the database");
        System.out.println("2. Search for an individual on the database");
        System.out.println("3. Update an existing individual on the database");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        return option;
    }
}
