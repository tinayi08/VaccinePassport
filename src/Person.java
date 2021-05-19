public class Person {

    String fName;
    String lName;
    Vaccine vaccine;
    DOB dob;


    public  String toString() {
        if (vaccine == null) {
            return "First Name: " + fName +
                    ", Last Name: " + lName +
                    ", DOB: " + dob.month + "/" + dob.day + "/" + dob.year;

        } else if (vaccine.twoShotDate == null && vaccine.oneShotDate == null) {
            return "First Name: " + fName +
                    ", Last Name: " + lName +
                    ", DOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                    ", Vaccine Brand: " + vaccine.brand +
                    ", Required Shots: " + vaccine.requiredShots;

        } else if (vaccine.twoShotDate == null) {
            return "First Name: " + fName +
                    ", Last Name: " + lName +
                    ", DOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
                    ", Vaccine Brand: " + vaccine.brand +
                    ", Required Shots: " + vaccine.requiredShots +
                    ", Date of First Shot: " + vaccine.oneShotDate;
        }
        return "First Name: " + fName +
            ", Last Name: " + lName +
            ", DOB: " + this.dob.month + "/" + this.dob.day + "/" + this.dob.year +
            ", Vaccine Brand: " + vaccine.brand +
            ", Required Shots: " + vaccine.requiredShots +
            ", Date of First Shot: " + vaccine.oneShotDate +
            ", Date of Second Shot: " + vaccine.twoShotDate;

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
