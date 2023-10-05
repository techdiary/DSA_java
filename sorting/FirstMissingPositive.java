package sorting;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {0,1,2};
        int[] nums1 = {3,4,-1,1};
        int[] nums2 = {7,8,9,11,12};

//        int ans = firstMissingPositive(nums);
        int ans1 = firstMissingPositive(nums1);
//        int ans2 = firstMissingPositive(nums2);

//        System.out.println("Answer of nums: " + ans);
        System.out.println("Answer of nums1: " + ans1);
//        System.out.println("Answer of nums2: " + ans2);
    }

    private static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int correct= nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index + 1) {
                return index + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
