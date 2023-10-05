package problems.patterns;

//         4 4 4 4 4 4 4
//         4 3 3 3 3 3 4
//         4 3 2 2 2 3 4
//         4 3 2 1 2 3 4
//         4 3 2 2 2 3 4
//         4 3 3 3 3 3 4
//         4 4 4 4 4 4 4
public class Pattern31 {

    public static void main(String[] args) {
        pattern31(9);
    }

    static void pattern31(int n) {
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row < n -1; row++) {
            for (int col = 0; col < n -1; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row-2, n - col-2));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}