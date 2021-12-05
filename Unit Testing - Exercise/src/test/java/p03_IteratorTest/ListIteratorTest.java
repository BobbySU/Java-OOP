package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    public static final String[] ELEMENTS_NAME = new String[]{"Bobby", "Bobby1"};

    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ELEMENTS_NAME);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorInitialiseInvalidListIterator() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorInitialiseListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Bobby", "Bobby1");
    }

    @Test
    public void moveInternalIndex() {
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void moveInternalIndexMoveMoreThenElements() {
        this.listIterator.move();
        this.listIterator.move();
        Assert.assertFalse(this.listIterator.move());
    }

    @Test
    public void testHasNextElement() {
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void testHasNoMoreNextElements() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
    }

    @Test
    public void testPrintElement() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(ELEMENTS_NAME[index], listIterator.print());
            index++;
            listIterator.move();
        }

    }
}