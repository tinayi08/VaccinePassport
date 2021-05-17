public class Person {

    String fName;
    String lName;
    Vaccine vaccine;
    DOB dob;


    public  String toStringVax() {
        if (vaccine == null) {
            return "First Name: " + fName +
                    ", Last Name: " + lName +
                    //", Vaccine Brand: " + vaccine.brand +
                    //", Required Shots: " + vaccine.requiredShots +
                    //", Date of First Shot: " + vaccine.oneShotDate +
                    //", Date of Second Shot: " + "N/A"; //+
                    ", DOB: " + dob.month + "/" + dob.day + "/" + dob.year;

        } else if (vaccine.twoShotDate == null && vaccine.oneShotDate == null) {
            return "First Name: " + fName +
                    ", Last Name: " + lName +
                    ", Vaccine Brand: " + vaccine.brand +
                    ", Required Shots: " + vaccine.requiredShots +
                    //", Date of First Shot: " + vaccine.oneShotDate +
                    //", Date of Second Shot: " + "N/A" +
                    ", DOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year;
        }
        return "First Name: " + fName +
                ", Last Name: " + lName +
                ", Vaccine Brand: " + vaccine.brand +
                ", Required Shots: " + vaccine.requiredShots +
                ", Date of First Shot: " + vaccine.oneShotDate +
                ", Date of Second Shot: " + vaccine.twoShotDate +
                ", DOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year;
    }

    public String toString() {
        if (dob == null) {
            return "First Name: " + fName +
                    ", Last Name: " + lName;

        }
        return "First Name: " + fName +
                ", Last Name: " + lName +
                //", vaccine=" + vaccine +
                ", DOB: " + dob.month + "/" + dob.day + "/" + dob.year;

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

    public void setVaccine(Vaccine vaccine) {
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


    public Person(String fName, String lName, String brand, int requiredshots, String one, String two, DOB dob) {
        this.fName = fName;
        this.lName = lName;
        this.vaccine = new Vaccine(brand, requiredshots, one, two);
        this.dob = dob;
    }



}
