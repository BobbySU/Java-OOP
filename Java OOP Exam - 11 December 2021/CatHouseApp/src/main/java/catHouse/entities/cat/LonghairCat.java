package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        this.setKilograms(3);
    }
}
