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



}
