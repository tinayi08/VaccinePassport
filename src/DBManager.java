import java.util.ArrayList;
import java.util.Scanner;

public class DBManager {
    private  ArrayList<Person> data;
    Person person;

    public ArrayList<Person> getData() {
        return data;
    }

    public DBManager() {
        data = new ArrayList<>();

    }

    public static Person getPerson(Person person) {

        Person returnPerson = new Person(person.fName, person.lName, person.vaccine, person.dob);

        return returnPerson;
    }
    /*

    This method asks the user to enter a first name and a last name.
    The name will be added to a Person object and method will return a person.
     */
    public Person searchIndividual() {
        //Add searching for last name too
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the first name of the individual you are searching for:");
        String searchFName = scan.next();
        System.out.println("Please enter the last name of the individual you are searching for:");
        String searchLName = scan.next();
        Person searchPerson = new Person (searchFName, searchLName);

        return searchPerson;
    }


    /*

    This method takes in a Person object.
    It will add a person into the ArrayList of data.
     */
    public void addPersonEntry(Person person) {
        //does this person exist already? - do a check
        //if exists, are you changing profile or adding another person
        //updating profile should be different method
        data.add(person);
    }

}
