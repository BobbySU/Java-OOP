package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

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
        setNumber(number);
        setSize(size);
        setPricePerPerson(pricePerPerson);
        this.healthyFoods = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
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
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFoods.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        return healthyFoods.stream().mapToDouble(HealthyFood::getPrice).sum()
                + beverages.stream().mapToDouble(Beverages::getPrice).sum();
    }

    @Override
    public void clear() {
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        this.healthyFoods.clear();
        this.beverages.clear();
    }

    @Override
    public String tableInformation() {
        return String.format("Table - {table number}%n" +
                "Size - {table size}%n" +
                "Type - {table type}%n" +
                "All price - {price per person for the current table}"
                ,this.number,this.size,this.isReservedTable,this.pricePerPerson);
    }
}
