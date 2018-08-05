class Solution {
    public List<List<Integer>> threeSum(int[] nums)  {       
        int split=0;
        List result= new ArrayList();
        if (nums.length<=2 || nums==null ) return result;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            int begin=i+1;
            int end=nums.length-1;
            if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			while (begin < end) {
				int sum = nums[i] + nums[begin] + nums[end];
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[begin]);
					list.add(nums[end]);
					result.add(list);
					begin++;
					end--;
					while (begin < end && nums[begin] == nums[begin - 1])
						begin++;
					while (begin < end && nums[end] == nums[end + 1])
						end--;
				} else if (sum > 0)
					end--;
				else
					begin++;
			}
		}
		return result;
    }
}
