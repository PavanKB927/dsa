package dynamicProgramming;

public class class_2 {
    public static void main(String[] args) {
        System.out.println("Unique paths >> "+uniquePathsWithObstacles(new int[][]{{0,1}}));
    }

    /* Unique paths in the grid
    * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
    * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
    * Now consider if some obstacles are added to the grids. How many unique paths would there be?
    * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    * */
    public static int uniquePathsWithObstacles(int[][] A) {
        int i = 0,j = 0, n = A.length, m = A[0].length;
        int[][] dp =  new int[n][m];
        for(int k = 0; k<n;k++){
            for(int l=0;l<m;l++){
                dp[k][l] = -1;
            }
        }
        return paths(A,i,j,dp);
    }
    public static int paths(int[][] A,int i,int j, int[][] dp){
        if(i == A.length-1 && j == A[0].length-1 && A[i][j] != 1){ return 1; }
        if(i == A.length || j == A[0].length) { return 0; }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(A[i][j] == 1){
            dp[i][j] = 0;
        }else {
            int right = paths(A,i,j+1,dp);
            int top = paths(A,i+1,j,dp);
            dp[i][j] = right + top;
        }
        return dp[i][j];
    }

    /* N Digit Numbers
    * Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
    * Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
    * Since the answer can be large, output answer modulo 1000000007
    * */

}
