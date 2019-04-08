public class RegularExpressionDynamicProgramming {
    public boolean matchRegex(char[] str, char[] pattern){

        boolean[][] dp = new boolean[str.length+1][pattern.length+1];
        dp[0][0]=true;
        for(int i=1;i<dp[0].length;i++){
            if(pattern[i-1]=='*'){
                dp[0][i]=dp[0][i-2];
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){

                if(pattern[j-1] == '.' || str[i-1]==pattern[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                if(pattern[j-1]=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(pattern[j-2]=='.' || pattern[j-2]==str[i-1]){
                        dp[i][j]= dp[i][j] | dp[i-1][j];
                    }
                }
                else
                    dp[i][j]=false;
            }
        }

        return  dp[str.length][pattern.length];
    }

    public static void main(String[] args){
        RegularExpressionDynamicProgramming regularExpressionDynamicProgramming = new RegularExpressionDynamicProgramming();
        System.out.println("TESTCASE1: "+regularExpressionDynamicProgramming.matchRegex("Shashwat".toCharArray(),"Shashwat".toCharArray()));
        System.out.println("TESTCASE2: "+regularExpressionDynamicProgramming.matchRegex("Shashwa".toCharArray(),"Shashwat*a*b*".toCharArray()));
        System.out.println("TESTCASE3: "+regularExpressionDynamicProgramming.matchRegex("".toCharArray(),"a*b*".toCharArray()));
        System.out.println("TESTCASE4: "+regularExpressionDynamicProgramming.matchRegex("abbbbccc".toCharArray(),"a*ab*bbbbc*".toCharArray()));
        System.out.println("TESTCASE5: "+regularExpressionDynamicProgramming.matchRegex("abbbbccc".toCharArray(),"aa*bbb*bbbc*".toCharArray()));
        System.out.println("TESTCASE6: "+regularExpressionDynamicProgramming.matchRegex("abbbbccc".toCharArray(),".*bcc".toCharArray()));
        System.out.println("TESTCASE7: "+regularExpressionDynamicProgramming.matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println("TESTCASE8: "+regularExpressionDynamicProgramming.matchRegex("abbbbccc".toCharArray(),".*bcc*".toCharArray()));
        System.out.println("TESTCASE9: "+regularExpressionDynamicProgramming.matchRegex("aaa".toCharArray(),"ab*a*c*a".toCharArray()));
        System.out.println("TESTCASE10: "+regularExpressionDynamicProgramming.matchRegex("aa".toCharArray(), "a*".toCharArray()));
    }
}
