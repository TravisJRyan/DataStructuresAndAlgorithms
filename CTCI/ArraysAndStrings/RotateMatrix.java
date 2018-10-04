
/* 
    1.7 Rotate Matrix - Given an image represented by an N*N matrix, where each pixel is 4 bytes, 
    write a method to rotate the image by 90 degrees. Can you do this in place? 
*/

import java.lang.*;

public class RotateMatrix {
    public static void main(String[] args) {
        // Simple, average case test matrix
        int[][] inputSimpleMatrix = { { 1, 2, 3 }, // 7, 4, 1
                { 4, 5, 6 }, // 8, 5, 2
                { 7, 8, 9 } // 9, 6, 3
        };
        printMatrix(inputSimpleMatrix); // original matrix for comparison
        System.out.println("\n");
        printMatrix(rotateMatrixNotInPlace(inputSimpleMatrix)); // testing rotation (not in place)
        System.out.println("\n");
        printMatrix(rotateMatrixInPlace(inputSimpleMatrix)); // testing rotation (not in place)

        System.out.println("\n==================\n");

        // A larger test case
        int[][] inputLargerMatrix = { 
            { 1, 2, 3, 4 }, 
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 }, 
            { 13, 14, 15, 16 } 
        };

        printMatrix(inputLargerMatrix);
        System.out.println("\n");
        printMatrix(rotateMatrixNotInPlace(inputLargerMatrix));
        System.out.println("\n");
        printMatrix(rotateMatrixInPlace(inputLargerMatrix)); // testing rotation (not in place)

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

    // Simple mapping of old values to new ones in a new 2D array
    // O(N^2) time - must access every matrix element once, can't do any better
    // O(2*N^2) space - a new matrix is needed (not in place) for this solution
    // 90 Degree Rotation Relationship: [0,0] -> [0,2]; [0,1] -> [1,2]; [0,2] ->
    // [2,2] etc.
    public static int[][] rotateMatrixNotInPlace(int[][] inputMatrix) {
        int N = inputMatrix.length;
        int[][] newMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMatrix[j][N - 1 - i] = inputMatrix[i][j];
            }
        }
        return newMatrix;
    }

    // Reverse every row, and then swap reflections across the left-right upper diagonal to produce rotation
    // O(2*N^2) time - must access every element in the array twice (reversing and reflecting)
    // O(N^2) space - no additional space is created
    public static int[][] rotateMatrixInPlace(int[][] inputMatrix) {
        int N = inputMatrix.length;
        for(int i = 0; i < N; i++){ // First reverse every row [0, 1, 2] - > [2, 1, 0]
            for(int j = 0; j < N/2; j++){
                int temp = inputMatrix[i][j];
                inputMatrix[i][j] = inputMatrix[i][N-1-j];
                inputMatrix[i][N-1-j] = temp;
            }
        }
        for(int i = 0; i < N; i++){ // Then swap reflexive elements across diagonal
            for(int j = 0; j < N-i; j++){
                int temp = inputMatrix[i][j];
                inputMatrix[i][j] = inputMatrix[N-1-j][N-1-i];
                inputMatrix[N-1-j][N-1-i] = temp;
            }
        }
        return inputMatrix;
    }
}