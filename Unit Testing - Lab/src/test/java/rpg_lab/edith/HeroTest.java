package rpg_lab.edith;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.edith.interfaces.Target;
import rpg_lab.edith.interfaces.Weapon;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;

    @Before
    public void setUp() {
        Weapon mock = Mockito.mock(Weapon.class);
        this.hero = new Hero("Bobby", mock);
    }

    @Test
    public void testUponTargetKillHeroGetXP() {
        Target mockedTarget =Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(1000);

        this.hero.attack(mockedTarget);
        assertEquals(1000,this.hero.getExperience());
    }

    @Test
    public void testUponTargetAttackWhileTargetIsStillAliveHeroGetsNoXP() {
        Target mockedTarget =Mockito.mock(Target.class);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(100);

        this.hero.attack(mockedTarget);
        assertEquals(0,this.hero.getExperience());
    }
}