public class Person {

    String fName;
    String lName;
    //Vaccine vaccine;
    DOB dob;
    VaccineCard vaccine;


    public Person () {
        vaccine = new VaccineCard();

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

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public DOB getDob() {
        return dob;
    }

    public void setVaccine(VaccineCard vaccine) {
        this.vaccine = vaccine;
    }

    public Person(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;

    }
    public Person(String fName, String lName, int month, int day, int year) {

        this.fName = fName;
        this.lName = lName;
        this.dob = new DOB(month, day, year);

    }


    public Person(String fName, String lName, String brand, int requiredShots, String one, String two, DOB dob) {
        this.fName = fName;
        this.lName = lName;
        this.vaccine = new VaccineCard(brand, requiredShots, one, two);
        this.dob = dob;
    }



}
