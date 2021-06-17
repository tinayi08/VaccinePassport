import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Vaccine {
    //should be related to the vaccine itself
    //shot dates has to do with the person not the vaccine brand

    //vaccine card is per person
    //vaccine is per brand -- list of array database

    private int brandID;
    private String brand;
    private int requiredShots;
    private ArrayList<Integer> numDaysToBeEffective;

    public ArrayList<Integer> getNumDaysToBeEffective() {
        return numDaysToBeEffective;
    }

    public int getBrandID() {
        return brandID;
    }


    public Vaccine() {
        requiredShots = 0;
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

    /**
     * This method will calculate 30 calendar days from a given date.
     *
     * @param shotDate based on when the vaccine was given
     * @return a new date in String format
     */
    public String vax30Days (String shotDate) {
        //TODO move to a vax class
        SimpleDateFormat sdf = new SimpleDateFormat(("MM/dd/yyyy"));
        String date = shotDate;
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, 30);
        return sdf.format(cal.getTime());

    }

}
