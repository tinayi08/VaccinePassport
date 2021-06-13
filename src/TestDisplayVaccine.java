import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplayVaccine {

    public Person assignShotDate(Person person) {
        //assigns shot date to person
        int numShotsTaken = person.vaccine.adminShot(enterShotDate());

        if (person.vaccine.requiredShots == numShotsTaken) {
            System.out.println("No additional shots necessary at this time");
            return person;
        }
        //TODO: handle adminShot error (1 shot required but has 2 shots) (Return code 0)

        return person;
    }


    public int selectedVaxBrand(int numOfBrands) {
        System.out.println("What is the Vaccine brand?");
        int vaxBrand = new Utility().getValidIntInput(numOfBrands);
        return vaxBrand;
    }

    public String enterShotDate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the date of the injection (Format: MM/DD/YYYY)");
        String shotDate = scan.next();
        return shotDate;
    }

    public String vaxBrand (int brand) {
        if (brand == 1) {
            return "Johnson & Johnson";
        } else if (brand == 2) {
            return "Pfizer";
        } else {
            return "Moderna";
        }
    }

    public int vaxBrandEqualsNumShots (int brand) {

        if (brand == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public void setUpVaxBrand() {

        CollectionOfVaxBrands vaccineBrand = new CollectionOfVaxBrands();
        ArrayList<Integer> days = new ArrayList<>();
        days.add(25);
        vaccineBrand.addToBrandDB("Johnson & Johnson", 1, days);
        days.set(0, 14);
        days.add(14);
        vaccineBrand.addToBrandDB("Pfizer", 2, days);
        days.set(0,21);
        days.set(1,21);
        vaccineBrand.addToBrandDB("Moderna", 2, days);

    }
}
