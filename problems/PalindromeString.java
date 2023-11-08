package problems;

import java.util.Locale;

public class PalindromeString {

    public static void main(String[] args) {
        String pal = "ab";
        String pal1 = "abccba";
        isPalindrome(pal);
        isPalindrome(pal1);
        fibo(1);
    }

    private static void isPalindrome(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);
            if(start != end) {
                System.out.println(str+" is not a Palindrome string");
                return;
            } else {
                System.out.println(str+" is Palindrome string");
                return;
            }
        }
    }

    static void fibo(int n) {
        if (n > 120) {
            return;
        }
        System.out.println("No: "+n);
        n = n+n;
        fibo(n);
    }
}
