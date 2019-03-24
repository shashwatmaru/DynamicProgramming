import java.util.ArrayList;
import java.util.List;

public class BreakWordWithDP {

           public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean T[][] = new boolean[n][n];
            /*
            Below forloop is used to fill the DP table with false for all the boxes where col < row.
             */
            for(int i=0; i<n;i++){
                for(int j=0;j<i;j++){
                    T[i][j]=false;
                }
            }

            /*
            This is the main logic, It will be used to fill the DP table, where l will make n iterations,
            And inner loop is from combination of letter like when i=0, we will take one element from the string,
            for i=1, we will take 2 element and so on.
            J holds the last element to be selected from string.
            And we will break in this way all the combination and check if it is present in the dict or not.
            If it is there then we will select that current box to True, if not then we wwill split the i and j
            with k to use subproblem to know the current answer.
             */
            for(int l=0;l<n;l++){
                for(int i=0;i<n-l;i++){
                    int j = l+i;
                    String str = s.substring(i,j+1);
                    if(wordDict.contains(str)){
                        T[i][j]=true;
                        continue;
                    }
                    else{
                        for(int k=i+1;k<=j;k++){
                            if(T[i][k-1] && T[k][j]){
                                T[i][j]=true;
                            }
                        }
                    }
                }
            }
            //the last element of row 0 would let us know if string can be break using dict.
            return T[0][n-1];

        }

        public static void main(String[] args){
               BreakWordWithDP breakWord = new BreakWordWithDP();
               List<String> dict = new ArrayList<>();
               dict.add("leet");
               dict.add("code");
               String s = "leetcode";
               System.out.println(breakWord.wordBreak(s,dict));
        }
}
