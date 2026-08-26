class Solution {
    public int search(int[] nums, int target) {
        int index = 0;
        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target > nums[mid]){
                l = mid + 1;
            }
            else if(target == nums[mid]){
                index = mid;
                return index;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    }
}
