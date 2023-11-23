package recursion;

import java.util.ArrayList;

public class LetterCombination {

    public static void main(String[] args) {
        String digits = "12";

        ArrayList<String> pads = letterCombination2("", digits);
        int padcount = letterCombinationCount("", digits);
        System.out.println(padcount);
        System.out.println(pads);
    }

    private static void letterCombination(String p, String up) {

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1)*3; i < digit*3; i++) {
            char ch = (char)('a'+i);
            letterCombination(p + ch, up.substring(1));
        }

    }

    private static ArrayList<String> letterCombination2(String p, String up) {

        if(up.isEmpty()){
            ArrayList<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }

        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1)*3; i < digit*3; i++) {
            char ch = (char)('a'+i);
            ans.addAll(letterCombination2(p + ch, up.substring(1)));
        }

        return ans;
    }

    private static int letterCombinationCount(String p, String up) {

        if(up.isEmpty()){
            return 1;
        }

        int count = 0;
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1)*3; i < digit*3; i++) {
            char ch = (char)('a'+i);
            count = count + letterCombinationCount(p + ch, up.substring(1));
        }

        return count;
    }
}
