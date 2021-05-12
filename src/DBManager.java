import java.util.ArrayList;
import java.util.Scanner;

public class DBManager {
    private  ArrayList<Person> data;
    Person person;
    Validator validator;

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

    This method takes in a Person object.
    It will add a person into the ArrayList of data.
     */
    public void addPersonEntry(Person person) {
            data.add(person);
    }



}
