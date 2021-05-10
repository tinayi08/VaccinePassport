import java.util.Random;
import java.util.Scanner;

public class Doctor {

    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;
    VaccineInfoController vaxController;
    public Doctor() {
        dbPerson = new DBManager();

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
            dbPerson.setUpDataTesting();
            dbPerson.printDataArray();

            //this method should probably go in a different class?
            Person searchingPerson = dbPerson.searchIndividual();
            vaxController.returnSearchResults(searchingPerson, dbPerson.data);
//            if (isPersonVaccinated(dbPerson)) {
//                System.out.println(" is vaccinated");
//            } else
//                System.out.println(" is not vaccinated");
        }

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
