import java.util.ArrayList;
import java.util.Scanner;

public class TestDisplayVaccine {

    public Person assignShotDate(Person person) {

        //assigns shot date to person
        int numShotsTaken = person.vaccine.adminShot(enterShotDate());

        //TODO: handle adminShot error (1 shot required but has 2 shots) (Return code 0)
        person.updateVaxStatus();
        return person;
    }


    public int selectedVaxBrand(int numOfBrands) {
        System.out.println("What is the Vaccine brand?");
        int vaxBrand = new Utility().getValidIntInput(numOfBrands);
        return vaxBrand;
    }

    private String enterShotDate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the date of the injection (Format: MM/DD/YYYY)");
        String shotDate = scan.next();
        return shotDate;
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
