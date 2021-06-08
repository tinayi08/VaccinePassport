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

    }

    public static Person getPerson(Person person) {

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
     * This method takes in a person and will search for matching profile in database
     *
     * @param searchPerson
     * @return ArrayList of search results
     */
    public ArrayList<Person> returnSearchResults(Person searchPerson) {
        ArrayList<Person> searchResults = new ArrayList<Person>();
        if (searchPerson.getDob() == null) {
            for (Person p : data) {
                if (searchPerson.getfName().equalsIgnoreCase(p.getfName()) && searchPerson.getlName().equalsIgnoreCase(p.getlName())) {
                    searchResults.add(p);
                }
            }
        }
        return searchResults;

    }

    /**
     * This method will calculate 30 calendar days from a given date.
     *
     * @param shotDate based on when the vaccine was given
     * @return a new date in String format
     */
    public String vax30Days (String shotDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(("MM/dd/yyyy"));
        String date = shotDate;
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 30);
        return sdf.format(cal.getTime());

    }

    /**
     * This method checks the database to see if the person exists already.
     * @param person
     * @param title
     * @return
     *     Returns true if person does exist.
     *     Returns false if person does not exist.
     */
    public boolean doesPersonExist(Person person, String title) {

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

        System.out.println(title);
        return false;

    }

    /**
     * This method checks the database to see if the person exists already.
     *
     * @param person
     * @return
     * Returns true if person does exist.
     * Returns false if person does not exist.
     */
    public boolean doesPersonExist(Person person) {

        String fName = person.getfName();
        String lName = person.getlName();
        int month = person.getDob().month;
        int day = person.getDob().day;
        int year = person.getDob().year;

        for (Person p : data) {

            if (fName.equalsIgnoreCase(p.getfName()) && lName.equalsIgnoreCase(p.getlName()) && month == p.getDob().month &&
                    day == p.getDob().day && year == p.getDob().year) {
                int object = data.indexOf(p);
                return true;
            }
        }
        return false;
    }

}
