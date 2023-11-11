package recursion;

public class Triangle {

    public static void main(String[] args) {
        triangle2(4, 0);
    }

    static void triangle(int r, int col) {
        if (r == 0) {
            return;
        }

        if( col < r) {
            System.out.print("*");
            triangle(r, col + 1);
        } else {
            System.out.println();
            triangle(r -1, 0);
        }
    }

    static void triangle2(int r, int col) {
        if (r == 0) {
            return;
        }

        if( col < r) {
            triangle2(r, col + 1);
            System.out.print("*");
        } else {
            triangle2(r -1, 0);
            System.out.println();
        }
    }
}
