package search;

// Smallest element in array greater than or equals to target element
public class Ceiling {

    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,17,18,20,24};
        int target = 15;
        int ceiling = ceiling(arr, target);
        System.out.println(ceiling);
    }

    public static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            System.out.println(start+" "+end);
            System.out.println(arr[start]+" "+arr[end]);
            System.out.println(" ---------- ");
            int mid = start + (end-start)/2;
            if(arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target){
                end = mid - 1;
            } else {
                return mid;
            }
            System.out.println(" ---------- ");
            System.out.println(start+" "+end);
            System.out.println(arr[start]+" "+arr[end]);
            System.out.println(" ");
        }

        return arr[start];

    }

}
