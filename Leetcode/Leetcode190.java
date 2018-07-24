/*输入: 43261596
输出: 964176192
解释: 43261596 的二进制表示形式为 00000010100101000001111010011100 ，
     返回 964176192，其二进制表示形式为 00111001011110000010100101000000 。
*/
     
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result =0;
        for (int i=1; i<=32; i++) {
            if ((n&1 )==1)  // if last digit is 1, result +1 and move n and result with 1 step
                result =result+1;
                n= n >> 1;
                if (i !=32) // no need to move 32 times
                result= result << 1;
        }
        return result;
    }
}
