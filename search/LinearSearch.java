package search;

import java.util.Scanner;
import common.Util;

public class LinearSearch {
  
  public static void main(String[] args) {
    System.out.println("Enter comma seprated variables: ");
  
    int[] intArr = Util.getIntArr();
    // try (Scanner in = new Scanner(System.in)) {
    //   String inputArray = in.nextLine();
    //   String[] strArray = inputArray.split(",");
    //   int arrayLength = strArray.length;
    //   int[] array = new int[arrayLength];
    //   for(int i=0; i < arrayLength; i++) {
    //     array[i] = Integer.parseInt(strArray[i]);
    //   }
    System.out.print("Enter search number: ");
    try (Scanner str = new Scanner(System.in)) {
      String searchString = str.nextLine();
      int searchNumber = Integer.parseInt(searchString);
      
      boolean ans = linearsearchNumberinArray(intArr, searchNumber);
      if (ans) {
        System.out.println("Found the number "+searchNumber+" in array");
      } else {
        System.out.println("The number "+searchNumber+" not found in array");
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
    // } catch (NumberFormatException e) {
    //   e.printStackTrace();
    // }
  }
  
  // search in array => return true if item found & if not found return false;
  static boolean linearsearchNumberinArray(int[] array, int searchNumber) {
    boolean answer = false;
    if (array.length > 0) {
      for (int i = 0; i < array.length; i++) {
        if(array[i] == searchNumber){
          return true;
        }
      }
    }

    return answer;
  }


}