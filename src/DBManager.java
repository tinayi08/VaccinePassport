import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DBManager {
    private static ArrayList<Person> data;
    Person person;


    public ArrayList<Person> getData() {
        return data;
    }

    public DBManager() {
        if (data == null) {
            data = new ArrayList<Person>();
        }
        person = new Person();

    }

    private static Person getPerson(Person person) {

        return person;
    }


    /**
     * It will add a person into the ArrayList of data.
     * @param person
     */
    public void addPersonEntry(Person person) {
        data.add(person);
    }

    /**
     *
     * It will delete the object from the database
     * @param person
     */
    public void deletePersonEntry(Person person) {
        data.remove(person);
    }

    /**
     * This method checks the database to see if the person exists already.
     * @param person
     * @param title
     * @return
     *     Returns true if person does exist.
     *     Returns false if person does not exist.
     */
    public boolean doesPersonExist(Person person, String title, boolean needTitle) {

        String fName = person.getfName();
        String lName = person.getlName();
        int month = person.getDob().month;
        int day = person.getDob().day;
        int year = person.getDob().year;

        for (Person p : data) {

            if (fName.equalsIgnoreCase(p.getfName()) && lName.equalsIgnoreCase(p.getlName()) && month == p.getDob().month &&
                    day == p.getDob().day && year == p.getDob().year) {
                //need to capture this index so we know thats the object we want to update
                int object = data.indexOf(p);
                //System.out.println(object + " Found at index of");

                return true;
            }
        }
        if (true) {
            System.out.println(title);
        }

        return false;

    }

}
