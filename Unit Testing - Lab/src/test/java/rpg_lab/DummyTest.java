package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;

    private Dummy dummy;
    private Dummy deathDummy;

    @Before
    public void setUp() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.deathDummy = new Dummy(0, DUMMY_XP);
    }

    //Dummy loses health if attacked.
    @Test
    public void testDummyLosesHealthIfAttacked() {
        dummy.takeAttack(1);
        Assert.assertEquals(DUMMY_HEALTH - 1, dummy.getHealth());
    }

    //Dead Dummy throws exception if attacked.
    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionIfAttacked() {
        deathDummy.takeAttack(10);
    }

    //Dead Dummy can give XP.
    @Test()
    public void testDeadDummyCanGiveXP() {
        Assert.assertEquals(DUMMY_XP, deathDummy.giveExperience());
    }

    //Alive Dummy can&#39;t give XP.
    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCantGiveXP() {
        dummy.giveExperience();
    }
}