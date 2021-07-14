import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DoctorController {


    //vendor - compares the "ID" with the DB to pull information. Once it pulls one person,
    //ready to check the next person
    DBManager dbPerson;
    CollectionOfVaxBrands collection;

    public DoctorController() {
        dbPerson = new DBManager();
        collection = new CollectionOfVaxBrands();
    }


    /**
     * This method will add the vaccination brand for a Person object
     * @param person
     * @return updated Person object with vaccination brand information added
     */
    public Person assignVaxBrandInfo(Person person, int brandID) {
        //this method should just be assigning the brand info to the person
        //another method to assign shot date information --- should be in testDisplay
        Vaccine selectedVax = collection.getVaxBrandAtIndex(brandID - 1);
        VaccineCard assignedBrandInfo = new VaccineCard(selectedVax.getBrandID(), selectedVax.getBrand(),
                selectedVax.getRequiredShots(), selectedVax.getNumDaysToBeEffective());
        person.setVaccine(assignedBrandInfo);

        return person;
    }

    public void personVaccinated(Person person) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (person.getVaccine().getFullyVaxDate() != null) {
            Date vaxDate = null;
            Date todayDate = null;
            try {
                vaxDate = sdf.parse(person.getVaccine().getFullyVaxDate());
                todayDate = sdf.parse(sdf.format(new Date()));
                String str = sdf.format(new Date());
                if (vaxDate.compareTo(todayDate) < 0 || vaxDate.compareTo(todayDate) == 0) {
                    System.out.println("As of today's date, " + person.getfName() + " is fully vaccinated.");
                } else
                    System.out.println("As of today's date, " + person.getfName() + " is not fully vaccinated.");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    
}
