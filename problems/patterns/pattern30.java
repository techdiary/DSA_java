package problems.patterns;

//            1
//          2 1 2
//        3 2 1 2 3
//      4 3 2 1 2 3 4
//    5 4 3 2 1 2 3 4 5
public class pattern30 {

    public static void main(String[] args) {
        int n = 5;
        for (int row = 0; row < 2 * n; row++) {
            int totalColInRow = row > n ? 2*n - row: row;
            int noOfSpaces = n - totalColInRow;
            for (int i = 0; i < noOfSpaces; i++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
