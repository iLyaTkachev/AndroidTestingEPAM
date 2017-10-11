package ilyatkachev.github.com.androidtestepam;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    private Calculator mCalculator;
    private Order mOrder1;
    private Order mOrder2;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
        mOrder1 = mock(Order.class);
        mOrder2 = spy(Order.class);
        when(mOrder1.getmProductPrice()).thenReturn(10.0f);
        when(mOrder1.getmProductCount()).thenReturn(5);
        when(mOrder2.getmProductPrice()).thenReturn(2.0f);
        when(mOrder2.getmProductCount()).thenReturn(15);
    }

    @Test
    public void orderIsNotNull() {
        assertNotNull(mCalculator);
    }

    @Test
    public void add() throws Exception {
        assertEquals(12.0, mCalculator.add(mOrder1.getmProductPrice(), mOrder2.getmProductPrice()), 0);
    }

    @Test
    public void multiply() throws Exception {
        float result = mCalculator.multiply(mOrder1.getmProductCount(), mOrder1.getmProductPrice());
        assertEquals(50.0, result, 0);
        result = mCalculator.multiply(mOrder2.getmProductCount(), mOrder2.getmProductPrice());
        assertEquals(30.0, result, 0);
    }

    @Test
    public void mockTest() {
        mOrder1.setTotalPrice(100);
        assertEquals("Test fails because of mock object!",mOrder1.getmTotalPrice()==0,true);
        assertEquals(10, mOrder1.getmProductPrice(), 0);
    }

    @Test
    public void spyTest() {
        mOrder2.setTotalPrice(100);
        assertEquals(100, mOrder2.getmTotalPrice(), 0);
        assertEquals(2, mOrder2.getmProductPrice(), 0);
    }

}