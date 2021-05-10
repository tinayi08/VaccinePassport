import java.util.ArrayList;

public class TestDisplay {

    public TestDisplay() {

    }

    /*

    This method will take in a ArrayList and a string for a title.
    It will iterate through the ArrayList of data.
    It will display all elements of the ArrayList

    Later will be displayed by a GUI
     */
    public void displayPerson(ArrayList<Person> data, String title) {
        System.out.println(title);
        if (data == null || data.isEmpty()) {
            System.out.println("There are no matching results.");
            return;
        }
        for (Person person : data) {
            System.out.println(person.toString());
        }
    }

    /*

    This method sets up an initial bach of people to have in the ArrayList of data.
    No vaccine information has been added yet.

    Need to later change this into SQL
     */
    public void setUpDataTesting(ArrayList<Person> data) {
        //add people into the array to have some people in there
        //practice purposes only - will use text file or DB later on

        Person one = new Person("Tina", "Lee", 4, 3, 1993);
        Person two = new Person("Angela", "Lee", 11, 4, 1994);
        Person three = new Person("Alexa", "lee", 9, 22, 1998);
        Person four = new Person("Jay", "Lee", 5, 22, 1965);
        Person five = new Person("Amy", "Lee", 1, 22, 1965);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990);
        Person seven = new Person("Kameron"," Clarke", 4, 2, 1991);
        Person eight = new Person("Amy", "Lee", 1, 22, 1965);

        //change methods
        //addPersonEntry(one);
        data.add(two);
        data.add(three);
        data.add(four);
        data.add(five);
        data.add(six);
        data.add(seven);
        data.add(eight);

    }
}
