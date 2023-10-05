package sorting;

import java.util.Arrays;

class SetMismatch {

    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int[] ans = findErrorNums(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] findErrorNums(int[] nums) {
        cycleSort(nums);
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index +1){
                System.out.println("Index of missing number is "+ index +" & dup array is "+ (index +1));
                return new int[]{index, index+1};
            }
        }
        return new int[]{-1, -1};
    }

    private static void cycleSort(int[] arr) {
        int i = 0;
        while(i< arr.length) {
            int correct= arr[i] - 1;
            if(arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
