package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm
    private Animal animal;
    private Animal animal1;
    private Animal animal2;
    private Farm farm;

    @Before
    public void setUp() {
        this.animal = new Animal("Coll", 10.0);
        this.animal1 = new Animal("Dog", 10.0);
        this.animal2 = new Animal("Cat", 10.0);
        this.farm = new Farm("MyFarm", 2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOutOfCapacity() {
        farm.add(animal);
        farm.add(animal1);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSameAnimal() {
        farm.add(animal);
        farm.add(animal);
    }

    @Test
    public void testRemoveAnimal(){
        farm.add(animal1);
        Assert.assertFalse(farm.remove(animal.getType()));
    }

    @Test
    public void testRemoveAnimalInFarm(){
        farm.add(animal);
        Assert.assertTrue(farm.remove(animal.getType()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityBeloyZero(){
        this.farm = new Farm("My",-1);
    }


    @Test(expected = NullPointerException.class)
    public void testSetNameEmpty(){
        this.farm = new Farm(" ",0);
    }

    @Test
    public void testGetCountAndName(){
        Assert.assertEquals("MyFarm",farm.getName());
        farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
    }

    @Test
    public void test(){

    }
}
