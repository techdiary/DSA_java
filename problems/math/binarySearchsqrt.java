package problems.math;

public class binarySearchsqrt {
//    Complexity: O(log(n))
    public static void main(String[] args) {
        int n = 40;
        int p = 3;

        System.out.println(bssqrt(n, p));
    }

    static double bssqrt(int n, int p) {
        int start = 0;
        int end = n;

        double root = 0.0;

        while(start <= end) {
            int m = start + (end - start)/2;

            if( m * m == n){
                return m;
            }
            if(m * m > n) {
                end = m -1;
            }
            if(m * m < n) {
                start = m + 1;
            }
        }

        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }

        return root;
    }
}
