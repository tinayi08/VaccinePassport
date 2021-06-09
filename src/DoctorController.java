import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DoctorController {


    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;
    CollectionOfVaxBrands collection;
    TestDisplayVaccine vaxDisplay;

    public DoctorController() {
        dbPerson = new DBManager();
        collection = new CollectionOfVaxBrands();
    }

    /**
     * This method will update the details of a existing Person object in the Arraylist
     *
     * @param person
     */
    public void navigateOptionThreeAddVaxInfo (Person person) {

        addVaxInfo(person);
        fullyVaxDate(person);
    }

    /**
     * This method will display the available vaccines
     *
     * @return number of vaccine brands available
     */
    private int listAvailableVax() {

        int numOfVaxBrands = collection.sizeOfCollection();

        for (int i = 0; i < numOfVaxBrands; i++) {
            Vaccine theBrand = collection.getVaxBrandAtIndex(i);
            System.out.println("ID: " + theBrand.getBrandID() + " Brand: " + theBrand.getBrand());
        }
        return numOfVaxBrands;
    }

    /**
     * This method will add the vaccination information for a Person object
     * @param person
     * @return updated Person object with vaccination information added
     */
    public Person addVaxInfo(Person person) {
        //TODO - SCANNER part should be in testDisplay, pass through "vaxBrand"
        int numOfBrands = 0;
        if (person.vaccine == null) {
            numOfBrands = listAvailableVax();
            int vaxBrand = new TestDisplayVaccine().selectedVaxBrand(numOfBrands);
            Vaccine selectedVax = collection.getVaxBrandAtIndex(vaxBrand-1);

            String oneShotDate = new TestDisplayVaccine().assignShotDate("first");
            VaccineCard vaxInfo = new VaccineCard(selectedVax.brandID, selectedVax.getBrand(),
                    selectedVax.getRequiredShots(), selectedVax.getNumDaysToBeEffective(),
                    oneShotDate, null, null);
            person.setVaccine(vaxInfo);
            return person;

        } else if (person.vaccine.requiredShots == 1) {
            System.out.println("No additional shots necessary at this time");
            return person;
        }

        String twoShotDate = new TestDisplayVaccine().assignShotDate("second");

        person.vaccine.setTwoShotDate(twoShotDate);
        return person;
    }

    /**
     * Fully Vaccinated will be 1 month after last required injection
     * This method will set the fully vaccinated date to the Person object
     *
     * @param person
     */
    public void fullyVaxDate(Person person) {
    //TODO - MOVE TO VACCINECARD CLASS
        String fullyVaxDate;
        if (person.vaccine == null) {
            System.out.println(person.getfName() + " " + person.getlName() + " has not started the vaccination process yet.");
        } else if (person.vaccine.requiredShots == 1 && person.vaccine.oneShotDate != null) {
            fullyVaxDate = dbPerson.vax30Days(person.vaccine.oneShotDate);
            System.out.println(person.getfName() + " " + person.getlName() + " is fully vaccinated on " + fullyVaxDate + "\n");
            person.vaccine.setFullyVaxDate(fullyVaxDate);

        } else if (person.vaccine.requiredShots == 2 && person.vaccine.twoShotDate != null) {
            fullyVaxDate = dbPerson.vax30Days(person.vaccine.twoShotDate);
            System.out.println(person.getfName() + " " + person.getlName() + " is fully vaccinated on " + fullyVaxDate + "\n");
            person.vaccine.setFullyVaxDate(fullyVaxDate);
        } else
            System.out.println(person.getfName() + " " + person.getlName()
                    + " will need a 2nd injection between 3 to 5 weeks from "
                    + person.getVaccine().oneShotDate +  " in order to determine fully vaccinated date. \n");

    }

    /**
     * This method will search for an individual and display the results
     * @param person
     * @return ArrayList of results
     */
    public ArrayList<Person> navigateOptionTwoSearching(Person person) {

        ArrayList<Person> searchResults = dbPerson.returnSearchResults(person);

        return searchResults;
    }

    /**
     * This method will ask obtain information of a new user and add it to the ArrayList
     * @param data
     */

    public Person navigateOptionOneAddNew(ArrayList<Person> data) {

        Person person = obtainUserInfo(4, null, null);
        while (dbPerson.doesPersonExist(person)) {
            System.out.println("This entry already exists.");
            person = obtainUserInfo(3, null, null);
        }
        dbPerson.addPersonEntry(person);
        System.out.println("The following entry has been added:");
        System.out.println(person.toString());

        return person;
    }

    /**
     * This method navigates to option 4 which deletes a person from the database.
     *
     * @param data
     * @param person
     */

    public void navigateOptionFourDelete(ArrayList<Person> data, Person person) {
        if (!dbPerson.doesPersonExist(person)) {
            System.out.println("this entry does not exist");
        } else
        dbPerson.deletePersonEntry(person);
        System.out.println(person.getfName() + " " + person.getlName() + " has been deleted.");
        //TODO -- If person does not exist -- need to state does not exist and go back to main menu
    }


    public void personVaccinated(Person person) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (person.getVaccine().fullyVaxDate != null) {
            Date vaxDate = null;
            Date todayDate = null;
            try {
                vaxDate = sdf.parse(person.getVaccine().fullyVaxDate);
                todayDate = sdf.parse(sdf.format(new Date()));
                String str = sdf.format(new Date());
                if (vaxDate.compareTo(todayDate) < 0 || vaxDate.compareTo(todayDate) == 0) {
                    System.out.println("As of today's date, " + person.getfName() + " is fully vaccinated.");
                } else
                    System.out.println("As of today's date, " + person.getfName() + " is not fully vaccinated.");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method takes in the user's basic information.
     *
     * @return Returns a new Person object
     */
    public Person obtainUserInfo(int option, String firstName, String lastName) {
        //TODO - move to TestDisplayPerson?
        String searchFName;
        String searchLName;
        int searchMonth;
        int searchDay;
        int searchYear;
        Person searchUser;
        if (option == 3) {
            searchMonth = new TestDisplayPerson().searchBirth("month");
            searchDay = new TestDisplayPerson().searchBirth("day");
            searchYear = new TestDisplayPerson().searchBirth("year");
            searchUser = new Person(firstName,lastName, searchMonth, searchDay, searchYear);
        } else if (option == 4) {
            searchFName = new TestDisplayPerson().searchName("first");
            searchLName = new TestDisplayPerson().searchName("last");
            searchMonth = new TestDisplayPerson().searchBirth("month");
            searchDay = new TestDisplayPerson().searchBirth("day");
            searchYear = new TestDisplayPerson().searchBirth("year");
            searchUser = new Person(searchFName, searchLName, searchMonth, searchDay, searchYear);
        } else {
            int searchOption = new TestDisplayPerson().searchOption();
            searchFName = new TestDisplayPerson().searchName("first");
            searchLName = new TestDisplayPerson().searchName("last");
            if (searchOption == 1) {
                searchUser = new Person(searchFName, searchLName);
            } else {
                searchMonth = new TestDisplayPerson().searchBirth("month");
                searchDay = new TestDisplayPerson().searchBirth("day");
                searchYear = new TestDisplayPerson().searchBirth("year");
                searchUser = new Person(searchFName, searchLName, searchMonth, searchDay, searchYear);
            }
        }
        return searchUser;

    }
    
}
