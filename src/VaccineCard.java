import java.util.ArrayList;

public class VaccineCard extends Vaccine {
    //vaccine card is per person
    //vaccine is per brand -- list of array database

    private String oneShotDate;
    private String twoShotDate;
    private String fullyVaxDate;
    private int numShotsTaken;
    private Vaccine vaccine;


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
        vaccine = new Vaccine();
    }

    public int getNumShotsTaken() {
        return numShotsTaken;
    }

    public int adminShot(String vaxDate) {

        if (oneShotDate == null) {
            setOneShotDate(vaxDate);
            numShotsTaken = 1;
        } else if (getRequiredShots() >= 2 && twoShotDate == null) {
            setTwoShotDate(vaxDate);
            numShotsTaken = 2;
        } else {

            System.out.println("error");
            return 0;
        }

        return numShotsTaken;

    }

    /**
     * Fully Vaccinated will be 1 month after last required injection
     * This method will set the fully vaccinated date to the Person object
     *
     * @param person
     */
    public void fullyVaxDate(Person person) {

        //use VaxStatus variable to determine status/printout -- use Switch Case
        String fullyVaxDate;

        int numShotsTaken = person.getVaxStatus();

        switch(numShotsTaken) {
            case 0: //0 == no vax status
                System.out.println(person.getfName() + " has not started the vaccination process yet.");
                break;
            case 1: //1 == allShotsGiven(has waiting time)
                fullyVaxDate = vaccine.vax30Days(person.getVaccine().oneShotDate);
                //fullyVaxDate = vaccine.vax30Days(person.vaccine.oneShotDate);
                //fullyVaxDate = dbPerson.vax30Days(person.vaccine.oneShotDate);
                System.out.println(person.getfName() + " " + person.getlName() + " is fully vaccinated on " + fullyVaxDate + "\n");
                person.getVaccine().setFullyVaxDate(fullyVaxDate);
                //person.vaccine.setFullyVaxDate(fullyVaxDate);

                System.out.println(person.getfName() +  " has received all necessary shots" +
                        " and is fully vaccinated on " + fullyVaxDate + "\n");
                break;
            case 2: //2 == needs to get shot
                //TODO - this needs to use the days from setUpVaxBrand() in Collection of VaxBrands
                System.out.println(person.getfName() + " " + person.getlName()
                        + " will need a 2nd injection between 3 to 5 weeks from "
                        + person.getVaccine().oneShotDate +  " in order to determine fully vaccinated date. \n");

                break;
            case 3: //3 == fullyVax
                System.out.println(person.getfName() + " is fully vaccinated and has waiting the allotted time for" +
                        "the vaccine to take into effect");
                break;
        }

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
