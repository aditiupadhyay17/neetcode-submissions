class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        // Stack stores indices
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {

            // Current temperature is warmer
            // than the temperature at the stack top
            while (top >= 0 &&
                   temperatures[i] > temperatures[stack[top]]) {

                int prevDay = stack[top--];

                result[prevDay] = i - prevDay;
            }

            // Put current day into stack
            stack[++top] = i;
        }

        return result;
    }
}