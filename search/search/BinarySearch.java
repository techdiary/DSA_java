package search.search;

import search.common.Util;

public class BinarySearch {

  public static void main(String[] args) {
    int[] intArr = Util.getIntArr();
    // int[] intArr = {5,8,9,10,11,12};
    if (intArr == null) {
      return;
    }
    int ans = binarySearch(intArr, 10);
    System.out.println(ans);
  }
  
  static int binarySearch(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
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
