import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplay {

    DoctorController drController;


    public TestDisplay() {

        drController = new DoctorController();
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

        Person one = new Person("Tina", "Lee", 4, 3, 1993);
        Person two = new Person("Angela", "Jones", 11, 4, 1994);
        Person three = new Person("Alexa", "Smith", 9, 22, 1998);
        Person four = new Person("Jay", "Kealy", 5, 22, 1965);
        Person five = new Person("Amy", "Perry", 1, 22, 1965);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990);
        Person seven = new Person("Kameron","Clarke", 4, 2, 1991);
        Person eight = new Person("Amy", "Lee", 1, 22, 1965);
        Person nine = new Person("Amy", "Lee", 3, 22, 1994);
        Person ten = new Person("amy", "lee", 3, 4, 1999);

        drController.dbPerson.addPersonEntry(one);
        drController.dbPerson.addPersonEntry(two);
        drController.dbPerson.addPersonEntry(three);
        drController.dbPerson.addPersonEntry(four);
        drController.dbPerson.addPersonEntry(five);
        drController.dbPerson.addPersonEntry(six);
        drController.dbPerson.addPersonEntry(seven);
        drController.dbPerson.addPersonEntry(eight);
        drController.dbPerson.addPersonEntry(nine);
        drController.dbPerson.addPersonEntry(ten);
    }

    /**
     * This method asks the user to enter a first name and a last name.
     * The name will be added to a Person object
     * @return Person object
      */

    public Person searchIndividual() {
        Person search;

        boolean b = false;
        do {
            Scanner scan = new Scanner(System.in);

            search = drController.obtainUserInfo();

            if (!drController.dbPerson.doesPersonExist(search, "This entry does not exist, would you like to " +
                    "create a new profile?")) {
                String createNew = scan.next();
                if (createNew.equalsIgnoreCase("yes")) {
                    drController.dbPerson.addPersonEntry(search);
                } else {
                    b = true;
                }
            } else {
                b = false;
            }

        } while (b);

        int object = 0;
        for (Person p : drController.dbPerson.getData()) {
            if (search.getfName().equalsIgnoreCase(p.getfName()) && search.getlName().equalsIgnoreCase(p.getlName()) &&
                    search.getDob().month == p.getDob().month && search.getDob().day == p.getDob().day && search.getDob().year == p.getDob().year) {
                object = drController.dbPerson.getData().indexOf(p);
            }
        }
        return drController.dbPerson.getData().get(object);
    }

    /**
     *  Initial start of program. User has an option to select what the program does
     * @return int for the user selected option
     */
    public int menu() {
        System.out.println("Please select from the following options:");
        System.out.println("1. Enter a new individual to the database");
        System.out.println("2. Search for an individual on the database");
        System.out.println("3. Add vaccination information");
        System.out.println("4. Delete an entry from the database");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        while (option == 0 || option > 4) {
            System.out.println("Please select a valid entry: 1 - 4");
            option = scan.nextInt();
        }
        return option;
    }

    /**
     * This method prompts the user if they would like to return to the main menu
     *
     * @return true if user wants to continue, false if user wants to end program
     */
    public boolean returnToMainMenu() {
        System.out.println("\nWould you like to return to the main menu?");
        Scanner scan = new Scanner(System.in);
        String returnToMain = scan.next();
        if (returnToMain.equalsIgnoreCase("Yes")) {
            return true;
        }
        return false;
    }

    public void run() {

        setUpDataTesting();
        do {

            navigateMainMenu(menu());
        } while (returnToMainMenu());

    }

    /**
     *
     * This method will show Person's vax information or will allow the the user to enter vax information
     *
     * @param person
     */
    public void navigateOption2Part2(Person person) {
        Scanner scan = new Scanner(System.in);
        if (person.getVaccine() == null) {
            System.out.println(person.getfName() + " does not have their vaccination information entered, would you" +
                    " like to enter it now?");
            String addInfo = scan.next();
            if (addInfo.equalsIgnoreCase("yes")) {
                drController.navigateOptionThreeAddVaxInfo(person);
            }
        } else {
            System.out.println("Would you like to view " + person.getfName() + "'s vaccine information?");
            String option = scan.next();
            if (option.equalsIgnoreCase("yes")) {
                System.out.println("\n" + person.toStringVaxInfo());

            }

        }
    }
    /**
     * This method navigates through the program
     *
     * @param navigate
     */
    public void navigateMainMenu(int navigate) {

        if (navigate == 1) {
            drController.navigateOptionOneAddNew(drController.dbPerson.getData());
            displayPerson(drController.dbPerson.getData(), "Entries:");
        } else if (navigate == 2) {
            displayPerson(drController.dbPerson.getData(), "Entries:");
            //Do we need to return an arraylist here?
            //ArrayList<Person> searchResults = drController.navigateOptionTwoSearching(searchIndividual());
            navigateOption2Part2(searchIndividual());

            //displayPerson(searchResults, "Search Results");
        } else if (navigate == 3) {
            displayPerson(drController.dbPerson.getData(), "Entries:");
            drController.navigateOptionThreeAddVaxInfo(searchIndividual());
        } else if (navigate == 4) {
            displayPerson(drController.dbPerson.getData(), "Entries:");
            drController.navigateOptionFourDelete(drController.dbPerson.getData(), searchIndividual());
        }

        while (navigate == 0 || navigate > 4) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please select a valid entry: 1 - 4");
            navigate = scan.nextInt();
        }
        //NEED TO ADD LOOP SO THEY HAVE TO ENTER CORRECT ENTRY

    }



}
