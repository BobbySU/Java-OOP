package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        this.setKilograms(1);
    }
}
