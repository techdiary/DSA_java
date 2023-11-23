package recursion;

import java.util.ArrayList;

public class DiceRoll {
    public static void main(String[] args) {
        int choice = 4;
        dice("", choice);
        ArrayList<String> ans = diceList("", choice);
        System.out.println(ans);
    }

    private static void dice(String p, int choice) {

        if(choice == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <=6 && i<=choice; i++) {
            dice(p+i, choice-i);
        }
    }


    private static ArrayList<String> diceList(String p, int choice) {
 
        if(choice == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 1; i <=6 && i<=choice; i++) {
            ans.addAll(diceList(p+i, choice-i));
        }

        return ans;
    }
}
