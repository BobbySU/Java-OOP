package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private Cat cat;
    private Cat cat1;
    private Cat cat2;
    private House house;

    @Before
    public void setUp() {
        this.house = new House("MyHouse", 2);
        this.cat = new Cat("Bobby");
        this.cat1 = new Cat("Ani");
        this.cat2 = null;
    }

    @Test(expected = NullPointerException.class)
    public void testHouseNameNull() {
        this.house = new House(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testHouseNameIsEmpty() {
        this.house = new House(" ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityBelowZero() {
        this.house = new House("MyHouse", -2);
    }

    @Test
    public void testGetNameAndGetCapacity() {
        Assert.assertEquals("MyHouse", house.getName());
        Assert.assertEquals(2, house.getCapacity());
    }

    @Test
    public void testGetCount() {
        house.addCat(cat);
        house.addCat(cat1);
        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatWhenFull() {
        house.addCat(cat);
        house.addCat(cat1);
        house.addCat(cat2);
    }

    @Test
    public void testRemoveCatCorrect() {
        house.addCat(cat);
        house.removeCat("Bobby");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatIncorrect() {
        house.removeCat("Bobby");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleIncorrect() {
        house.catForSale("Bobby");
    }

    @Test
    public void testCatForSaleIsHungry() {
        house.addCat(cat);
        house.catForSale("Bobby");
        Assert.assertFalse(cat.isHungry());
    }

    @Test
    public void testCatForSale() {
        house.addCat(cat);
        house.catForSale("Bobby");
        Assert.assertEquals(cat,house.catForSale("Bobby"));
    }

    @Test
    public void testStatistics() {
        house.addCat(cat);
        house.addCat(cat1);
        Assert.assertEquals( "The cat Bobby, Ani is in the house MyHouse!",house.statistics());
    }
}
