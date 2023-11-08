package problems.math;

public class isPrime {

    public static void main(String[] args) {
        int num = 40;
//        System.out.println(isPrime(num));
        for (int i = 0; i < num; i++) {
            System.out.println("Is number "+ i + " prime?: " + isPrime(i));
        }
    }

    static boolean isPrime(int num) {
        if( num <= 1) {
            return false;
        }

        int d = 2;
        while(d*d <= num){
            if(num % d == 0){
                return false;
            }
            d++;
        }
        return true;
    }

}
