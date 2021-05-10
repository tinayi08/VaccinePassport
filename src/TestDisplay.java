import java.util.ArrayList;

public class TestDisplay {

    public TestDisplay() {

    }

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
