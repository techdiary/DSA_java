package search;

public class MountainArray {

    public static void main(String[] args) {
        int[] arr = {0,10,5,2};
        int ans = binarySearch(arr);
        System.out.println(ans);

    }

    static int binarySearch(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                end = mid;
            } else if (arr[mid+1] > arr[mid]) {
                start = mid + 1;
            } else if(arr[start] == arr[end]){
                return mid;
            }

        }

        return start;

    }

}
