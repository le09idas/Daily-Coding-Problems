//class matrixRotateTest.java

class MatrixOps
{
    public static int[][] greedyRotateClockwise(int[][] matrix, int n)
    {
        int[][] rotated = new int[n][n];

        int k = n - 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                rotated[j][k] = matrix[i][j];
            }
            k--;
        }

        return rotated;
    }

    public static int[][] stingyRotateClockwise(int[][] matrix, int n)
    {
        int[][] rotated = new int[n][n];
         
        return null;
    }
}

class TestApp
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13,14,15,16}};

        for(int i = 0; i < matrix[0].length; i++)
        {
            for(int j = 0; j< matrix[0].length; j++)
            {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }

        int[][] rotated = MatrixOps.greedyRotateClockwise(matrix, matrix[0].length);

        for(int i = 0; i < rotated[0].length; i++)
        {
            for(int j = 0; j< rotated[0].length; j++)
            {
                System.out.print(" " + rotated[i][j]);
            }
            System.out.println("");
        }
    }
}