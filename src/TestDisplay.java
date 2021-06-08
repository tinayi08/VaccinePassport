import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public void setUpVaxBrand() {

        CollectionOfVaxBrands vaccineBrand = new CollectionOfVaxBrands();
        ArrayList<Integer> days = new ArrayList<>();
        days.add(25);
        vaccineBrand.addToBrandDB("Johnson & Johnson", 1, days);
        days.set(0, 14);
        days.add(14);
        vaccineBrand.addToBrandDB("Pfizer", 2, days);
        days.set(0,21);
        days.set(1,21);
        vaccineBrand.addToBrandDB("Moderna", 2, days);

    }

    /**
     * This method asks the user to enter a first name and a last name.
     * The name will be added to a Person object
     * @param title this refers to the statement if the Person does not exist
     * @param option is to signal which option it should go through, whether we want the option to create a new user or not
     * @return Person object
     */
    public Person searchIndividual(String title, int option) {
        Person search;

        boolean b = false;

        do {

            Scanner scan = new Scanner(System.in);

            search = drController.obtainUserInfo(0, null, null);
            if (search.getDob() == null) {
                ArrayList<Person> searchResults = drController.dbPerson.returnSearchResults(search);
                displayPerson(searchResults, "Results:");
                if (searchResults.isEmpty()) {
                    search = drController.obtainUserInfo(4, null, null);
                } else {
                    search = drController.obtainUserInfo(3, search.getfName(), search.getlName());
                }
            }
//            if (!drController.dbPerson.doesPersonExist(search, "This entry does not exist, would you like to " +
//                    "create a new profile?")) {
                if (!drController.dbPerson.doesPersonExist(search, title)) {
                    if (option == 1) {
                        String createNew = scan.next();
                        if (createNew.equalsIgnoreCase("yes")) {
                            drController.dbPerson.addPersonEntry(search);
                        } else {
                            b = false;
                            return null;
                        }
                    } else {
                        String reenter = scan.next();
                        if (!reenter.equalsIgnoreCase("yes")) {
                            b = false;
                            return null;
                        } else {
                            b = true;
                        }
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
        System.out.println("5. View vaccination status");

        return new Utility().getValidIntInput(5);

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

        setUpVaxBrand();
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
            System.out.println("\nWould you like to enter their vaccination information?");
            String addInfo = scan.next();
            if (addInfo.equalsIgnoreCase("yes")) {
                drController.navigateOptionThreeAddVaxInfo(person);
            } else {
                return;
            }
        } else {
            System.out.println("\nWould you like to view " + person.getfName() + "'s vaccine information?");
            String option = scan.next();
            if (option.equalsIgnoreCase("yes")) {
                System.out.println("\n" + person.toStringVaxInfo());
                drController.fullyVaxDate(person);

            }

        }
        drController.personVaccinated(person);
    }

    /**
     * This method navigates through the program
     *
     * @param navigate
     */
    public void navigateMainMenu(int navigate)  {

        if (navigate == 1) {
            Person newlyAdded = drController.navigateOptionOneAddNew(drController.dbPerson.getData());
            navigateOption2Part2(newlyAdded);
        } else if (navigate == 2) {
            displayPerson(drController.dbPerson.getData(), "Entries:");

            Person p = searchIndividual("This entry does not exist, would you like to create a new profile?", 1);
            if (p != null) {
                navigateOption2Part2(p);
            } else
                return;
        } else if (navigate == 3) {
            displayPerson(drController.dbPerson.getData(), "Entries:");

            Person p = searchIndividual("This entry does not exist, would you like to create a new profile?", 1);
            if (p != null) {
                drController.navigateOptionThreeAddVaxInfo(p);
            } else
                return;
        } else if (navigate == 4) {
            displayPerson(drController.dbPerson.getData(), "Entries:");
            drController.navigateOptionFourDelete(drController.dbPerson.getData(), searchIndividual("This entry does not exist, would you like to create a new profile?", 1));
        } else if (navigate == 5) {
            displayPerson(drController.dbPerson.getData(), "Entries:");
            //Person p = searchForVaxStatus();
            Person p = searchIndividual("This entry does not exist, would you like to re-enter your search?", 0);
            if (p != null) {
                drController.fullyVaxDate(p);
            } else
                return;

        }

        //I DONT THINK I NEED THE BELOW HERE -- IF NOTHING BREAKS - DELETE
        //navigate = validator(5);
//        while (navigate == 0 || navigate > 5) {
//            Scanner scan = new Scanner(System.in);
//            System.out.println("Please select a valid entry: 1 - 5");
//            navigate = scan.nextInt();
//        }
    }




}
