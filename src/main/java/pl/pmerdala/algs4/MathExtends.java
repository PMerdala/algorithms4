package pl.pmerdala.algs4;

import java.util.ArrayList;
import java.util.List;

public class MathExtends {

    public static boolean isPrime(long n) {
        if (n < 1) throw new IllegalArgumentException("nieprawidłowy argument n=" + n);
        if (n < 4) return true;
        if (n%2==0) return false;
        for (long i = 3; i * i < n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
