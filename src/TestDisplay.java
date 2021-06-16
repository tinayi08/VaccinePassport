import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplay {

    DoctorController drController;
    TestDisplayPerson tDisplayP;
    TestDisplayVaccine tDisplayV;

    public TestDisplay() {
        tDisplayV = new TestDisplayVaccine();
        drController = new DoctorController();
        tDisplayP = new TestDisplayPerson();
    }




    /**
     * This method asks the user to enter a first name and a last name.
     * The name will be added to a Person object
     * @param title this refers to the statement if the Person does not exist
     * @param option is to signal which option it should go through, whether we want the option to create a new user or not
     * @return Person object
     */
    public Person searchIndividual(String title, int option) {
        //TODO -- move to displayPerson & need to simplify this method
        Person search;
        boolean b = false;

        do {

            Scanner scan = new Scanner(System.in);

            search = tDisplayP.obtainUserInfo(0, null, null);
            if (search.getDob() == null) { //if new search and no DOB
                ArrayList<Person> searchResults = tDisplayP.returnSearchResults(search, drController.dbPerson.getData());
                tDisplayP.displayPerson(searchResults,"Results:");
                if (searchResults.isEmpty()) {
                    search = tDisplayP.obtainUserInfo(4, null, null);
                } else {
                    search = tDisplayP.obtainUserInfo(3, search.getfName(), search.getlName());
                }
            }
                if (!drController.dbPerson.doesPersonExist(search, title, true)) {
                    if (option == 1) {
                        //if the person does not exist, will ask if want to create a new profile
                        String createNew = scan.next();
                        if (createNew.equalsIgnoreCase("yes")) {
                            drController.dbPerson.addPersonEntry(search);
                        } else {
                            b = false;
                            return null;
                        }
                    } else {
                        //if the person does not exist, will ask if re-enter
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
     * This method navigates to option 4 which deletes a person from the database.
     *
     * @param data
     * @param person
     */
    public void navigateOptionFourDelete(ArrayList<Person> data, Person person) {
        if (!drController.dbPerson.doesPersonExist(person, null, false)) {
            System.out.println("this entry does not exist");
        } else
            drController.dbPerson.deletePersonEntry(person);
        System.out.println(person.getfName() + " " + person.getlName() + " has been deleted.");
        //TODO -- If person does not exist -- need to state does not exist and go back to main menu
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

        tDisplayV.setUpVaxBrand();
        new TestDisplayPerson().setUpDataTesting();

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
                navigateOptionThreeAddVaxInfo(person);
            } else {
                return;
            }
        } else {
            System.out.println("\nWould you like to view " + person.getfName() + "'s vaccine information?");
            String option = scan.next();
            if (option.equalsIgnoreCase("yes")) {
                System.out.println("\n" + person.toStringVaxInfo());
                drController.dbPerson.person.vaccine.fullyVaxDate(person);
                //drController.fullyVaxDate(person);
            }
        }
        drController.personVaccinated(person);
    }

    private void assignBrandInfo(Person person) {
        int numOfBrands = drController.collection.listAvailableVax();
        int vaxBrand = tDisplayV.selectedVaxBrand(numOfBrands);
        drController.assignVaxBrandInfo(person, vaxBrand);
    }

    private void fullyVaccinated(Person person) {
        //TODO
        //not necessarily for the doctors use -- probably used more for the vendor to determine if patron is allowed in

        System.out.println(person.getfName() + " is fully vaccinated and has waiting the allotted time for" +
                "the vaccine to take into effect");
    }

    /**
     * This method will update the details of a existing Person object in the Arraylist
     *
     * @param person
     */
    public void navigateOptionThreeAddVaxInfo(Person person) {
        //0 == no vax status, 1 == allShotsGiven(has waiting time), 2 == needs to get shot, 3 == fullyVax
        //TODO -- need to update 3

        switch(person.getVaxStatus()) {
            case 0:
                assignBrandInfo(person);
                tDisplayV.assignShotDate(person);
                drController.dbPerson.person.vaccine.fullyVaxDate(person);
                break;
            case 1:
                System.out.println("No additional shots necessary at this time");
                //TODO Add a date where vaccine takes into effect (call from one of the vaccine classes)
                break;
            case 2:
                tDisplayV.assignShotDate(person);
                drController.dbPerson.person.vaccine.fullyVaxDate(person);
                break;
            case 3:
                fullyVaccinated(person);
                break;
            default:
                System.out.println("invalid vaccine status");
                break;

        }

    }

    /**
     *
     * This method will ask obtain information of a new user and add it to the ArrayList
     * @param data
     */
    public Person navigateOptionOneAddNew(ArrayList<Person> data) {

        Person person = tDisplayP.obtainUserInfo(4, null, null);
        while (drController.dbPerson.doesPersonExist(person, null, false)) {
            System.out.println("This entry already exists."); //nice to know but not necessary -- maybe display existing info and move forward to adding vax info
            person = tDisplayP.obtainUserInfo(4, null, null);
        }
        drController.dbPerson.addPersonEntry(person);
        System.out.println("The following entry has been added:");
        System.out.println(person.toString());

        return person;
    }


    /**
     * This method navigates through the program
     *
     * @param navigate
     */
    public void navigateMainMenu(int navigate)  {

        if (navigate == 1) {
            Person newlyAdded = navigateOptionOneAddNew(drController.dbPerson.getData());
            navigateOption2Part2(newlyAdded);
        } else if (navigate == 2) {
            tDisplayP.displayPerson(drController.dbPerson.getData(), "Entries:");

            Person p = searchIndividual("This entry does not exist, would you like to create a new profile?", 1);
            if (p != null) {
                navigateOption2Part2(p);
            } else
                return;
        } else if (navigate == 3) {
            tDisplayP.displayPerson(drController.dbPerson.getData(), "Entries:");

            Person p = searchIndividual("This entry does not exist, would you like to create a new profile?", 1);
            if (p != null) {
                navigateOptionThreeAddVaxInfo(p);
            } else
                return;
        } else if (navigate == 4) {
            tDisplayP.displayPerson(drController.dbPerson.getData(), "Entries:");
            Person p = searchIndividual("This entry does not exist, would you like to re-enter your search?", 0);
            if (p != null) {
                navigateOptionFourDelete(drController.dbPerson.getData(), p);
            } else
                return;

        } else if (navigate == 5) {
            tDisplayP.displayPerson(drController.dbPerson.getData(), "Entries:");
            //Person p = searchForVaxStatus();
            Person p = searchIndividual("This entry does not exist, would you like to re-enter your search?", 0);
            if (p != null) {
                drController.dbPerson.person.vaccine.fullyVaxDate(p);
                //drController.fullyVaxDate(p);

                //System.out.println(p.toStringVaxInfo());
                //System.out.println(p);
            } else
                return;

        }

    }

}
