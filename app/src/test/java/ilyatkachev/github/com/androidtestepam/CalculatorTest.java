package ilyatkachev.github.com.androidtestepam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }
    @Test
    public void orderIsNotNull() {
        assertNotNull(mCalculator);
    }
    @Test
    public void multiply() throws Exception {
        assertEquals(1000,mCalculator.multiply(5,10,20),0);
    }

}