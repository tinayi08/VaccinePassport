public class Vaccine {

    String brand;
    int requiredShots;
    String oneShotDate;
    String twoShotDate;

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

    public Vaccine(String brand, int requiredShots, String oneShotDate, String twoShotDate) {
        this.brand = brand;
        this.requiredShots = requiredShots;
        this.oneShotDate = oneShotDate;
        this.twoShotDate = twoShotDate;
    }
}
