/*
    8.2 Robot In A Grid - Imagine a robot sitting in the upper left corner of a grid with r rows
    and c columns. The robot can only move in two directions: right and down, but certain cells are "off limits" such
    that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
    the bottom right.
*/

public class RobotInGrid{
    public static void main(String[] args){
        int[][] grid = {
            {0,0,1,0,0,0},
            {0,0,1,0,0,0},
            {0,0,0,0,0,0},
            {0,1,1,0,1,0},
            {1,0,0,0,1,0}
        };
        findPath(grid);
        /*
            Output:
            Down Down Right Right Right Right Right Down Down
            Down Right Down Right Right Right Right Down Down
            Right Down Down Right Right Right Right Down Down
        */
    }

    public static void findPath(int[][] grid){
        String pathFound = "";
        System.out.println("Printing all paths: ");
        findPath(grid, 0, 0, pathFound);
    }

    // O(2^(N+M)) time because of branching 2 and depth of solution N+M
    // recursive solution stops once out of bounds or once a wall has been hit
    public static void findPath(int[][] grid, int i, int j, String pathFound){
        if(i==grid.length-1 && j==grid[i].length-1){ // path found
            System.out.println(pathFound);
        } 
        if(i >= grid.length || j >= grid[i].length || grid[i][j] == 1)
            return;
        else{
            findPath(grid, i+1, j, pathFound+"Down ");
            findPath(grid, i, j+1, pathFound+"Right ");
        }
    }

}