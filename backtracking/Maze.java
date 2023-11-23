package backtracking;

import java.util.Arrays;

public class Maze {

    public static void main(String[] args) {
        System.out.println(count(3,3));
//        path("", 3, 3);
        boolean[][] board = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
//        pathWithObstacles("", board, 0, 0);
//        allPathWithObstacles("", board, 0, 0);
        int[][] matrix = new int[board.length][board[0].length];
        pathMatrix("", board, 0, 0, matrix, 1);
    }

    static int count(int r, int c) {
        if(r == 1 || c == 1){
            return 1;
        }

        int left = count(r-1, c);
        int right = count(r, c -1);
        return left+right;
    }

    static void path(String path, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(path);
            return;
        }

        if(r>1){
            path(path+"D", r-1, c);
        }
        if(c>1){
            path(path+"R", r, c-1);
        }
    }

    static void pathWithObstacles(String path,boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length -1) {
            System.out.println(path);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r < maze.length - 1){
            pathWithObstacles(path+"D", maze,r+1, c);
        }
        if(c < maze[0].length -1){
            pathWithObstacles(path+"R", maze, r, c+1);
        }
    }

    static void allPathWithObstacles(String path,boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length -1) {
            System.out.println(path);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        // this block is considered in path
        maze[r][c] = false;

        if(r < maze.length - 1){
            allPathWithObstacles(path+"D", maze,r+1, c);
        }
        if(c < maze[0].length -1){
            allPathWithObstacles(path+"R", maze, r, c+1);
        }
        if(r > 0){
            allPathWithObstacles(path+"U", maze, r-1, c);
        }
        if(c > 0){
            allPathWithObstacles(path+"L", maze, r, c-1);
        }

        //line is executed after fn is returned
        maze[r][c] = true;
    }

    static void pathMatrix(String path, boolean[][] maze, int r, int c, int[][] m, int step){

        if(r == maze.length - 1 && c == maze[0].length - 1) {
            // m[r][c] = step -- Executes when target(2,2) is found, which makes it the last step.
            m[r][c] = step;
            for (int[] arr: m) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path);
            System.out.println();
            return;
        }

        if(!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        m[r][c] = step;

        if (r < maze.length -1) {
            pathMatrix(path + "D", maze, r+1, c, m, step +1);
        }

        if( c < maze[0].length - 1 ){
            pathMatrix(path + "R", maze, r, c+1, m, step + 1);
        }

        if (r > 0) {
            pathMatrix(path + "U", maze, r - 1, c, m, step + 1);
        }

        if( c > 0){
            pathMatrix(path + "L", maze, r, c -1, m, step + 1);
        }

        maze[r][c] = true;
        m[r][c] = 0;
    }
}
