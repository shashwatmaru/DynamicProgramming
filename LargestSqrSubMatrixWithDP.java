import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;




public class LargestSqrSubMatrixWithDP {
        /*
         * Complete the 'largestMatrix' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */

        public static int largestMatrix(List<List<Integer>> arr) {
            // Write your code here
            int rows = arr.size();
            int cols = arr.get(0).size();
            int[][] sub = new int[rows][cols];

            //Initializing rows of the memoization array
            for(int i=0;i<rows;i++){
                sub[i][0] = arr.get(i).get(0);
            }

            //Initializing columns of the memoization array
            for(int i=0;i<cols;i++){
                sub[0][i] = arr.get(0).get(i);
            }

        /*
        In each iteration we try to find the max size of square matrix having its bottom right corner at that position.
        If the value at the current position in the input matrix is 0
            then, there cannot be a square having its bottom right most corner at this position.
        else,
            if the current element in the input matrix is 1, then a square matrix can end here.
            now the max size square of all 1s will be:
                                                     min(diagonal element, left element, top element) of memoization matrix.
         Example input matrix:
         1,1,1
         1,1,0
         1,0,1

        MEMOIZATION MATRIX:
         1,1,1
         1,2,0
         1,0,1
        */
            for(int i=1; i<rows;i++){
                for(int j=1;j<cols;j++){
                    if(arr.get(i).get(j)==1){
                        sub[i][j] = Math.min(sub[i-1][j-1],Math.min(sub[i][j-1],sub[i-1][j]))+1;
                    }
                    else{
                        sub[i][j]=0;
                    }
                }
            }

        /*
        Now iterating thru the memoization matrix, and finding the max element in it.
        and returning it in maxSize.
        NOTE: maxsize could be found while we were populating the memoization matrix.
        */
            int maxSize=0;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(sub[i][j]>maxSize){
                        maxSize = sub[i][j];
                    }
                }
            }

            return maxSize;

        }


        public static void main(String[] args) throws IOException {

         /*   int arrRows =
            int arrColumns =
         */
            List<Integer> arr1 = new ArrayList<>();
            arr1.add(1); arr1.add(1);arr1.add(1);arr1.add(1);arr1.add(1);
            List<Integer> arr2 = new ArrayList<>();
            arr2.add(1);arr2.add(1);arr2.add(1);arr2.add(0);arr2.add(0);
            List<Integer> arr3 = new ArrayList<>();
            arr3.add(1);arr3.add(1);arr3.add(1);arr3.add(0);arr3.add(0);
            List<Integer> arr4 = new ArrayList<>();
            arr4.add(1);arr4.add(1);arr4.add(1);arr4.add(0);arr4.add(0);
            List<Integer> arr5 = new ArrayList<>();
            arr5.add(1); arr5.add(1);arr5.add(1);arr5.add(1);arr5.add(1);

            List<List<Integer>> arr = new ArrayList<>();
            arr.add(arr1);arr.add(arr2);arr.add(arr3);arr.add(arr4);arr.add(arr5);
            int result = LargestSqrSubMatrixWithDP.largestMatrix(arr);
            System.out.println("Result of submatric array is: "+result);
        }
    }
