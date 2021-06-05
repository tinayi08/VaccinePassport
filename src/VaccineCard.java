public class VaccineCard extends Vaccine {
    //vaccine card is per person
    //vaccine is per brand -- list of array database

    String oneShotDate;
    String twoShotDate;
    String fullyVaxDate;

    public VaccineCard() {



    }

    public VaccineCard(String brand, int requiredShots, String oneShotDate, String twoShotDate, String fullyVaxDate) {
        super(brand, requiredShots, oneShotDate, twoShotDate, fullyVaxDate);
    }

    public VaccineCard(String brand, int requiredShots, String oneShotDate, String twoShotDate) {
        super(brand, requiredShots, oneShotDate, twoShotDate);
    }
}
