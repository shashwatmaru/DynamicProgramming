/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were
broken into on the same night. Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.
Example 1:
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
             
 */


public class MaxSumWithoutAdjacentElementInCircularArray {
        public int rob(int[] nums){
            int len = nums.length;
            if(len == 0){
                return 0;
            }
            if(len ==1){
                return nums[0];
            }

            int excl = 0;
            int incl = nums[1];
            for(int i=2;i<len;i++){
                int newIncl = excl +nums[i];
                excl = incl;
                incl = Math.max(incl, newIncl);
            }

            int excl1 = 0;
            int incl1 = nums[len-2];
            for(int j=len-3;j>=0;j--){
                int newIncl1= nums[j]+ excl1;
                excl1 = incl1;
                incl1 = Math.max(incl1, newIncl1);
            }

            return Math.max(incl,incl1);
        }

        public static void main(String[] args){
            int arr[] = {1,2,3,1};
            MaxSumWithoutAdjacentElementInCircularArray maxSum = new MaxSumWithoutAdjacentElementInCircularArray();
            System.out.println(maxSum.rob(arr));
        }
}
