import java.util.ArrayList;

public class CollectionOfVaxBrands {

    //vaccine card is per person
    //vaccine is per brand -- list of array database

    private static ArrayList<Vaccine> vaccineBrandList;
    private static int vaccineID;

    public static ArrayList<Vaccine> getVaccineBrandList() {
        return vaccineBrandList;
    }

    public static ArrayList<Vaccine> getBrand() {
        return vaccineBrandList;
    }

    public CollectionOfVaxBrands() {
        if (vaccineBrandList == null) {
            vaccineBrandList = new ArrayList<Vaccine>();
            vaccineID = 1;
        }

    }

    public int sizeOfCollection() {
        return vaccineBrandList.size();

    }
    public void addToBrandDB(String brandName, int reqShots, ArrayList<Integer> daysBetweenShot) {

        Vaccine one = new Vaccine(vaccineID, brandName, reqShots, daysBetweenShot);
        vaccineID++;

        vaccineBrandList.add(one);

    }

    public Vaccine getVaxBrandAtIndex(int i) {
        Vaccine brand = null;
        if (i < vaccineBrandList.size() ) {
            return vaccineBrandList.get(i);
        }
        return brand;
    }

    /**
     * This method will display the available vaccines
     *
     * @return number of vaccine brands available
     */
    public int listAvailableVax() {

        int numOfVaxBrands = sizeOfCollection();

        for (int i = 0; i < numOfVaxBrands; i++) {
            Vaccine theBrand = getVaxBrandAtIndex(i);
            System.out.println("ID: " + theBrand.getBrandID() + " Brand: " + theBrand.getBrand());
        }
        return numOfVaxBrands;
    }

    //TODO - create a method to return brand information - 1 brand not the whole arraylist
    //return brand name, req shots, days between shots --> when fully effective


}
