package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {
//https://leetcode.com/problems/missing-number/
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int missNum = missingNumber(arr);
        ArrayList<Integer> missingNums = missingNumbers(arr);
        System.out.println(missingNums);
        System.out.println(missNum);
    }


    static int missingNumber(int[] arr) {
        int i = 0;
        while(i< arr.length) {
            int correct= arr[i];
            // arr[i] < arr.length Needs to be done for N loop comparison
            if(arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        // search for missing number
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j){
                return j;
            }
        }

        return arr.length;
    }

    static ArrayList<Integer> missingNumbers(int[] arr) {
        int i = 0;
        while(i< arr.length) {
            int correct= arr[i] -1;
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        // search for missing numbers
        ArrayList<Integer> ans =new ArrayList<>();
        for (int index = 0; index < arr.length; index++) {
            if(arr[index] != index+1){
                ans.add(index+1);
            }
        }

        return ans;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
