import java.util.ArrayList;
import java.util.Scanner;

public class Validator {

    public Validator() {

    }

    public boolean duplicateEntry(Person person, ArrayList<Person> data) {
        //if entry already exists return true

        return false;
    }

    public int startDataInputValidEntry(int navigate) {
        Scanner scan = new Scanner(System.in);

        while(navigate == 0 || navigate > 3) {
            System.out.println("Please select a valid entry.");
            navigate = scan.nextInt();
        }
        return navigate;


    }
}
