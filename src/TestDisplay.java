import java.util.ArrayList;

public class TestDisplay {

    public TestDisplay() {

    }

    /*

    This method will take in a ArrayList and a string for a title.
    It will iterate through the ArrayList of data.
    It will display all elements of the ArrayList
     */
    public void displayPerson(ArrayList<Person> data, String title) {
        System.out.println(title);
        if (data == null) {
            System.out.println("There are no matching results.");
            return;
        }
        for (Person person : data) {
            System.out.println(person.toString());
        }
    }

}
