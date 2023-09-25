package Array;

/**
 * @program: java_algo
 * @description: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).  You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * @author: Ze QIN
 * @create: 2023-09-25 08:30
 **/
public class RotateImage {

    public void rotate(int[][] matrix) {
        int l = matrix.length;
        for (int  i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < l; i++) {
            for (int j = 0; j < l/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][l-1-j];
                matrix[i][l-1-j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};

        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);

        for (int  i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
