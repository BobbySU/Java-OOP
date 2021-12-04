package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private static final int BIG_NUMBERS = 18;
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorShouldCreateValidDatabase() {
        Integer[] dbElements = database.getElements();

        Assert.assertEquals("Count of db element is incorrect", NUMBERS.length, dbElements.length);
        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals("We have difference elements in database", NUMBERS[i], dbElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowException17Elements() throws OperationNotSupportedException {
        Integer[] arr = new Integer[BIG_NUMBERS];
        new Database(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowException0Elements() throws OperationNotSupportedException {
        Integer[] arr = new Integer[0];
        new Database(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowExceptionNullElements() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddAddElements() throws OperationNotSupportedException {
        database.add(1);
        Integer[] testBase = database.getElements();
        Assert.assertEquals(testBase.length, NUMBERS.length + 1);
        Assert.assertEquals(testBase[testBase.length - 1],
                Integer.valueOf(1));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMoreElementsThanThereAre() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length + 1; i++) {
            database.remove();
        }
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] testBase = database.getElements();
        Assert.assertEquals(NUMBERS.length - 1, testBase.length);
        Assert.assertEquals(Integer.valueOf(NUMBERS.length - 1), testBase[testBase.length - 1]);
    }
}