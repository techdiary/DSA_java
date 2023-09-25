package search.common;
import java.util.Scanner;

public final class Util {

  public static void main(String[] args) {
    
  }

  public static int[] getIntArr() {
    System.out.println("Enter comma seprated variables: ");
    try (Scanner in = new Scanner(System.in)) {
      String inputArray = in.nextLine();
      String[] strArray = inputArray.split(",");
      int arrayLength = strArray.length;
      int[] array = new int[arrayLength];
      for (int i = 0; i < arrayLength; i++) {
        array[i] = Integer.parseInt(strArray[i]);
      }
      in.close();
      return array;
    } catch (NumberFormatException e) {
      e.printStackTrace();
      return null;
    }
  }
}
