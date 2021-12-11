package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private Hero hero;
    private Hero hero1;
    private Hero hero2;
    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
        this.hero = new Hero("Bobby", 2);
        this.hero1 = new Hero("Ani", 1);
        this.hero2 = null;
    }

    @Test
    public void testGetCount() {
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNull() {
        heroRepository.create(hero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateSameName() {
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNull() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveIsEmpty() {
        heroRepository.remove(" ");
    }

    @Test
    public void testRemoveSusses() {
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("Bobby"));
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        heroRepository.create(hero1);
        heroRepository.create(hero);
        Assert.assertEquals(hero,heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelNull() {
        Assert.assertEquals(null,heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHero() {
        heroRepository.create(hero1);
        heroRepository.create(hero);
        Assert.assertEquals(hero,heroRepository.getHero("Bobby"));
    }

    @Test
    public void testGetHeroNull() {
        Assert.assertEquals(null,heroRepository.getHero("Bobby"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroes() {
        heroRepository.create(hero);
        Collection<Hero> heroes = heroRepository.getHeroes();
        heroes.remove(hero);
    }

    @Test
    public void test1() {

    }

    @Test
    public void test() {

    }
}
