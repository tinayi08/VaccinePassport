import java.lang.reflect.Array;
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

        System.out.println("What information would you like to update?");
        //information in Person object should not be changed. Changed info should be
        //vaccine information...

        //Use Setters to  update Person object?
    }

    public void updatePerson() {

    }

    /*

    This method will search for an individual and display the results
     */
    public ArrayList<Person> navigateOptionTwoSearching(Person person, ArrayList<Person> data) {

        //returns the ArrayList of people with matching names
        ArrayList<Person> searchResults = returnSearchResults(person, data);
        //Displays ArrayList of people with matching names
        return searchResults;

    }

    /*

    This method will ask obtain information of a new user and add it to the ArrayList
     */
    public void navigateOptionOneAddNew(ArrayList<Person> data) {
        //System.out.println("before obtainUserInfo() " + data);
        Person person = obtainUserInfo();

        while (validator.duplicateEntry(person, data)) {

            System.out.println("This entry already exists.");
            person = obtainUserInfo();

        }
        //System.out.println("after while loop" + data);
        dbPerson.addPersonEntry(person, data);
        System.out.println("The following entry has been added:");
        System.out.println(person.toString());
        //System.out.println(data + "after to String()");


    }


    public ArrayList<Person> returnSearchResults(Person searchPerson, ArrayList<Person> data) {
        ArrayList<Person> searchResults = new ArrayList<>();
        //System.out.println(data.size() + " data size in returnSearchResults");
        for (Person p : data) {
            if (searchPerson.getfName().equalsIgnoreCase(p.getfName()) && searchPerson.getlName().equalsIgnoreCase(p.getlName())) {
                searchResults.add(p);
            }
        }
        return searchResults;
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
