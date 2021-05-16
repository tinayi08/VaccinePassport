import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DoctorController {


    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;
    Validator validator;

    public DoctorController() {
        dbPerson = new DBManager();
        validator = new Validator();
    }

    /*

    This method will update the details of a existing Person object in the Arraylist
     */
    public void navigateOptionThreeUpdate(Person person) {


        //System.out.println("What information would you like to update?");
        //here are the current details of there person
        //add new shot?
        // if first shot != null then add to 2nd shot
        System.out.println("---");
        updatePerson(person);
        System.out.println(person);
        //information in Person object should not be changed. Changed info should be

    }

    public Person updatePerson(Person person) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the Vaccine brand?");
        String vaxBrand = scan.next();
        System.out.println("How many shots are required?");
        int numShots = scan.nextInt();
        Vaccine vaxInfo = new Vaccine(vaxBrand, numShots, null, null);
        person.setVaccine(vaxInfo);
        System.out.println(person.getVaccine());
        System.out.println(person.toStringVax());
        return person;
    }

    /*

    This method will search for an individual and display the results
     */
    public ArrayList<Person> navigateOptionTwoSearching(Person person) {

        //returns the ArrayList of people with matching names
        ArrayList<Person> searchResults = dbPerson.returnSearchResults(person);
        //Displays ArrayList of people with matching names
        return searchResults;

    }

    /*

    This method will ask obtain information of a new user and add it to the ArrayList
     */
    public void navigateOptionOneAddNew(ArrayList<Person> data) {
        //System.out.println("before obtainUserInfo() " + data);
        Person person = obtainUserInfo();

        while (validator.doesPersonExist(person, data)) {

            System.out.println("This entry already exists.");
            person = obtainUserInfo();

        }
        //System.out.println("after while loop" + data);
        dbPerson.addPersonEntry(person); //, data);
        System.out.println("The following entry has been added:");
        System.out.println(person.toString());
        //System.out.println(data + "after to String()");


    }

    public boolean isPersonVaccinated(Person person) {
        Random rd = new Random();
        return rd.nextBoolean();
    }

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
