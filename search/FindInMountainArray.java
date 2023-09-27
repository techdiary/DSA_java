package search;

 /**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

 public class FindInMountainArray {
     public static void main(String[] args) {

     }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        int ans = orderAgnosticBinarySearch(mountainArr, target, 0, peak);
        if (ans == -1) {
            return orderAgnosticBinarySearch(mountainArr, target, peak+1, mountainArr.length() - 1);
        } else {
            return ans;
        }
    }
    public static int peakIndexInMountainArray(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(mid+1)) {
                end = mid;
            } else if (arr.get(mid+1) > arr.get(mid)) {
                start = mid + 1;
            } else if(arr.get(start) == arr.get(end)){
                return mid;
            }

        }

        return start;

    }

    public int orderAgnosticBinarySearch(MountainArray arr, int target, int start, int end) {
        String order;
        if(arr.get(start) < arr.get(end)) {
            order = "asc";
        } else {
            order = "dsc";
        }


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (order.equals("asc")) {
                if (target < arr.get(mid)) {
                    end = mid - 1;
                } else if (target > arr.get(mid)) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (target < arr.get(mid)) {
                    end = mid + 1;
                } else if (target > arr.get(mid)) {
                    start = mid - 1;
                } else {
                    return mid;
                }
            }

        }

        return -1;

    }
}