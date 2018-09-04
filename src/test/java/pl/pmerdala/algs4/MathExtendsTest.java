package pl.pmerdala.algs4;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathExtendsTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIsPrimeException() {
        MathExtends.isPrime(0);
    }
    @Test
    public void testIsPrime1_2_3(){
        assertTrue(MathExtends.isPrime(1));
        assertTrue(MathExtends.isPrime(2));
        assertTrue(MathExtends.isPrime(3));
    }
    @Test
    public void testIsPrime4_6_8(){
        assertFalse(MathExtends.isPrime(4));
        assertFalse(MathExtends.isPrime(6));
        assertFalse(MathExtends.isPrime(8));
    }

    @Test
    public void testIsPrime5_7_11_13_17(){
        assertTrue(MathExtends.isPrime(5));
        assertTrue(MathExtends.isPrime(7));
        assertTrue(MathExtends.isPrime(11));
        assertTrue(MathExtends.isPrime(13));
        assertTrue(MathExtends.isPrime(17));
    }

    //@Test
    public void testIsPrieTest1(){
        assertTrue(MathExtends.isPrime(1111111111111111111l));
    }

    @Test
    public void testIsPrieTest2(){
        assertFalse(MathExtends.isPrime(172393938479885l));
    }

}