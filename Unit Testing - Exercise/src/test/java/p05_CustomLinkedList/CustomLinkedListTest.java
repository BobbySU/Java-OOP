package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private static final String TEST = "Bobby";
    private static final String SECOND_TEST = "SecondBobby";

    private CustomLinkedList<String> linkedList;

    @Before
    public void setUp(){
        this.linkedList = new CustomLinkedList<>();
    }

    @Test
    public void testCheckCorrectAddElementToList(){
        this.linkedList.add(TEST);
        Assert.assertTrue(this.linkedList.contains(TEST));
    }

    @Test
    public void testTryGetElementOfListWithValidIndex(){
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);
        Assert.assertEquals(SECOND_TEST,this.linkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTryGetElementOfListWithInvalidIndex(){
        this.linkedList.add(TEST);
        this.linkedList.get(1);
    }

    @Test
    public void testCheckCorrectWorkingContainsElementInList(){
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);
        Assert.assertTrue(this.linkedList.contains(TEST));
    }

    @Test
    public void testCheckCorrectRemoveElementOfList(){
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);
        Assert.assertEquals(0,this.linkedList.remove(TEST));
    }

    @Test
    public void testCheckCorrectReturnIndexIfRemovedElementNotContained(){
        Assert.assertEquals(-1,this.linkedList.remove(TEST));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTryRemoveAtWithInvalidIndex(){
        this.linkedList.removeAt(-1);
    }

    @Test
    public void testRemoveElementAtIndexIfWorkingReturnCorrectValue(){
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);
        Assert.assertEquals(SECOND_TEST,this.linkedList.removeAt(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTrySetElementOnInvalidIndex(){
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);
        this.linkedList.set(5,TEST);
    }

    @Test
    public void testTrySetElementOnValidIndex(){
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);
        this.linkedList.set(1,TEST);
        Assert.assertEquals(TEST,this.linkedList.get(1));
    }

    @Test
    public void testGetCount(){
        this.linkedList.add(TEST);
        this.linkedList.add(SECOND_TEST);
        Assert.assertEquals(2,this.linkedList.getCount());
    }
}