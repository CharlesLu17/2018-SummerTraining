Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

class Solution {
    public void setZeroes(int[][] matrix) {
        int row[] =new int [matrix.length];
        int column[] =new int [matrix[0].length];
        Arrays.fill(row,1);
        Arrays.fill(column,1);
        for (int i=0; i<matrix.length;i++) {
            for (int j=0; j<matrix[0].length;j++) {
                if (matrix[i][j]==0) {
                    row[i]=0;
                    column[j]=0;
                }
            }
        }
        for (int i=0; i<row.length;i++) {
            if (row[i]==0) {
                for (int j=0; j<matrix[0].length;j++) {                
                    matrix[i][j]=0;
                }
            }
        }
        for (int i=0; i<column.length;i++) {
            if (column[i]==0) {
                for (int j=0; j<matrix.length;j++) {
                    matrix[j][i]=0;
                }
            }
        }
    }
}
