import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplayPerson {

    Scanner scan = new Scanner(System.in);

    public int searchBirth(String search) {
        System.out.println("Please enter the birth " + search + ":");
        int birth = scan.nextInt();
        return birth;
    }

    public String searchName(String search) {

        System.out.println("Please enter the " + search + " name:");
        String name = scan.next();
        return name;
    }

    public int searchOption() {

        System.out.println("\nPlease select from the following options:");
        System.out.println("1. Enter First/Last Name only");
        System.out.println("2. Enter First/Last Name & Date of Birth");
        int option = new Utility().getValidIntInput(2);

        return option;
    }

    /**
     * This method takes in a person and will search for matching profile in database
     *
     * @param searchPerson
     * @return ArrayList of search results
     */
    public ArrayList<Person> returnSearchResults(Person searchPerson, ArrayList<Person> data) {
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
     * This method will search for an individual and display the results
     * @param person
     * @return ArrayList of results
     */
    public ArrayList<Person> navigateOptionTwoSearching(Person person, ArrayList<Person> data) {

        ArrayList<Person> searchResults = returnSearchResults(person, data);

        return searchResults;
    }

    /**
     * It will iterate through the ArrayList of data.
     * It will display all elements of the ArrayList
     * @param data
     * @param title
     */
    public void displayPerson(ArrayList<Person> data, String title) {
        System.out.println();
        System.out.println(title);
        if (data == null || data.isEmpty()) {
            System.out.println("There are no matching results.");
            return;
        }
        for (Person person : data) {
            System.out.println(person.toString());
        }
    }

    private Person searchPersonBDay(String firstName, String lastName) {
        int searchMonth = searchBirth("month");
        int searchDay = searchBirth("day");
        int searchYear = searchBirth("year");
        Person searchUser = new Person(firstName, lastName, searchMonth, searchDay, searchYear);
        return searchUser;
    }

    private Person searchPersonAllInfo() {
        String searchFName = searchName("first");
        String searchLName = searchName("last");
        int searchMonth = searchBirth("month");
        int searchDay = searchBirth("day");
        int searchYear = searchBirth("year");
        Person searchUser = new Person(searchFName, searchLName, searchMonth, searchDay, searchYear);
        return searchUser;
    }

    /**
     * This method takes in the user's basic information.
     *
     * @return Returns a new Person object
     */
    public Person obtainUserInfo(int option, String firstName, String lastName) {
        String searchFName;
        String searchLName;
        int searchMonth;
        int searchDay;
        int searchYear;
        Person searchUser;
        if (option == 3) { //asks just the birthday info
            searchUser = searchPersonBDay(firstName, lastName);
        } else if (option == 4) { //asks name & birthday info
            searchFName = searchName("first");
            searchLName = searchName("last");
            searchMonth = searchBirth("month");
            searchDay = searchBirth("day");
            searchYear = searchBirth("year");
            searchUser = new Person(searchFName, searchLName, searchMonth, searchDay, searchYear);
            //searchUser = searchPersonAllInfo();
        } else {
            int searchOption = searchOption();
            searchFName = searchName("first");
            searchLName = searchName("last");
            if (searchOption == 1) { //asks just name info
                searchUser = new Person(searchFName, searchLName);
            } else { //asks just bday info
                searchUser = searchPersonBDay(searchFName, searchLName);
            }
        }
        return searchUser;
    }

        /**
         *
         * This method sets up an initial bach of people to have in the ArrayList of data.
         * No vaccine information has been added yet.
         */
    public void setUpDataTesting() {

        //add people into the array to have some people in there
        //practice purposes only - will use text file or DB later on

        boolean saveItToDatabase = true;
        Person one = new Person("Tina", "Lee", 4, 3, 1993, saveItToDatabase);
        Person two = new Person("Angela", "Jones", 11, 4, 1994, saveItToDatabase);
        Person three = new Person("Alexa", "Smith", 9, 22, 1998, saveItToDatabase);
        Person four = new Person("Jay", "Kealy", 5, 22, 1965, saveItToDatabase);
        Person five = new Person("Amy", "Perry", 1, 22, 1965, saveItToDatabase);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990, saveItToDatabase);
        Person seven = new Person("Kameron","Clarke", 4, 2, 1991, saveItToDatabase);
        Person eight = new Person("Amy", "Lee", 1, 22, 1965, saveItToDatabase);
        Person nine = new Person("Amy", "Lee", 3, 22, 1994, saveItToDatabase);
        Person ten = new Person("amy", "lee", 3, 4, 1999, saveItToDatabase);

    }


}
