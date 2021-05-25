import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class DoctorController {


    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;

    public DoctorController() {
        dbPerson = new DBManager();

    }

    /*

    This method will update the details of a existing Person object in the Arraylist
     */
    public void navigateOptionThreeUpdate(Person person) {

        Person updated = addVaxInfo(person);
        fullyVaxDate(person);
        System.out.println(updated.toString());


    }

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

    /*


    Fully Vaccinated will be 1 month after last required injection
    This method will set the fully vaccinated date to the Person object

    This method takes in a person object.
     */
    public void fullyVaxDate(Person person) {
        String month;
        String dayYear;
        int fullyVaxMonth;
        String fullyVaxDate;
        if (person.vaccine.requiredShots == 1 && person.vaccine.oneShotDate != null) {

            SimpleDateFormat sdf = new SimpleDateFormat(("MM/dd/yyyy"));
            String date = person.vaccine.oneShotDate;
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.add(Calendar.DAY_OF_MONTH, 30);
            fullyVaxDate = sdf.format(cal.getTime());
            System.out.println(person.getfName() + " " + person.getlName() + " is fully vaccinated on " + fullyVaxDate + "\n");
            Vaccine vaxInfo = new Vaccine(person.getVaccine().brand, person.getVaccine().requiredShots, person.getVaccine().oneShotDate, null, fullyVaxDate);
            person.setVaccine(vaxInfo);
        } else if (person.vaccine.requiredShots == 2 && person.vaccine.twoShotDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(("MM/dd/yyyy"));
            String date = person.vaccine.twoShotDate;
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(sdf.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.add(Calendar.DAY_OF_MONTH, 30);
            fullyVaxDate = sdf.format(cal.getTime());
            System.out.println(person.getfName() + " " + person.getlName() + " is fully vaccinated on " + fullyVaxDate + "\n");
            Vaccine vaxInfo = new Vaccine(person.getVaccine().brand, person.getVaccine().requiredShots, person.getVaccine().oneShotDate, person.getVaccine().twoShotDate, fullyVaxDate);
            person.setVaccine(vaxInfo);
        } else
            System.out.println(person.getfName() + " " + person.getlName() + " will need a 2nd injection between 3 to 5 weeks in order to determine fully vaccinated date. \n");

    }

    /*

    This method will search for an individual and display the results
     */
    public ArrayList<Person> navigateOptionTwoSearching(Person person) {

        ArrayList<Person> searchResults = dbPerson.returnSearchResults(person);

        return searchResults;
    }

    /*

    This method will ask obtain information of a new user and add it to the ArrayList
     */
    public void navigateOptionOneAddNew(ArrayList<Person> data) {
        //System.out.println("before obtainUserInfo() " + data);
        Person person = obtainUserInfo();

        while (dbPerson.doesPersonExist(person)) {

            System.out.println("This entry already exists.");
            person = obtainUserInfo();

        }
        //System.out.println("after while loop" + data);
        dbPerson.addPersonEntry(person); //, data);
        System.out.println("The following entry has been added:");
        System.out.println(person.toString());
        //System.out.println(data + "after to String()");


    }
    /*

    This method navigates to option 4 which deletes a person from the database.

    Takes in the database ArrayList and a Person object to delete.
     */
    public void navigateOptionFourDelete(ArrayList<Person> data, Person person) {
        dbPerson.deletePersonEntry(person);
        System.out.println(person.getfName() + " " + person.getlName() + " has been deleted.");

    }


    public boolean isPersonVaccinated(Person person) {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    /*
    This method takes in the user's basic information.

    Returns a new Person object
     */
    public Person obtainUserInfo() {

        Scanner scan = new Scanner(System.in);
        System.out.println("What is your first name?");
        String fName = scan.next();
        //if first name is blank, return null
        System.out.println("What is your last name?");
        String lName = scan.next();
        System.out.println("What is your birthday month? Enter 01-12");
        int mM = scan.nextInt();
        System.out.println("What is your birth date?");
        int dD = scan.nextInt();
        System.out.println("What is your birth year?");
        int year = scan.nextInt();

        Person newPerson = new Person(fName, lName, mM, dD, year);
        return newPerson;

    }
    
}
