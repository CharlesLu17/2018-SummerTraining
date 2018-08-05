class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int gap = 0;
        int sum = 0;
        if(nums.length < 3)
        {
            return -1;
        }
        sum = nums[0]+nums[1]+nums[2];
        gap = target > sum ? (target-sum):(sum-target);
        for(int begin = 0 ; begin < nums.length-2; begin++)
        {
            if(begin > 0 && nums[begin] == nums[begin-1])
            {
                begin++;
                continue;
            }
            int pos1 = begin+1;
            while(pos1 < nums.length-1)
            {
                int pos2 = pos1+1;
                while(pos2 < nums.length)
                {
                    int tmpsum = nums[begin] + nums[pos1]+nums[pos2];
                    if(tmpsum == target)
                    {
                        return target;
                    }
                    else if(Math.abs(tmpsum - target) < gap)
                    {
                        sum = tmpsum;
                        gap = Math.abs(tmpsum - target);
                    }
                    pos2++;
                }
                pos1++;
            }
        }
        return sum;
    }
}
