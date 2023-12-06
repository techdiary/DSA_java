package LinkedList;

//https://leetcode.com/problems/happy-number/
public class HappyNumber {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = getSqrDigitSum(slow);
            System.out.println("SLOW: "+ slow);
            fast = getSqrDigitSum(getSqrDigitSum(fast));
            System.out.println("FAST: "+ fast);
        } while(fast != slow);

        return slow == 1;
    }

    private static int getSqrDigitSum(int n) {
        if(n == 0){
            return 0;
        }
        int rem = n % 10;
        int sqr = rem*rem;
        int newN = n / 10;
        return sqr + getSqrDigitSum(newN);
    }
}
