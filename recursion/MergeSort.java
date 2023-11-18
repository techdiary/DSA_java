package recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};
//        int[] ans = mergeSort(arr);
//        System.out.println(Arrays.toString(ans));
        mergeSort2(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] mergeSort(int[] arr) {

        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {

        int[] mix = new int[left.length + right.length];

        int lp = 0;
        int rp = 0;
        int mp = 0;

        while (lp < left.length && rp < right.length) {

            if(left[lp] < right[rp]) {
                mix[mp] = left[lp];
                lp++;
            } else {
                mix[mp] = right[rp];
                rp++;
            }
            mp++;
        }
        //  it may be possible that one of the arrays is not complete
        // copy remaining elements
        while (lp < left.length) {
            mix[mp] = left[lp];
            lp++;
            mp++;
        }

        while (rp < right.length) {
            mix[mp] = right[rp];
            rp++;
            mp++;
        }
        return mix;

    }


    private static void mergeSort2(int[] arr, int s, int e) {
        if((e-s) == 1){
            return;
        }

        int mid = (s+e) / 2;

        mergeSort2(arr, s, mid);
        mergeSort2(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int lp = s;
        int rp = m;
        int mp = 0;

        while (lp < m && rp < e) {

            if(arr[lp] < arr[rp]) {
                mix[mp] = arr[lp];
                lp++;
            } else {
                mix[mp] = arr[rp];
                rp++;
            }
            mp++;
        }
        //  it may be possible that one of the arrays is not complete
        // copy remaining elements
        while (lp < m) {
            mix[mp] = arr[lp];
            lp++;
            mp++;
        }

        while (rp < e) {
            mix[mp] = arr[rp];
            rp++;
            mp++;
        }


        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
}
