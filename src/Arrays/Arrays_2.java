package Arrays;

import java.util.Arrays;
import java.util.HashMap;

//June 10th 2022
public class Arrays_2 {
    public static void main(String[] args) {
        // rotateMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        // subMatrixSum(new int[][]{{5,17,100,11},{0,0,2,8}},new int[]{1,1},new int[]{1,4},new int[]{2,2},new int[]{2,4});
        // generateMatrix(4);
        //MinimumSwaps(new int[]{2255, 6353, 7832, 9990, 516, 9853, 7018, 3337, 3008, 6158, 679, 2954, 2024, 2807, 1944, 6596, 7992, 2942, 9355, 788, 65, 2966, 9276, 1064, 1112, 6197, 4615, 8140, 30, 478, 5360, 7585, 8853, 9481, 1099, 8781, 9514, 4603, 8209, 7455, 5225, 6740, 4734, 4942, 4475, 4995, 4086, 6448, 1408, 2446, 4675, 92, 4942, 7421, 6302, 8226, 431, 2463, 5762, 2681, 1877, 2121, 3450, 5930, 9743, 5045, 9977, 906, 9293, 5441, 6825, 3244, 7021, 3910, 7866, 1013, 8227, 7926, 9226, 8710, 7088, 7761, 3413, 4200, 1671, 4526, 9890, 9594, 257, 3212, 8341, 9641, 2060, 5072, 2776, 4084, 4988, 501, 4304, 3685, 5424, 5713, 7920, 3115, 187, 3915, 3971, 7755, 8802, 4439, 8104, 5610, 5007, 1348, 4449, 9993, 17, 6395, 5539, 3415, 6500, 9899, 9049, 8197, 1419, 7112, 5823, 4739, 7975, 6915, 5852, 4072, 1694, 4353, 8867, 7362, 3410, 8415, 4060, 1353, 2342, 1712, 9038, 5421, 5772, 9291, 1611, 2822, 7927, 9644, 9236, 6052, 9592, 2206, 28, 3772, 1694, 2085, 6137, 4683, 655, 4604, 4979, 1948, 661, 9333, 6319, 257, 8146, 5744, 3533, 6508, 6792, 338, 5507, 4191, 7116, 8174, 1577, 1045, 3337, 86, 5667, 9341, 1606, 558, 7382, 8198, 7954, 225, 7154, 7780, 1290, 1269, 9782, 5909, 6713, 3605, 5672, 8661, 6988, 4669, 1954, 7852, 5580, 5893, 6242, 9970, 2892, 4471, 4272, 3072, 8475, 9925, 8930, 442, 5873, 1128, 2204, 2384, 3532, 970, 3543, 448, 4699, 2630, 7742, 1563, 1626, 3552, 3030, 3124, 4535, 650, 5330, 3862, 3799, 3011, 7809, 9538, 4567, 6431, 5775, 6903, 6675, 7459, 5750, 4193, 9102, 3352, 4107, 1483, 7454, 8293, 5044, 9638, 4995, 5558, 9882, 2316, 2614, 9934, 9669, 1486, 762, 4598, 883, 3279, 6893, 1958, 9703, 7636, 5217, 8460, 3711, 2173, 1677, 9273, 1191, 7967, 6001, 9935, 7241, 2552, 4373, 8518, 2801, 3310, 839, 3715, 7410, 2663, 2894, 1335, 8993, 4987, 6888, 4139, 4324, 4024 },1732);
        //solveMinSwapsAsc(new int[]{1, 2, 3, 4, 0});
        //subArrayMatrices(new int[][]{{8, 9, 9, 1, 7},{5, 5, 10, 1, 0},{7, 7, 5, 8, 6},{7, 3, 7, 9, 2},{7, 7, 8, 10, 6}});
        maxSumSquareSubMatrix(new int[][]{{1, 1, 1, 1, 1},{2, 2, 2, 2, 2}, {3, 8, 6, 7, 3},{4, 4, 4, 4, 4},{5, 5, 5, 5, 5}}, 3);
    }

    /* Question: Rotate Matrix 90 degree
    * You are given a n x n 2D matrix A representing an image.
    * Rotate the image by 90 degrees (clockwise).
    * You need to do this in place.
    * Note: If you end up using an additional array, you will only receive partial score.
    * Example :
    * before Rotation:                  After Rotation :
    * 1 2 3                             7 4 1
    * 4 5 6                             8 5 2
    * 7 8 9                             9 6 3
    * */
    public static void rotateMatrix(int[][] A) {
        System.out.println("input : "+Arrays.deepToString(A));
        for(int i=0,k=A.length-1;k>i;i++,k--){
            for(int j=0;j<A[0].length;j++){
                int temp = A[i][j];
                A[i][j] = A[k][j];
                A[k][j] = temp;
            }
        }
        System.out.println("t1 :"+Arrays.deepToString(A));
        for(int i = A.length-1; i>=0;i--){
            for(int j = i;j<A[0].length;j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        System.out.println("t2 :"+Arrays.deepToString(A));

        for(int[] row: A){
            System.out.print(Arrays.toString(row));
        }
    }

    /* Question : Sub-matrix Sum Queries
    * Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
    * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
    * NOTE: Rows are numbered from top to bottom, and columns are numbered from left to right.
    * Sum may be large, so return the answer mod 109 + 7.
    * */
    public static void subMatrixSum(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        System.out.println("input :"+Arrays.deepToString(A));
        int[] ans = new int[B.length];
        int[][] rs = new int[A.length][A[0].length];
        int[][] ps = new int[A.length][A[0].length];
        for(int i = 0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(i == 0 && j == 0 ){
                    rs[i][j] = A[i][j];
                }else if(j == 0){
                    rs[i][j] = A[i][j];
                }else{
                    rs[i][j] = getMod(rs[i][j-1] + A[i][j]);
                }
            }
        }
        System.out.println("row sum :"+Arrays.deepToString(rs));
        for(int i = 0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(i == 0 && j == 0 ){
                    ps[i][j] = rs[i][j];
                }else if(i == 0){
                    ps[i][j] = rs[i][j];
                }else{
                    ps[i][j] = getMod(ps[i-1][j] + rs[i][j]);
                }
            }
        }
        System.out.println("col sum :"+Arrays.deepToString(ps));
        for(int q=0;q<B.length;q++){
            int startI = B[q]-1,endI = C[q]-1;
            int startJ = D[q]-1,endJ = E[q]-1;
            if(startI == 0 && endI == 0){
                ans[q] = ps[startJ][endJ];
            }else{
                int a = startI-1 >= 0? ps[startI-1][endJ]:0;
                int b = endI-1 >=0 ? ps[startJ][endI-1]:0;
                int c = (startI-1 >= 0 && endI-1 >= 0) ? ps[startI-1][endI-1]:0;
                ans[q] = getMod(ps[startJ][endJ] - a - b + c);
            }
        }
        System.out.println("Answer >> "+Arrays.toString(ans));
    }
    private static int getMod(int num) {
        int mod = 1000000007;

        int res = num % mod;

        if(res < 0) {
            return (res + mod) % mod;
        }

        return res;
    }

    /* Question: Spiral Order Matrix
    * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
    * */
    public static void generateMatrix(int A) {
        System.out.println("input :"+A);
        int[][] ans = new int[A][A];
        int val = 1;
        int top = 0;
        int down = A-1;
        int left = 0;
        int right = A-1;
        int dir = 0; // 0 -> | 1 down | 2 <- | 3 up
        while(top <= down && left <= right){
            if(dir == 0){
                for(int i=left;i<=right;i++){
                    ans[top][i] = val;
                    val++;
                }
                top++;
            }else if(dir == 1){
                for(int i=top;i<= down;i++){
                    ans[i][right] = val;
                    val++;
                }
                right--;
            }else if(dir == 2){
                for(int i =right;i>=left;i--){
                    ans[down][i] = val;
                    val++;
                }
                down--;
            }else if(dir == 3){
                for(int i = down;i>=top;i--){
                    ans[i][left] = val;
                    val++;
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        System.out.println("main output : ");
        for(int[] row: ans){
            System.out.println(Arrays.toString(row));
        }
    }

    /* Question: Minimum Swaps
    * Given an array of integers A and an integer B,
    *  find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
    * Note: It is possible to swap any two elements, not necessarily consecutive.
    * */
    public static void MinimumSwaps(int[] A, int B) {
        System.out.println("A :"+Arrays.toString(A));
        System.out.println("B :"+B);
        int minSwaps;
        int val = 0;
        for(int i=0; i<A.length;i++){
            if(A[i] <= B){
                val++;
            }
        }
        System.out.println("val :"+val);
        int badVal = 0,start = 0,end = val;
        for(int i =start;i<end;i++){
            if(A[i] > B){
                badVal++;
            }
        }
        minSwaps = badVal;
        System.out.println("min swaps :"+minSwaps);
        while(end < A.length){
            if(A[start] > B ){
                badVal--;
            }
            if(A[end] > B){
                badVal++;
            }
            minSwaps = Math.min(minSwaps,badVal);
            start++;
            end++;
        }

        System.out.println(" min swaps :"+minSwaps);

       /* int count = 0;
        for(int i =0; i<A.length; ++i){
            if(A[i]<=B)count++;
        }
        int l = 0, r= 0;
        int ans = count;
        int curCount = 0;
        while(r<A.length){
            if(A[r]<=B)curCount++;
            r++;
            if(r-l<count)continue;
            ans = Math.min(ans, count-curCount);
            if(A[l]<=B)curCount--;
            l++;
        }
        System.out.println("ans ::"+ans);*/


    }

    /* Question: Minimum Swaps 2:- for ascending order
    * iven an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
    *  It is allowed to swap any two elements (not necessarily consecutive).
    * Find the minimum number of swaps required to sort the array in ascending order.
    * */
    public static void solveMinSwapsAsc(int[] A) {
        System.out.println("input :"+Arrays.toString(A));
        boolean[] isVisited = new boolean[A.length];
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i =0; i<isVisited.length;i++){
            hashMap.put(i,A[i]);
        }
        System.out.println("hash map :"+Arrays.toString(hashMap.entrySet().toArray()));
        int swap = 0;
        for(int i=0; i<hashMap.size(); i++){
            while(!isVisited[i]){
                isVisited[i] = true;
                if(i == hashMap.get(i)){
                    continue;
                }else{
                    int c = hashMap.get(i);
                    while(!isVisited[c]){
                        isVisited[c] = true;
                        int nextNode = hashMap.get(c);
                        c = nextNode;
                        ++swap;
                    }
                }
            }
        }
        System.out.println("swaps :"+swap);

    }

    /* Question: sum of all Subarray matrices
    * Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
    * */
    public static void subArrayMatrices(int[][] A) {
        int totalSum = 0;
        int n = A.length;
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n; j++){
                totalSum += A[i][j]*((i+1)*(j+1)*(n-i)*(n-j));
            }
        }
        System.out.println("total sum :"+totalSum);
    }

    /* Question : Maximum sum square submatrix
    * Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1,
    *  such that the sum of all the elements in the submatrix is maximum.
    * */
    public static void maxSumSquareSubMatrix(int[][] A, int B) {
        int n = A.length;
        int maxSum = Integer.MIN_VALUE;
        //form prefix sum matrix:
        int[][] ps = new int[n][n];
        formPrefixSum(ps,A,n);
        System.out.println("prefix sum :");
        for(int[] row: ps){
            System.out.println(Arrays.toString(row));
        }

        //initialize topLeft to zero and bottomRight to B
        int r1=0,c1=0,r2 = B-1,c2 = B-1;
        while(c2 < n && r2 < n){
            int sum;
            if(r1 == 0 && c1 ==0){
                sum = ps[r2][c2];
            }else {
                int a = r1-1 >= 0?ps[r1-1][c2]:0;
                int b = c1-1 >= 0?ps[r2][c1-1]:0;
                int c = (r1-1)>=0 && (c1-1) >= 0 ? ps[r1-1][c1-1]:0;
                sum = ps[r2][c2] - a - b + c;
            }
            maxSum = Math.max(maxSum,sum);
            if(c2 < n-1){
                c1++;
                c2++;
            }else if( r2 < n-1){
                r1++;
                r2++;
                c1 = 0;
                c2 = B-1;
            }else{
                break;
            }
        }
        System.out.println("max sum:"+maxSum);
    }

    public static void formPrefixSum(int[][] ps,int[][] A, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j == 0){
                    ps[i][j] = A[i][j];
                }else{
                    ps[i][j] = ps[i][j-1] + A[i][j];
                }
            }
        }
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(i == 0){
                    ps[i][j] = ps[i][j];
                }else{
                    ps[i][j] = ps[i-1][j] + ps[i][j];
                }
            }
        }

    }



}
