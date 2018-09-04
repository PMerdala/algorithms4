package pl.pmerdala.algs4.std;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StdStatisticTest {

    private double[] a={56, 45, 76, 45, 83, 81, 93, 67, 66, 65};
    private double[] a2={18, 30, 21, 42, 55, 34, 45, 39, 38, 25};
    private double[] amediana = {139, 141, 142, 147, 148, 149, 149, 150, 152, 153, 153, 155, 158, 159, 161};
    private double[] amediana2 = {1, 2, 3, 4, 5, 6, 7, 8};
    StdStats std;

    @Before
    public void setUp(){
        std = new StdStats();
    }

    @Test
    public void max() {
        assertEquals(93,std.max(a),1e-15);
    }

    @Test
    public void min() {
        assertEquals(45,std.min(a),1e-15);
    }

    @Test
    public void avg() {
        assertEquals(67.7,std.avg(a),1e-2);
    }

    @Test
    public void var() {
        assertEquals(255.34,std.var(a),1e-2);
    }

    @Test
    public void stddev2() {
        assertEquals(11.47,std.stddev(a2),1e-2);
    }

    @Test
    public void stddev() {
        assertEquals(15.98,std.stddev(a),1e-2);
    }

    @Test
    public void mediana() {
        double[] b = Arrays.copyOf(amediana,amediana.length);
        assertEquals(150,std.mediana(b),1e-2);
    }
    @Test
    public void median2() {
        double[] b = Arrays.copyOf(amediana2,amediana2.length);
        assertEquals(4.5,std.mediana(b),1e-2);
    }
    @Test
    public void testfloorDiv() {
        assertEquals(0,Math.floorDiv(1,2));
        assertEquals(1,Math.floorDiv(3,2));
    }
}