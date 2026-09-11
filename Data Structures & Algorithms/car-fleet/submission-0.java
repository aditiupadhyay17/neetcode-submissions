class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store {position, speed}
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position from closest to target
        // to farthest from target
        java.util.Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;

        // Time of the fleet currently ahead
        double lastTime = 0.0;

        for (int i = 0; i < n; i++) {

            int pos = cars[i][0];
            int spd = cars[i][1];

            double time = (double) (target - pos) / spd;

            /*
             * If this car takes MORE time than the fleet ahead,
             * it cannot catch that fleet.
             *
             * Therefore, it forms a new fleet.
             */
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }

            /*
             * If time <= lastTime:
             *
             * This car catches the fleet ahead before or exactly
             * at the destination.
             *
             * So it becomes part of that fleet.
             */
        }

        return fleets;
    }
}