package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.Collection;

public abstract class BaseTable implements Table {
        private Collection<HealthyFood> healthyFoods;
        private Collection<Beverages> beverages;
        private int number;
        private int size;
        private int numberOfPeople;
        private double pricePerPerson;
        private boolean isReservedTable;
        private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
      //todo
    }

    //•	healthyFood - Collection<HealthyFood> accessible only by the base class
    //•	beverages – Collection<Beverages> accessible only by the base class
    //•	number – int the table number
    //•	size - int the table size
    //o	It can’t be less than zero. In these cases, throw an IllegalArgumentException with message "Size has to be greater than 0!".
    //•	numberOfPeople - int the counter of people who want a table
    //o	It can’t be less than or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!".
    //•	pricePerPerson - double the price per person for the table
    //•	isReservedTable - boolean returns true if the table is reserved, otherwise false
    //•	allPeople - double calculates the price for all people

    @Override
    public int getTableNumber() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int numberOfPeople() {
        return 0;
    }

    @Override
    public double pricePerPerson() {
        return 0;
    }

    @Override
    public boolean isReservedTable() {
        return false;
    }

    @Override
    public double allPeople() {
        return 0;
    }

    @Override
    public void reserve(int numberOfPeople) {

    }

    @Override
    public void orderHealthy(HealthyFood food) {

    }

    @Override
    public void orderBeverages(Beverages beverages) {

    }

    @Override
    public double bill() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String tableInformation() {
        return null;
    }
}
