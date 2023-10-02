package sorting;

import java.util.ArrayList;

public class DuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        int dupNum = getDuplicateNumber(nums);
        ArrayList<Integer> dupNums= getDuplicateNumbers(nums);
        System.out.println(dupNums);
        System.out.println(dupNum);
    }

    private static int getDuplicateNumber(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] != i+1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    swap(arr, i, correct);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    private static ArrayList<Integer> getDuplicateNumbers(int[] arr) {
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        for (int j = 0; j < arr.length; j++) {
         if(arr[j] != j + 1){
             ans.add(arr[j]);
         }
        }

        return ans;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
