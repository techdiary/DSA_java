package search;

public class InfiniteArray {

    public static void main(String[] args) {

    }

    public static int findingAns(int[] arr, int target) {
        //find the range
            //start with box size of 2
        int start = 0;
        int end = 1;
        // condition for the target to lie in the range
        while ( target > arr[end] ) {
            end = end + (end - start) * 2;
            start = end + 1;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        String order;
        if(arr[start] < arr[end]) {
            order = "asc";
        } else {
            order = "dsc";
        }

        System.out.println(order);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (order.equals("asc")) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (target < arr[mid]) {
                    end = mid + 1;
                } else if (target > arr[mid]) {
                    start = mid - 1;
                } else {
                    return mid;
                }
            }

        }

        return -1;

    }

}
