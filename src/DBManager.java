import java.util.ArrayList;
import java.util.Scanner;

public class DBManager {
    ArrayList<Person> data;
    Person person;

    public DBManager() {
        data = new ArrayList<>();

    }

    public static Person getPerson(Person person) {

        Person returnPerson = new Person(person.fName, person.lName, person.vaccine, person.dob);

        return returnPerson;
    }

    public void searchIndividual() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the first name of the individual you are searching for:");
        String search = scan.next();
        for (Person p : this.data) {
           if(search.equalsIgnoreCase(p.getfName())) {
               System.out.println(p);
           }
        }
    }

    public void setUpDataTesting() {
        //add people into the array to have some people in there
        //practice purposes only - will use text file or DB later on

        Person one = new Person("Tina", "Lee", 4, 3, 1993);
        Person two = new Person("Angie", "Lee", 11, 4, 1994);
        Person three = new Person("Alex", "Yi", 9, 22, 1998);
        Person four = new Person("Jason", "Yi", 5, 22, 1965);
        Person five = new Person("Akemi", "Yi", 1, 22, 1965);
        Person six = new Person("Jordan", "Clarke", 11, 27, 1990);
        Person seven = new Person("Kameron"," Clarke", 4, 2, 1991);

        this.data.add(one);
        this.data.add(two);
        this.data.add(three);
        this.data.add(four);
        this.data.add(five);
        this.data.add(six);
        this.data.add(seven);

    }

    public void addPersonEntry(Person person) {
        data.add(person);
    }

    public void printDataArray() {
        System.out.println("Entries:");
        for (Person person : data) {
            System.out.println(person.toString());
        }
    }
}
