import java.lang.reflect.Array;
import java.util.ArrayList;


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

    This method takes in a Person object.
    It will add a person into the ArrayList of data.
     */
    public void addPersonEntry(Person person, ArrayList<Person> data) {
        data.add(person);
        //System.out.println("Inside addPersonEntry()" + data);
    }



}
