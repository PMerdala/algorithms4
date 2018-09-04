package pl.pmerdala.algs4.std;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StdRandomTest {

    StdRandom random;
    double[] a= {.1,.2,.3,.4,.5,.6,.7,.8,.9};

    @Before
    public void setUp(){
        random = new StdRandom();
        random.setSeed(101);
    }

    @Test
    public void random() {
        assertEquals(0.7219200581862772,random.random(),1e-15);
    }

    @Test
    public void uniformN() {
        assertEquals(40,random.uniform(100));
    }

    @Test
    public void uniformIntLoHi() {
        assertEquals(80,random.uniform(10,100));
    }

    @Test
    public void uniformDoubleLoHi() {
        assertEquals(74.97280523676496,random.uniform(10.0,100.0),1e-15);
    }

    @Test
    public void bernoulli() {
        assertFalse(random.bernoulli(.5));
        assertTrue(random.bernoulli(.5));
    }

    @Test
    public void gaussian() {
        assertEquals(1.3803823236577413,random.gaussian(),1e-15);
    }

    @Test
    public void gaussianN() {
        assertEquals(10.282293941946447,random.gaussian(2,6),1e-15);
    }

    @Test
    public void geometric() {
        assertEquals(10,random.geometric(.0342));
    }

    @Test
    public void poisson() {
        assertEquals(1,random.poisson(1.21));
    }

    @Test
    public void pareto() {
        assertEquals(2.135285441232619,random.pareto(1.12),1e-15);
    }

    @Test
    public void cauchy(){
        assertEquals(0.8374832676265089,random.cauchy(),1e-15);
    }

    @Test
    public void discrete() {
        assertEquals(3,random.discrete(a));
    }

    @Test
    public void shuffle() {
    }
}