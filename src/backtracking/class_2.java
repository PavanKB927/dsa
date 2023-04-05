package backtracking;

public class class_2 {
    public static void main(String[] args) {
        //System.out.println("subset counts :"+sumOfSubset(new int[]{1,1,2,5,6,3},0,0,9));
        System.out.println("rat maze : "+ratMaze(new int[][]{{1,0,0,0},{0,0,1,0},{0,0,0,0},{0,0,0,0}},2,3,0,1));
    }

    // count the sum of subsets which are equal to k
    public static int sumOfSubset(int[] arr,int i,int currentSum, int k){
        if(i == arr.length){
            if(currentSum == k){
                return 1;
            }
            return 0;
        }
        if(currentSum > k){
            return 0;
        }

        int x = sumOfSubset(arr,i+1,currentSum+arr[i],k);
        int y = sumOfSubset(arr,i+1,currentSum,k);
        return x+y;
    }

    // Rat and the maze
    public static int ratMaze(int[][] matrix,int n,int m,int x,int y){
       if(x == n-1 &&  y == m-1){
           return 1;
       }
       if(x < 0 || x == matrix.length || y < 0 || y == matrix.length){
           return 0;
       }
       if(matrix[x][y] == 1 || matrix[x][y] == 2){
           return 0;
       }
       matrix[x][y] = 2;
       return (ratMaze(matrix,n,m,x-1,y) + ratMaze(matrix,n,m,x+1,y) +
               ratMaze(matrix,n,m,x,y+1)+ ratMaze(matrix,n,m,x,y-1)) ;

    }
}
