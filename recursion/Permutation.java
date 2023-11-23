package recursion;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        String str = "abc";
        permutate("",str);
        ArrayList<String> ans = permutateList("", str);
        System.out.println(ans);
    }

    private static void permutate(String p, String up) {

        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutate(f+ch+s, up.substring(1)) ;
        }

    }

    private static ArrayList<String> permutateList(String p, String up) {

        if (up.isEmpty()) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }

        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            ans.addAll(permutateList(f+ch+s, up.substring(1))) ;
        }

        return ans;

    }


}
