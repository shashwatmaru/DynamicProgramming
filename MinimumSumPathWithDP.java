/*
@Author Shashwat Maru
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumSumPathWithDP {
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int T[][] = new int[m][n];
            T[0][0]=grid[0][0];
            for(int i=1;i<n;i++){
                T[0][i]=T[0][i-1]+grid[0][i];
                //         System.out.println("i "+i+"  Matrix: "+T[0][i]);
            }

            for(int i=1;i<m;i++){
                T[i][0]=T[i-1][0]+grid[i][0];
                //       System.out.println("i "+i+"  Matrix: "+T[i][0]);

            }

            for(int i=1;i<m;i++){
                for(int j=1;j<n;j++){
                    T[i][j]= grid[i][j]+ Math.min(T[i-1][j],T[i][j-1]);
                    //         System.out.println("i & j"+i+" "+j+" Matrix: "+T[i][j]);
                }
            }

            return T[m-1][n-1];
        }
    public  static void main(String[] args){
            int arr[][] = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumSumPathWithDP msp = new MinimumSumPathWithDP();
        System.out.println(msp.minPathSum(arr));

    }
}
