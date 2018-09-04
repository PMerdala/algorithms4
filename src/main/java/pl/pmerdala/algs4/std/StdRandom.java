package pl.pmerdala.algs4.std;

import java.util.Random;

public class StdRandom {

    private Random random = new Random();

    /**
     * ustawnienie ziarna pzowala na generowanie zawsze takich samych danych wejściowych
     *
     * @param seed
     */
    public void setSeed(long seed) {
        random = new Random(seed);
    }

    /**
     * Generowanie liczby pseudolosowej rzeczywistej z przedziału [0,1)
     *
     * @return
     */
    public double random() {
        return random.nextDouble();
    }

    /**
     * Generowanie liczby pseudolosowej rzeczywistej z przedziału [0,1)
     *
     * @return
     */
    public double uniform() {
        return random.nextDouble();
    }

    /**
     * Generownaie liczby pseudolosowej całkowitej z przediału [0,(n-1)]
     *
     * @param n
     * @return
     */
    public int uniform(int n) {
        return random.nextInt(n);
    }

    /**
     * Generownaie liczby pseudolosowej całkowitej z przediału [lo, (hi-1)]
     *
     * @param lo - najmniejsza wartość, hi - największa wartość
     * @return
     */
    public int uniform(int lo, int hi) {
        return lo + uniform(hi - lo);
    }

    /**
     * Generownaie liczby pseudolosowej reczywistej z przediału [lo - hi)
     *
     * @param lo, hi
     * @return
     */
    public double uniform(double lo, double hi) {
        return lo + random() * (hi - lo);
    }

    /**
     * Zwraca true z prawdopodobieństwem p
     *
     * @param p - prawdopodobieństo
     * @return
     */

    public boolean bernoulli(double p) {
        return uniform() < p;
    }

    /**
     * Zwraca true z prawdopodobieństwem 50%
     *
     * @return
     */
    public boolean bernoulli() {
        return bernoulli(.5);
    }

    /**
     * Generowanie zmiennych losowych o Rozkładzie normalnym, średnia 0, odch. st. 1
     *
     * @return
     */
    public double gaussian() {
        double r, x, y;
        do {
            x = uniform(-1.0, 1.0);
            y = uniform(-1.0, 1.0);
            r = x * x + y * y;
        } while (r >= 1 || r == 0);
        return x * Math.sqrt(-2 * Math.log(r) / r);
    }

    /**
     * Rozkład normalny, średnia m, odch. st. s
     *
     * @return
     */
    public double gaussian(double mean, double stddev) {
        return mean + stddev * gaussian();
    }

    /**
     * Generowanie zmiennej całkowitej o rozkładzie geometrycznym ze średnią(mean) 1/p
     * użyto algorytmu Knuth
     *
     * @param p
     * @return
     */
    public int geometric(double p) {
        return (int) Math.ceil(Math.log(uniform()) / Math.log(1.0 - p));
    }

    /**
     * Generowanie zmiennej całkowitej o rozkłądznie Poissona ze średnią (mean) lambda.
     * uzyto algorytmu Knuth
     *
     * @param lambda
     * @return
     * @see "http://en.wikipedia.org/wiki/Poisson_distribution"
     */
    public int poisson(double lambda) {
        int k = 0;
        double p = 1.0;
        double L = Math.exp(-lambda);
        do {
            k++;
            p *= uniform();
        } while (p >= L);
        return k - 1;
    }

    /**
     * Generowanie zmiennej rzeczywistej o rozkładzie pareto z parametrem podziału alpha
     *
     * @param alpha
     * @return
     */
    public double pareto(double alpha) {
        return Math.pow(1 - uniform(), -1.0 / alpha) - 1.0;
    }

    /**
     * Generowanie zmiennej rzeczywistej o rozkładzie cauchy
     * @return
     */
    public double cauchy(){
        return Math.tan(Math.PI*(uniform()-.5));
    }

    /**
     * Zwraca i z prawdopodobieństwem a[i]
     *
     * @param a tabela z wartościami rzeczyistymi z [rzedziału [0,1)
     * @return
     */
    public int discrete(double[] a) {
        double r = uniform();
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if(sum>=r) return i;
        }
        assert(false);
        return -1;
    }

    /**
     * Losowo porządkuje elementy tablicy a[]
     *
     * @param a
     */
    public void shuffle(double[] a) {

    }

}
