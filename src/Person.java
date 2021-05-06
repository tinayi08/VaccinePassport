public class Person {

    String fName;
    String lName;
    Vaccine vaccine;
    DOB dob;

    @Override
    public String toString() {
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

    public Person(String fName, String lName, int month, int day, int year) {

        this.fName = fName;
        this.lName = lName;
        this.dob = new DOB(month, day, year);

    }


    public Person(String fName, String lName, Vaccine vaccine, DOB dob) {
        this.fName = fName;
        this.lName = lName;
        this.vaccine = vaccine;
        this.dob = dob;
    }



}
