// Iteration
class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        if (n == 0) return 1.0;
        long N = n;
        if (n < 0.0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        for (long i = 0; i < N; i++) {
            result = result * x;
        }        
        return result;
    }
}

// Recursion
class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        if (n == 0) return 1.0;
        if (n == 2) return x * x;
        if (n < 0.0) {
            return 1/x * myPow(1/x, -(n+1));
        }
        if (n %2 == 0) {
            return myPow(myPow(x, n/2), 2);
        } else {
            return x * myPow(myPow(x, n/2), 2);
        }
    }
}
