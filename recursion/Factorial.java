package recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of "+n+" is: "+fact(n));
    }

    private static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        return n * fact(n-1);
    }
}
