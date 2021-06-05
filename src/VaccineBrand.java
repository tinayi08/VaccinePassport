import java.util.ArrayList;

public class VaccineBrand {

    private static ArrayList<Vaccine> brand;


    public static ArrayList<Vaccine> getBrand() {
        return brand;
    }

    public VaccineBrand() {
        if (brand == null) {
            brand = new ArrayList<Vaccine>();
        }

    }
}
