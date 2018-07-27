Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==0) return 0;
        int []dp = new int [nums.length];
        int result =1;
        for (int i=0; i<nums.length; i++) {
            dp[i]=1;
        }
        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            if (dp[i]>result) result=dp[i];
        }
        return result;
    }
}