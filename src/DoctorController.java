import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DoctorController {


    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;

    public DoctorController() {
        dbPerson = new DBManager();

    }

    /**
     * This method will update the details of a existing Person object in the Arraylist
     *
     * @param person
     */
    public void navigateOptionThreeAddVaxInfo (Person person) {

        Person updated = addVaxInfo(person);

        fullyVaxDate(person);


        //System.out.println(updated.toStringVaxInfo());

    }

    /**
     * This method will add the vaccination information for a Person object
     * @param person
     * @return updated Person object with vaccination information added
     */
    public Person addVaxInfo(Person person) {
        Scanner scan = new Scanner(System.in);
        if (person.vaccine == null) {
            System.out.println("What is the Vaccine brand?");
            String vaxBrand = scan.next();
            System.out.println("How many shots are required?");
            int numShots = scan.nextInt();
            System.out.println("Please enter the date of the first injection (Format: MM/DD/YYYY)");
            String oneShotDate = scan.next();
            Vaccine vaxInfo = new Vaccine(vaxBrand, numShots, oneShotDate, null);
            person.setVaccine(vaxInfo);

            return person;

        } else if (person.vaccine.requiredShots == 1) {
            System.out.println("No additional shots necessary at this time");
            return person;
        }

        System.out.println("Please enter the date of the second injection (Format: MM/DD/YYYY)");
        String twoShotDate = scan.next();

        Vaccine vaxInfo = new Vaccine(person.getVaccine().brand, person.getVaccine().requiredShots, person.getVaccine().oneShotDate, twoShotDate);
        person.setVaccine(vaxInfo);
        return person;
    }

    /**
     * Fully Vaccinated will be 1 month after last required injection
     * This method will set the fully vaccinated date to the Person object
     *
     * @param person
     */
    public void fullyVaxDate(Person person) {

        String fullyVaxDate;
        if (person.vaccine.requiredShots == 1 && person.vaccine.oneShotDate != null) {
            fullyVaxDate = dbPerson.vax30Days(person.vaccine.oneShotDate);

            System.out.println(person.getfName() + " " + person.getlName() + " is fully vaccinated on " + fullyVaxDate + "\n");
            Vaccine vaxInfo = new Vaccine(person.getVaccine().brand, person.getVaccine().requiredShots, person.getVaccine().oneShotDate, null, fullyVaxDate);
            person.setVaccine(vaxInfo);
        } else if (person.vaccine.requiredShots == 2 && person.vaccine.twoShotDate != null) {
            fullyVaxDate = dbPerson.vax30Days(person.vaccine.twoShotDate);

            System.out.println(person.getfName() + " " + person.getlName() + " is fully vaccinated on " + fullyVaxDate + "\n");
            Vaccine vaxInfo = new Vaccine(person.getVaccine().brand, person.getVaccine().requiredShots, person.getVaccine().oneShotDate, person.getVaccine().twoShotDate, fullyVaxDate);
            person.setVaccine(vaxInfo);
        } else
            System.out.println(person.getfName() + " " + person.getlName() + " will need a 2nd injection between 3 to 5 weeks from " + person.getVaccine().oneShotDate +  " in order to determine fully vaccinated date. \n");

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

        Person person = obtainUserInfo(3, null, null);
        while (dbPerson.doesPersonExist(person)) {
            System.out.println("This entry already exists.");
            person = obtainUserInfo(3, null, null);
        }
        dbPerson.addPersonEntry(person); //, data);
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
        dbPerson.deletePersonEntry(person);
        System.out.println(person.getfName() + " " + person.getlName() + " has been deleted.");

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
        Scanner scan = new Scanner(System.in);
        String searchFName;
        String searchLName;
        int searchMonth;
        int searchDay;
        int searchYear;
        Person searchUser;
        if (option == 3) {
            //System.out.println("\nPlease enter the first name:");
            //searchFName = scan.next();
            //System.out.println("Please enter the last name:");
            //searchLName = scan.next();
            System.out.println("Please enter the birth month:");
            searchMonth = scan.nextInt();
            System.out.println("Please enter the birth day:");
            searchDay = scan.nextInt();
            System.out.println("Please enter the year:");
            searchYear = scan.nextInt();
            searchUser = new Person(firstName,lastName, searchMonth, searchDay, searchYear);
        } else {
            System.out.println("\nPlease select from the following options:");
            System.out.println("1. Enter First/Last Name only");
            System.out.println("2. Enter First/Last Name & Date of Birth");
            option = scan.nextInt();
            while (option == 0 || option > 2) {
                System.out.println("Please select a valid entry: 1 - 2");
                option = scan.nextInt();
            }

            System.out.println("\nPlease enter the first name:");
            searchFName = scan.next();
            System.out.println("Please enter the last name:");
            searchLName = scan.next();

            if (option == 1) {
                searchUser = new Person(searchFName, searchLName);
            } else {
                System.out.println("\nPlease enter the birth month:");
                searchMonth = scan.nextInt();
                System.out.println("Please enter the birth day:");
                searchDay = scan.nextInt();
                System.out.println("Please enter the year:");
                searchYear = scan.nextInt();
                searchUser = new Person(searchFName, searchLName, searchMonth, searchDay, searchYear);
            }
        }
        return searchUser;

    }
    
}
