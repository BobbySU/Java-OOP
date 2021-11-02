package ValidationData03;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
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

    public void setFirstName(String firstName) {
        namesLength(firstName,"First");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
       namesLength(lastName,"Last");
        this.lastName = lastName;
    }

    private void namesLength(String name, String prefix) {
        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " name cannot be less than 3 symbols");
        }
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    private void setSalary(double salary) {
        if (salary < 460.00) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
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
