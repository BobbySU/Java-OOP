package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    private Aquarium aquarium;
    private Fish fish;
    private Fish fish1;

    @Before
    public void setUp() {
        this.aquarium = new Aquarium("MyAquarium", 2);
        this.fish = new Fish("Doni");
        this.fish1 = new Fish("Ani");
    }

    @Test(expected = NullPointerException.class)
    public void testSetUpAquariumWrongName() {
        this.aquarium = new Aquarium(" ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetUpAquariumWrongCapacity() {
        this.aquarium = new Aquarium("MyAquarium", -5);
    }

    @Test
    public void testAquariumGet() {
        Assert.assertEquals("MyAquarium", aquarium.getName());
        Assert.assertEquals(2, aquarium.getCapacity());
    }

    @Test
    public void testAquariumGetCount() {
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFish() {
        aquarium.add(fish);
        aquarium.add(fish);
        aquarium.add(fish);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFell() {
        aquarium.remove("Doni");
    }

    @Test
    public void testRemove() {
        aquarium.add(fish);
        aquarium.remove("Doni");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFall() {
        aquarium.sellFish("Doni");
    }

    @Test
    public void testSellOk() {
        aquarium.add(fish);
        aquarium.sellFish("Doni");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void testReport() {
        aquarium.add(fish);
        aquarium.add(fish1);
        Assert.assertEquals("Fish available at MyAquarium: Doni, Ani", aquarium.report());
    }

    @Test
    public void test() {

    }
}

