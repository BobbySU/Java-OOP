package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;

    private Dummy dummy;
    private Axe axe;

    @Before
    public void setUp() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    //Test if weapon loses durability after each attack;
    @Test
    public void testWeaponLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(0, axe.getDurabilityPoints());
    }

    //Test attacking with a broken weapon.
    @Test(expected = IllegalStateException.class)
    public void testAttakingWithBbokenWeapon() {
        axe.attack(dummy);
        axe.attack(dummy);
    }
}