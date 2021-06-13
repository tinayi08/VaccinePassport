import java.util.ArrayList;

public class VaccineCard extends Vaccine {
    //vaccine card is per person
    //vaccine is per brand -- list of array database

    String oneShotDate;
    String twoShotDate;
    String fullyVaxDate;
    int numShotsTaken;

    public String getOneShotDate() {
        return oneShotDate;
    }

    public void setOneShotDate(String oneShotDate) {
        this.oneShotDate = oneShotDate;
    }

    public String getTwoShotDate() {
        return twoShotDate;
    }

    public void setTwoShotDate(String twoShotDate) {
        this.twoShotDate = twoShotDate;
    }

    public String getFullyVaxDate() {
        return fullyVaxDate;
    }

    public void setFullyVaxDate(String fullyVaxDate) {
        this.fullyVaxDate = fullyVaxDate;
    }

    public VaccineCard() {
        numShotsTaken = 0;

    }

    public int adminShot(String vaxDate) {

        if (oneShotDate == null) {
            oneShotDate = vaxDate;
            numShotsTaken = 1;
        } else if (requiredShots >= 2 && twoShotDate == null) {
            twoShotDate = vaxDate;
            numShotsTaken = 2;
        } else {

            System.out.println("error");
            return 0;
        }

        return numShotsTaken;



    }


    public VaccineCard(int brandID, String brand, int requiredShots, ArrayList<Integer> inputNumDaysBetweenShot, String oneShotDate, String twoShotDate, String fullyVaxDate) {
        super(brandID, brand, requiredShots, inputNumDaysBetweenShot);
        this.oneShotDate = oneShotDate;
        this.twoShotDate = twoShotDate;
        this.fullyVaxDate = fullyVaxDate;

    }

    public VaccineCard(int brandID, String brand, int requiredShots, ArrayList<Integer> inputNumDaysBetweenShot) {
        super(brandID, brand, requiredShots, inputNumDaysBetweenShot);
//        this.oneShotDate = oneShotDate;
//        this.twoShotDate = twoShotDate;
//        this.fullyVaxDate = fullyVaxDate;

    }
}
