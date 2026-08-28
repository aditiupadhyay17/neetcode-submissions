class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        return longest(nums, 0);
    }
    public int longest(int[] nums, int index){
        int maxLength = 1;
        int currLen = 1;
        for(int i = index+1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1] + 1) currLen++;
            else{
                maxLength = Math.max(maxLength, currLen);
                currLen = 1;
            }
        }
        maxLength = Math.max(maxLength, currLen);
        return maxLength;
    }
}
