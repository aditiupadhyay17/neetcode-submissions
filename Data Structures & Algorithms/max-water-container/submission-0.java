class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;

        int maxWater = 0;

        while (left < right) {

            // Width of the container
            int width = right - left;

            // Height is limited by the smaller bar
            int height = Math.min(heights[left], heights[right]);

            // Calculate current area
            int area = width * height;

            // Update maximum
            maxWater = Math.max(maxWater, area);

            // Move the smaller height
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}