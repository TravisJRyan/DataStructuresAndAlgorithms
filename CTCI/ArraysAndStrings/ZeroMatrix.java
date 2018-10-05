/*
    1.8 Zero Matrix - Write an algorithm such that if an element in an MxN matrix is 0,
    its entire row and column are set to 0
*/

public class ZeroMatrix{

    public static void main(String[] args){
        int[][] simpleMatrixNoZero = { //  Should be unchanged, no zeroes in the matrix
                { 1, 2, 3 }, 
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] simpleMatrixZero = { // Should have one column and row changed
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 0, 9 },
                { 1, 2, 8 }
        };
        int[][] simpleMatrixTwoZeroes = { // Should have two columns and rows changed
                { 1, 0, 3 , 4},
                { 4, 5, 6 , 9},
                { 7, 8, 9 , 0},
                { 2, 1, 9, 5}
        };

        System.out.println("\n=================\n");
        printMatrix(zeroMatrix(simpleMatrixNoZero));
        System.out.println("\n=================\n");
        printMatrix(zeroMatrix(simpleMatrixZero));
        System.out.println("\n=================\n");
        printMatrix(zeroMatrix(simpleMatrixTwoZeroes));
        System.out.println("\n=================\n");
    }

    // Checks for a zero, then calls helper methods to zero out its column and row in a copy of the original, then return copy
    // O(2n^2) space - must copy the original matrix
    // O(N*M) time - must iterate through the entire matrix. This can't be improved by a non-constant factor.
    public static int[][] zeroMatrix(int[][] inputMatrix){
        int[][] inputMatrixCopy = new int[inputMatrix.length][inputMatrix[0].length]; // copy original array
        for(int i = 0; i < inputMatrixCopy.length; i++){ // Must copy original elements into new array
            for(int j = 0; j < inputMatrixCopy[i].length; j++){
                inputMatrixCopy[i][j] = inputMatrix[i][j];
            }
        }
        for(int i = 0; i < inputMatrix.length; i++){ // check original array for zeroes
            for(int j = 0; j < inputMatrix[i].length; j++){
                if(inputMatrix[i][j]==0){
                    zeroRow(inputMatrixCopy, i); // zero out proper row and columns on the copy array
                    zeroColumn(inputMatrixCopy, j);
                }
            }
        }
        return inputMatrixCopy; // return the copy with the zeroes added
    }

    // Helper method to zero out a row
    public static void zeroRow(int[][] inputMatrix, int rowNumber){
        for(int i = 0; i < inputMatrix[rowNumber].length; i++)
            inputMatrix[rowNumber][i] = 0;
    }

    // Helper method to zero out a column
    public static void zeroColumn(int[][] inputMatrix, int columnNumber){
        for(int i = 0; i < inputMatrix.length; i++){
            inputMatrix[i][columnNumber] = 0;
        }
    }

    // Auxillary method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

}