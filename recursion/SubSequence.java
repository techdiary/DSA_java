package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSequence {
    public static void main(String[] args) {
//        subseq("", "abc");
        ArrayList<String> strr = subseqArr("", "abc");
        System.out.println(strr);
    }

    static void subseq(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

         subseq(p+ch, up.substring(1));
         subseq(p, up.substring(1));
    }

    static ArrayList<String> subseqArr(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subseqArr(p+ch, up.substring(1));
        ArrayList<String> right = subseqArr(p, up.substring(1));

        left.addAll(right);
        return left;

    }
}
