Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return subTree(nums, 0, nums.length-1);
}
 
    public TreeNode subTree(int[] nums,int left,int right){
	    if(left>right){
		    return null;
	    }
    	int max=nums[left];
	    int max_index=left;
    	for(int i=left+1;i<=right;i++){
	    	if(nums[i]>max){
		    	max=nums[i];
			    max_index=i;
	    	}
    	}
	    TreeNode root=new TreeNode(max);
	    root.left=subTree(nums, left, max_index-1);
    	root.right=subTree(nums, max_index+1, right);
	    return root;
    }
}