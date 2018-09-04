package pl.pmerdala.algs4.std;

import java.util.Arrays;

public class StdStats {

    /**
     * Największa wartość
     * @param a
     * @return
     */
    public double max(double[] a){
        if(a.length==0) return Double.NaN;
        double m = a[0];
        for(double d : a )
            if (d>m) m=d;
        return m;
    }
    /**
     * Najmniejsza wartość
     * @param a
     * @return
     */
    public double min(double[] a){
        if(a.length==0) return Double.NaN;
        double m = a[0];
        for(double d : a )
            if (d<m) m=d;
        return m;
    }
    /**
     * średnia dla próbki
     * @param a
     * @return
     */
    public double avg(double[] a){
        if(a.length==0) return Double.NaN;
        double sum = 0;
        for(double d : a )
                sum+=d;
        return sum/a.length;
    }
    /**
     * Wariancja dla próbki
     * @param a
     * @return
     */
    public double var(double[] a){
        if(a.length==0) return Double.NaN;
        double sum = 0;
        double avg = avg(a);
        for(double d : a )
            sum+=Math.pow(d-avg,2);
        return sum/(a.length-1);
    }
    /**
     * odchylenie standardowe dla próbki
     * @param a
     * @return
     */
    public double stddev(double[] a){
        if(a.length==0) return Double.NaN;
        return Math.sqrt(var(a));

    }
    /**
     * omediana dla próbki próbka musi być posortowana
     * @param a
     * @return
     */
    public double mediana(double[] a){
        if(a.length==0) return Double.NaN;
        int i = Math.floorDiv(a.length,2)-1;
        double m;
        if (a.length%2 == 0){
            m = (a[i]+a[i+1])/2.0;
        }else{
            m=a[i+1];
        }
        return m;
    }
}
