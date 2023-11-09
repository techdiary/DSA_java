package recursion;

public class DigitSum {

    public static void main(String[] args) {
        int n = 1342;
        System.out.println(sumOfDigits(n));
    }

    private static int sumOfDigits(int n) {
        if(n == 0) {
            return 0;
        }
        int rem = n % 10;
        int newN = n / 10;
        return rem + sumOfDigits(newN);

    }
}
