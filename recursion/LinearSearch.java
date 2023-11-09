package recursion;

import java.util.ArrayList;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {2,3,1,4,4,5};
        System.out.println(find(arr, 4, 0));
        System.out.println(findIndex(arr, 4, 0));
        System.out.println(findIndexFromLast(arr, 4, arr.length-1));
        findAllIndex(arr, 4, 0);
        System.out.println(list);
        System.out.println(findAllIndexWithArray(arr, 4, 0, list2));
    }
    private static boolean find(int[] arr, int n, int i) {

        if (arr.length == i){
            return false;
        }
        return arr[i] == n || find(arr, n, i+1);
    }

    private static int findIndex(int[] arr, int n, int index) {
        if (index == arr.length) {
            return -1;
        }
        if(arr[index] == n) {
            return index;
        } else {
            return findIndex(arr, n, index + 1);
        }
    }

    private static int findIndexFromLast(int[] arr, int n, int index) {
        if (index == -1) {
            return -1;
        }
        if(arr[index] == n) {
            return index;
        } else {
            return findIndexFromLast(arr, n, index - 1);
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();
    private static void findAllIndex(int[] arr, int n, int index) {
        if (index == arr.length) {
            return;
        }
        if(arr[index] == n) {
            list.add(index);
        }
        findAllIndex(arr, n, index + 1);
    }

    static ArrayList<Integer> findAllIndexWithArray(int[] arr, int n, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if(arr[index] == n) {
            list.add(index);
        }
        return findAllIndexWithArray(arr, n, index + 1, list);
    }
}
