import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplay {

    //DBManager dbManger;
    DoctorController drController;


    public TestDisplay() {
        //dbManger = new DBManager();
        drController = new DoctorController();
    }

    /*

    This method will take in a ArrayList and a string for a title.
    It will iterate through the ArrayList of data.
    It will display all elements of the ArrayList

    Later will be displayed by a GUI
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

    /*

    This method sets up an initial bach of people to have in the ArrayList of data.
    No vaccine information has been added yet.

    Need to later change this into SQL
     */
    public void setUpDataTesting() {
        //add people into the array to have some people in there
        //practice purposes only - will use text file or DB later on

        Person one = new Person("Tina", "Lee", 4, 3, 1993);
        Person two = new Person("Angela", "Jones", 11, 4, 1994);
        Person three = new Person("Alexa", "Smith", 9, 22, 1998);
        Person four = new Person("Jay", "Kealy", 5, 22, 1965);
        Person five = new Person("Amy", "Perry", 1, 22, 1965);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990);
        Person seven = new Person("Kameron"," Clarke", 4, 2, 1991);
        Person eight = new Person("Amy", "Lee", 1, 22, 1965);

        drController.dbPerson.addPersonEntry(one);
        drController.dbPerson.addPersonEntry(two);
        drController.dbPerson.addPersonEntry(three);
        drController.dbPerson.addPersonEntry(four);
        drController.dbPerson.addPersonEntry(five);
        drController.dbPerson.addPersonEntry(six);
        drController.dbPerson.addPersonEntry(seven);
        drController.dbPerson.addPersonEntry(eight);

        //return data;
    }

    /*

    This method asks the user to enter a first name and a last name.
    The name will be added to a Person object and method will return a person.
     */
    public Person searchIndividual() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the first name of the individual you are searching for:");
        String searchFName = scan.next();
        System.out.println("Please enter the last name of the individual you are searching for:");
        String searchLName = scan.next();
        Person searchPerson = new Person (searchFName, searchLName);
        //System.out.println(searchPerson + " Inside searchIndividual()");

        return searchPerson;
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
        while(option == 0 || option > 3) {
            System.out.println("Please select a valid entry: 1 - 3");
            option = scan.nextInt();
        }
        return option;
    }

    public boolean returnToMainMenu() {
        System.out.println("Would you like to return to the main menu?");
        Scanner scan = new Scanner(System.in);
        String returnToMain = scan.next();
        if(returnToMain.equalsIgnoreCase("Yes")) {
            return true;
        }
        return false;
    }

    public void run() {

        setUpDataTesting();//drController.dbPerson.getData());
        do {

            navigateMainMenu(menu());
        } while (returnToMainMenu());

    }

    public void navigateMainMenu(int navigate) {

        //System.out.println("after setUpDataTesting" + dbManger.getData());
        if (navigate == 1) {
            drController.navigateOptionOneAddNew(drController.dbPerson.getData());
            displayPerson(drController.dbPerson.getData(), "Entries:");
        } else if (navigate == 2) {
            displayPerson(drController.dbPerson.getData(), "Entries:");
            ArrayList<Person> searchResults = drController.navigateOptionTwoSearching(searchIndividual());
            //System.out.println("Listed at navigation main menu" + searchResults.size());
            displayPerson(searchResults, "Search Results");
        } else if (navigate == 3) {
            displayPerson(drController.dbPerson.getData(), "Entries:");
            //add a validator so it only pulls info on people on the list
            Person updatePerson = searchIndividual();
            drController.navigateOptionThreeUpdate(searchIndividual());
        }
        //NEED TO ADD LOOP SO THEY HAVE TO ENTER CORRECT ENTRY

    }

    public void duplicateEntry() {
        System.out.println("This entry already exists. Please select from the following options:");
        System.out.println("1. Enter a new individual to the database.");
    }
}
