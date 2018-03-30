package pl.pmerdala.algs4;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreatestCommonDivisorTest {

    @Test
    public void textSimpleGcd() {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        int result = gcd.gcd(18, 12);
        assertEquals(6, result);
    }

    @Test
    public void testOneGcd() {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        int result = gcd.gcd(17, 11);
        assertEquals(1, result);
    }

    @Test
    public void testZeroGcd() {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        int result = gcd.gcd(17, 0);
        assertEquals(17, result);
    }
}
