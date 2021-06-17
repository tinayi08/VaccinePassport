public class Person {

    private String fName;
    private String lName;
    private DOB dob;
    private VaccineCard vaccine;
    //TODO: create Enum to identify vaxStatus
    private int vaxStatus; //0 == no vax status, 1 == allShotsGiven(has waiting time), 2 == needs to get shot, 3 == fullyVax


    public Person() {
        vaccine = new VaccineCard();

    }

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        //vaccine = new VaccineCard();
    }
    public Person(String fName, String lName, int month, int day, int year) {

        this.fName = fName;
        this.lName = lName;
        this.dob = new DOB(month, day, year);
        vaccine = new VaccineCard();
    }

    public Person(String fName, String lName, int month, int day, int year, boolean saveIt) {
        this.fName = fName;
        this.lName = lName;
        this.dob = new DOB(month, day, year);
        //vaccine = new VaccineCard();
        if (saveIt) {
            new DBManager().addPersonEntry(this);
        }
    }


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public VaccineCard getVaccine() {
        return vaccine;
    }

    public DOB getDob() {
        return dob;
    }

    public void setVaccine(VaccineCard vaccine) {
        this.vaccine = vaccine;
    }

    public int getVaxStatus() {
        return vaxStatus;
    }

    public void updateVaxStatus() {
        //TODO - update all 3 numbers need to add option 3
        //0 == no vax status, 1 == allShotsGiven(has waiting time), 2 == needs to get shot, 3 == fullyVax
        if (vaccine.getBrand() == null) {
            vaxStatus = 0;
        } else if (vaccine.getNumShotsTaken() == vaccine.getRequiredShots()) {
            vaxStatus = 1;
        } else
            vaxStatus = 2;

    }

    private int shotsInProgress() {
//        if (vaccine.requiredShots == 2 && vaccine.)
//            //if required shots == 2 but 2ndshot date == null
        return 0;
    }

    public  String toString() {
        return "First Name: " + fName +
                ", Last Name: " + lName +
                ", DOB: " + dob.month + "/" + dob.day + "/" + dob.year;
    }

    public  String toStringVaxInfo() {
        if (vaccine.getRequiredShots() == 1 & vaccine.getOneShotDate() != null) {
            return "First Name: " + fName +
                    "\nLast Name: " + lName +
                    "\nDOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                    "\nVaccine Brand: " + vaccine.getBrand() +
                    "\nRequired Shots: " + vaccine.getRequiredShots() +
                    "\nDate of First Shot: " + vaccine.getOneShotDate();
            //"\nFully Vaccinated Date: " + vaccine.fullyVaxDate;

        } else if (vaccine.getTwoShotDate() == null) {
            return "First Name: " + fName +
                    "\nLast Name: " + lName +
                    "\nDOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                    "\nVaccine Brand: " + vaccine.getBrand() +
                    "\nRequired Shots: " + vaccine.getRequiredShots() +
                    "\nDate of First Shot: " + vaccine.getOneShotDate();
        }
        return "First Name: " + fName +
                "\nLast Name: " + lName +
                "\nDOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                "\nVaccine Brand: " + vaccine.getBrand() +
                "\nRequired Shots: " + vaccine.getRequiredShots() +
                "\nDate of First Shot: " + vaccine.getOneShotDate() +
                "\nDate of Second Shot: " + vaccine.getTwoShotDate();
        //"\nFully Vaccinated Date: " + vaccine.fullyVaxDate;

    }



}
