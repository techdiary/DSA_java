package search;

public class RotatedBinarySearch {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,7,8,8,0,1,2};
        int target = 7;
        int ans = search(arr, target);
        System.out.println(ans);
    }

    static int search(int[] arr, int target) {

        int peak = findPeakInArray(arr);
        if ( peak == -1) {
            return binarySearchFrom(arr, target, 0, arr.length - 1);
        }
        System.out.println("Peak value is: "+arr[peak]+ " at index: "+peak);
        if ( target == arr[peak]){
            return peak;
        } else if( target >= arr[0] ) {
            return binarySearchFrom(arr, target, 0, peak - 1);
        } else {
            return binarySearchFrom(arr, target, peak + 1, arr.length - 1);
        }
    }

    static int findPeakInArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while(start < end) {
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid] >= arr[mid+1]) {
                return mid;
            } else if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            } else if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("No peak value found!!\n");
        return -1;
    }
    static int findPeakInDupArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while(start < end) {
            int mid = start + (end-start)/2;
            if(mid < end && arr[mid] >= arr[mid+1]) {
                return mid;
            } else if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            } else if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if(arr[start] > arr[start+1]){
                    return start;
                } else if( arr[end] < arr[end-1]) {
                    return end;
                }
                start++;
                end--;
            } else if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("No peak value found!!\n");
        return -1;
    }
    static int binarySearchFrom(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if( arr[mid] > target) {
                end = mid -1;
            } else if(arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
