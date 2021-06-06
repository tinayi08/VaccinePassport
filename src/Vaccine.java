import java.util.ArrayList;

public class Vaccine {
    //should be related to the vaccine itself
    //shot dates has to do with the person not the vaccine brand

    //vaccine card is per person
    //vaccine is per brand -- list of array database

    int brandID;
    String brand;
    int requiredShots;
    ArrayList<Integer> numDaysToBeEffective;

    public ArrayList<Integer> getNumDaysToBeEffective() {
        return numDaysToBeEffective;
    }

    public int getBrandID() {
        return brandID;
    }
//    String oneShotDate;
//    String twoShotDate;
//    String fullyVaxDate;

    public Vaccine() {
        requiredShots = 1;
    }

    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRequiredShots() {
        return requiredShots;
    }

    public void setRequiredShots(int requiredShots) {

        this.requiredShots = requiredShots;
    }

    public Vaccine(int brandID, String brand, int requiredShots, ArrayList<Integer> inputNumDaysBetweenShot) {
        this.brandID = brandID;
        this.brand = brand;
        this.requiredShots = requiredShots;
        this.numDaysToBeEffective = new ArrayList<>();
        if (inputNumDaysBetweenShot.size() != assignNumDaysBetweenShot(inputNumDaysBetweenShot)) {
            System.out.println("error");
        }
    }



    private int assignNumDaysBetweenShot(ArrayList<Integer> inputNumDaysBetweenShot) {
        for (int days : inputNumDaysBetweenShot) {
            numDaysToBeEffective.add(days);
        }
        return numDaysToBeEffective.size();
    }

    //    public String getFullyVaxDate() {
//        return fullyVaxDate;
//    }
//
//    public void setFullyVaxDate(String fullyVaxDate) {
//        this.fullyVaxDate = fullyVaxDate;
//    }

//    public String getOneShotDate() {
//        return oneShotDate;
//    }
//
//    public void setOneShotDate(String oneShotDate) {
//        this.oneShotDate = oneShotDate;
//    }
//
//    public String getTwoShotDate() {
//        return twoShotDate;
//    }
//
//    public void setTwoShotDate(String twoShotDate) {
//        this.twoShotDate = twoShotDate;
//    }


//    public Vaccine(String brand, int requiredShots, String oneShotDate, String twoShotDate, String fullyVaxDate) {
//        this.brand = brand;
//        this.requiredShots = requiredShots;
//        this.oneShotDate = oneShotDate;
//        this.twoShotDate = twoShotDate;
//        this.fullyVaxDate = fullyVaxDate;
//    }
//
//    public Vaccine(String brand, int requiredShots, String oneShotDate, String twoShotDate) {
//        this.brand = brand;
//        this.requiredShots = requiredShots;
//        this.oneShotDate = oneShotDate;
//        this.twoShotDate = twoShotDate;
//
//    }
}
