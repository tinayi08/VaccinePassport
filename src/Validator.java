import java.util.ArrayList;
import java.util.Scanner;

public class Validator {

    public Validator() {

    }
    /*

    This method checks the ArrayList to see if the newly created Person object
    is a duplicate
     */
    public boolean duplicateEntry(Person person, ArrayList<Person> data) {
        String fName = person.getfName();
        String lName = person.getlName();
        int month = person.getDob().month;
        int day = person.getDob().day;
        int year = person.getDob().year;

        for (Person p : data) {
            if(fName.equalsIgnoreCase(p.getfName()) && lName.equalsIgnoreCase(p.getlName()) && month == p.getDob().month &&
            day == p.getDob().day && year == p.getDob().year) {
                return true;
            }
        }

        return false;

    }


}
