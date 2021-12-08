package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    private Shop shop;
    private Goods goods;

    @Before
    public void setUp() {
        this.shop = new Shop();
        this.goods = new Goods("Banana", "Ba");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldReturnUnmodifiableCollection() {
        shop.getShelves().clear();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailForInvalidShelve() throws OperationNotSupportedException {
        shop.addGoods("invalid_test_shelve", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailForExistingGood() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test
    public void testAddGoodsShouldReturnCorrectMessageOnAddition() throws OperationNotSupportedException {
        String expected = "Goods: Ba is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailForInvalidShelve() throws OperationNotSupportedException {
        shop.removeGoods("invalid_test_shelve", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailForDifferentGoodOnTheSameShelve() throws OperationNotSupportedException {
        Goods goodsOther = new Goods("test_good_other", "test_code_other");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goodsOther);
    }

    @Test
    public void testRemoveGoodsShouldReturnCorrectMessage() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: Ba is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveGoodsShouldSetTheShelveValueToNull() throws OperationNotSupportedException {
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Goods emptySlot = shop.getShelves().get("Shelves1");
        Assert.assertNull(emptySlot);
    }
}