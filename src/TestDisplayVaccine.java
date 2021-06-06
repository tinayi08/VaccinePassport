public class TestDisplayVaccine {

    public void setupVaccineBrand() {
        //same as addperson
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
