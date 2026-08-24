class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] nums1 = new int[n];

        int mul = 1;

        for (int i = 0; i < n; i++) {
            nums1[i] = mul;
            mul *= nums[i];
        }

        mul = 1;

        for (int i = n - 1; i >= 0; i--) {
            nums1[i] *= mul;
            mul *= nums[i];
        }

        return nums1;
    }
}