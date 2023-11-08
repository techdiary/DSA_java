package problems.math;

public class newtonSqrt {

    public static void main(String[] args) {
        double ans = nsqrt(4);
        System.out.println(ans);
    }

    static double nsqrt(int n) {
        double x = n;
        double root;
        while(true){
            root = 0.5 * (x + (n/x));
            if(Math.abs(root -x )< 1){
                break;
            }

            x = root;
        }
        return root;
    }
}
