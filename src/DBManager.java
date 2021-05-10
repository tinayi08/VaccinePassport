import java.util.ArrayList;
import java.util.Scanner;

public class DBManager {
    ArrayList<Person> data;
    Person person;

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

    This method sets up an initial bach of people to have in the ArrayList of data.
    No vaccine information has been added yet.

    Need to later change this into SQL
     */
    public void setUpDataTesting() {
        //add people into the array to have some people in there
        //practice purposes only - will use text file or DB later on

        Person one = new Person("Tina", "Lee", 4, 3, 1993);
        Person two = new Person("Angela", "Lee", 11, 4, 1994);
        Person three = new Person("Alexa", "lee", 9, 22, 1998);
        Person four = new Person("Jay", "Lee", 5, 22, 1965);
        Person five = new Person("Amy", "Lee", 1, 22, 1965);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990);
        Person seven = new Person("Kameron"," Clarke", 4, 2, 1991);
        Person eight = new Person("Amy", "Lee", 1, 22, 1965);

        //change methods
        addPersonEntry(one);
        this.data.add(two);
        this.data.add(three);
        this.data.add(four);
        this.data.add(five);
        this.data.add(six);
        this.data.add(seven);
        this.data.add(eight);

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

    /*

    This method will iterate through the ArrayList of data.
    It will display all elements of the ArrayList
     */
    public void printDataArray() {
        System.out.println("Entries:");
        for (Person person : data) {
            System.out.println(person.toString());
        }
    }
}
