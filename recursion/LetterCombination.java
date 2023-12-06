package recursion;

import java.util.ArrayList;

public class LetterCombination {

    public static void main(String[] args) {
        String digits = "99";

        ArrayList<String> pads = letterCombination2("", digits);
        int padcount = letterCombinationCount("", digits);
//        System.out.println(padcount);
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

        for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
            char ch;
            if(i>17){
                ch = (char)('a'+(i+1));
            } else {
                ch = (char)('a'+i);
            }
            ans.addAll(letterCombination2(p + ch, up.substring(1)));
            if(i==17){
                char uch = (char)('a' + i+1);
                ans.add(String.valueOf(uch));
            } else if(i == 23){
                char uch = (char)('a' + i+2);
                ans.add(String.valueOf(uch));
            }
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
