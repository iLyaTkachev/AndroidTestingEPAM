package ilyatkachev.github.com.androidtestepam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    private Order mOrder;
    private Calculator mCalculator;

    @Before
    public void setUp() {
        mOrder = new Order(5,0,0);
    }
    @Test
    public void orderIsNotNull() {
        assertNotNull(mOrder);
    }
    @Test
    public void incrementProductCount() throws Exception {
        mOrder.incrementProductCount();
        assertEquals(1,mOrder.getmProductCount());

        mOrder.setProductCount(30);
        mOrder.incrementProductCount();
        assertEquals(31, mOrder.getmProductCount());
    }

    @Test
    public void decrementProductCount() throws Exception {
        mOrder.decrementProductCount();
        assertEquals(0,mOrder.getmProductCount());

        mOrder.setProductCount(30);
        mOrder.decrementProductCount();
        assertEquals(29, mOrder.getmProductCount());
    }

    @Test
    public void setProductPrice() throws Exception {
        mOrder.setProductPrice(-1);
        assertEquals(5, mOrder.getmProductPrice(),0);

        mOrder.setProductPrice(30);
        assertEquals(30, mOrder.getmProductPrice(),0);
    }

    @Test
    public void setProductCount() throws Exception {
        mOrder.setProductCount(-1);
        assertEquals(0, mOrder.getmProductCount(),0);

        mOrder.setProductCount(30);
        assertEquals(30, mOrder.getmProductCount(),0);
    }

    @Test
    public void setTotalPrice() throws Exception {
        mOrder.setTotalPrice(-1);
        assertEquals(0, mOrder.getmTotalPrice(),0);

        mOrder.setTotalPrice(30);
        assertEquals(30, mOrder.getmTotalPrice(),0);
    }

    @Test
    public void getProductPrice() throws Exception{
        assertEquals(5,mOrder.getmProductPrice(),0);

        mOrder.setProductPrice(30);
        assertEquals(30,mOrder.getmProductPrice(),0);
    }

    @Test
    public void getProductCount() throws Exception{
        assertEquals(0,mOrder.getmProductCount(),0);

        mOrder.setProductCount(30);
        assertEquals(30,mOrder.getmProductCount(),0);
    }

    @Test
    public void getTotalPrice() throws Exception{
        assertEquals(0,mOrder.getmTotalPrice(),0);

        mOrder.setTotalPrice(30);
        assertEquals(30,mOrder.getmTotalPrice(),0);
    }

}