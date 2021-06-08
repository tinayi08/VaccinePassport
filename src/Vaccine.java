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

}
