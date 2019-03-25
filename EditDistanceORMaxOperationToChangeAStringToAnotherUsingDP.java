/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */

public class EditDistanceORMaxOperationToChangeAStringToAnotherUsingDP {
        public int minDistance(String word1, String word2) {

            char[] wordChar1 = word1.toCharArray();
            char[] wordChar2 = word2.toCharArray();

            int len1 = wordChar1.length;
            int len2 = wordChar2.length;
            if(len1 + len2 == 0){
                return 0;
            }
            if(len1 +len2 == 1){
                return 1;
            }
            int T[][] = new int[len1+1][len2+1];

            for(int i=0;i<len1;i++){
                T[i][0]=i;
            }

            for(int i=0;i<=len2;i++){
                T[0][i]=i;
            }

            for(int i=1;i<=len1;i++){
                for(int j=1;j<=len2;j++){
                    if(wordChar1[i-1] == wordChar2[j-1]){
                        T[i][j]=T[i-1][j-1];
                    }
                    else{
                        T[i][j]= 1 + Math.min(T[i-1][j-1], Math.min(T[i-1][j],T[i][j-1]));
                    }
                }
            }

            return T[len1][len2];
        }
    public static void main(String [] args){
        String s1 ="horse";
        String s2="ros";
        EditDistanceORMaxOperationToChangeAStringToAnotherUsingDP edit = new EditDistanceORMaxOperationToChangeAStringToAnotherUsingDP();
        System.out.println(edit.minDistance(s1,s2));
    }
}
