import java.util.Scanner;

public class TestDisplayVaccine {

    public void setupVaccineBrand() {
        //same as addperson
    }

    public int selectedVaxBrand(int numOfBrands) {
        System.out.println("What is the Vaccine brand?");
        int vaxBrand = new Utility().getValidIntInput(numOfBrands);
        return vaxBrand;
    }

    public String assignShotDate(String shotNumber) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the date of the " + shotNumber + " injection (Format: MM/DD/YYYY)");
        String oneShotDate = scan.next();
        return oneShotDate;
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
}
