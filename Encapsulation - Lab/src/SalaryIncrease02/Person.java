package SalaryIncrease02;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        setSalary(salary);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.age >= 30) {
            setSalary(this.salary + ((this.salary * bonus) / 100));
        } else {
            setSalary(this.salary + ((this.salary * bonus) / 200));
        }
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#.0###");
        return String.format("%s %s gets %s leva.", getFirstName(), getLastName(), formatter.format(getSalary()));
    }
}
