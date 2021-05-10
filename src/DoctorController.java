import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DoctorController {
    //  CONTROLLER


    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;
    TestDisplay testDisplay;

    public DoctorController() {
        dbPerson = new DBManager();
        testDisplay = new TestDisplay();
    }

    public void startVaccine() {
        boolean b = true;
        while (b) {
            Person person = obtainUserInfo();
            if (person == null) {
                b = false;
                //continue will skip bottom part of the while loop and then while b = false so loop stops
                continue;
            }
            b = false;
            dbPerson.addPersonEntry(person);
            testDisplay.setUpDataTesting(dbPerson.getData());
            testDisplay.displayPerson(dbPerson.getData(), "Entries:");

            //this method should probably go in a different class?
            Person searchingPerson = dbPerson.searchIndividual();

            ArrayList<Person> searchResults = returnSearchResults(searchingPerson, dbPerson.getData());
            testDisplay.displayPerson(searchResults, "Search Results:");
        }
    }

    public ArrayList<Person> returnSearchResults(Person searchPerson, ArrayList<Person> data) {
        ArrayList<Person> searchResults = new ArrayList<>();
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
        String fName = "T"; //scan.next();
        //if first name is blank, return null
        System.out.println("What is your last name?");
        String lName = "Y"; //scan.next();
        System.out.println("What is your birthday month? Enter 01-12");
        int mM = 5; //scan.nextInt();
        System.out.println("What is your birth date?");
        int dD = 3; //scan.nextInt();
        System.out.println("What is your birth year?");
        int year = 1990; //scan.nextInt();

        Person newPerson = new Person(fName, lName, mM, dD, year);
        return newPerson;

    }
    
}
