/*You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

/*consider sum of the elements with + as M, sum of those with - as N
  then M+N = SUM; M-N = S
  2M=S+SUM so M must be even
  Next find how to consist of M in the input array will be the solution
  which obviously applies DP
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i< nums.length; i++) {
            sum= sum+ nums[i];
        }
        if ( sum < S || (sum+S)%2!=0 ) {
            return 0;
        }
        int target = (sum + S)/2;        
        int []dp = new int[target+1];
        dp[0]=1;
        for (int i= 0; i< nums.length; i++){
            for (int j= target; j>= nums[i]; j--) {
                dp[j]= dp[j]+ dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
