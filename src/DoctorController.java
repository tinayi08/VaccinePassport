import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DoctorController {


    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;
    TestDisplay testDisplay;
    Validator validator;

    public DoctorController() {
        dbPerson = new DBManager();
        testDisplay = new TestDisplay();
        validator = new Validator();
    }

    public void startDataInput() {
        int navigate = validator.startDataInputValidEntry(testDisplay.menu());
        if(navigate == 1) {
            Person person = obtainUserInfo();
            while(!validator.duplicateEntry(person, dbPerson.getData())) {
                dbPerson.addPersonEntry(person);
                System.out.println("The following entry has been added:");
                System.out.println(person.toString());
                return;
            }
            System.out.println("This entry already exists. Please enter a new entry or select 3 to update an existing entry.");
            //NEED TO ADD LOOP SO IT GOES BACK TO THE TOP
        } else if (navigate == 2) {
            //Person object of the person searching for
            Person searchingPerson = dbPerson.searchIndividual();
            //returns the ArrayList of people with matching names
            ArrayList<Person> searchResults = returnSearchResults(searchingPerson, dbPerson.getData());
            //Displays ArrayList of people with matching names
            testDisplay.displayPerson(searchResults, "Search Results:");
        } else if (navigate == 3) {
            System.out.println("Update individual");
        }
            //NEED TO ADD LOOP SO THEY HAVE TO ENTER CORRECT ENTRY




//            //displays the initial batch of data
//            testDisplay.setUpDataTesting(dbPerson.getData());
//            //displays the data from ArrayList
//            testDisplay.displayPerson(dbPerson.getData(), "Entries:");



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
