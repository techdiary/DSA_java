package search;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,15,16,17,18,20,24};
        int target = 15;
        int floor = floor(arr, target);
        System.out.println(floor);
    }

    public static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            System.out.println(start+" "+end);
            System.out.println(arr[start]+" "+arr[end]);
            System.out.println(" ");
            int mid = start + (end-start)/2;
            if(arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target){
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return arr[end];

    }
}
