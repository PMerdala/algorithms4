package pl.pmerdala.algs4;

public class GreatestCommonDivisor {

    public int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q,r);
    }
}
