public class Person {

    String fName;
    String lName;
    DOB dob;
    VaccineCard vaccine;
    //TODO: create Enum to identify vaxStatus
    int vaxStatus; //0 == no vax status, 1 == shotsInProgress, 2 == allShotsGiven(has waiting time), 3 == fullyVax


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

//    public Person(String fName, String lName, DOB dob, VaccineCard vaccine) {
//        this.fName = fName;
//        this.lName = lName;
//        this.dob = dob;
//        this.vaccine = vaccine;
//    }

//    public Person(String fName, String lName, String brand, int requiredShots, String one, String two, DOB dob) {
//        this.fName = fName;
//        this.lName = lName;
//        this.vaccine = new VaccineCard(brand, requiredShots, one, two);
//        this.dob = dob;
//    }

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


        if (vaccine.brand == null) {
            vaxStatus = 0;
        } else if (vaccine.requiredShots == vaccine.numShotsTaken) {
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
        if (vaccine.requiredShots == 1 & vaccine.oneShotDate != null) {
            return "First Name: " + fName +
                    "\nLast Name: " + lName +
                    "\nDOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                    "\nVaccine Brand: " + vaccine.brand +
                    "\nRequired Shots: " + vaccine.requiredShots +
                    "\nDate of First Shot: " + vaccine.oneShotDate;
            //"\nFully Vaccinated Date: " + vaccine.fullyVaxDate;

        } else if (vaccine.twoShotDate == null) {
            return "First Name: " + fName +
                    "\nLast Name: " + lName +
                    "\nDOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                    "\nVaccine Brand: " + vaccine.brand +
                    "\nRequired Shots: " + vaccine.requiredShots +
                    "\nDate of First Shot: " + vaccine.oneShotDate;
        }
        return "First Name: " + fName +
                "\nLast Name: " + lName +
                "\nDOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                "\nVaccine Brand: " + vaccine.brand +
                "\nRequired Shots: " + vaccine.requiredShots +
                "\nDate of First Shot: " + vaccine.oneShotDate +
                "\nDate of Second Shot: " + vaccine.twoShotDate;
        //"\nFully Vaccinated Date: " + vaccine.fullyVaxDate;

    }

}
