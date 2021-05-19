import java.util.ArrayList;

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

    /*

    This method takes in a Person object.
    It will add a person into the ArrayList of data.
     */
    public void addPersonEntry(Person person) {
        data.add(person);
        //System.out.println("Inside addPersonEntry()" + data);
    }

    /*

    This method takes in a Person object.
    It will delete the object from the database
     */
    public void deletePersonEntry(Person person) {
        data.remove(person);
    }

    public ArrayList<Person> returnSearchResults(Person searchPerson) {
        ArrayList<Person> searchResults = new ArrayList<Person>();
        //System.out.println(data.size() + " data size in returnSearchResults");
        for (Person p : data) {
            if (searchPerson.getfName().equalsIgnoreCase(p.getfName()) && searchPerson.getlName().equalsIgnoreCase(p.getlName())) {
                searchResults.add(p);
            }
        }
        return searchResults;
    }


    public void search(Person target) {

    }

    /*

    This method takes in a Person object and a String for the
    This method checks the database to see if the person exists already.

    Returns true if person does exist.
    Returns false if person does not exist.
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
                System.out.println("match");
                return true;
            }
        }
        System.out.println("no match");
        System.out.println(title);
        return false;

    }
    /*

    This method checks the database to see if the person exists already.

    Returns true if person does exist.
    Returns false if person does not exist.
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
                //need to capture this index so we know thats the object we want to update
                int object = data.indexOf(p);
                //System.out.println(object + " Found at index of");
                return true;
            }
        }
        return false;
    }

}
