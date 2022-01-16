package January2022;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int[] left = new int[seats.length];
        int index = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) index = i;
            if (seats[i] == 0) {
                left[i] = index;
            }
        }
        // The below two for loops can be combined into one
        int[] right = new int[seats.length];
        index = seats.length - 1;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) index = i;
            if (seats[i] == 0) {
                right[i] = index;
            }
        }
        int max = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) continue;
            if (i == 0) {
                max = Math.max(max, right[i] - i);
            } else if (i == seats.length - 1) {
                max = Math.max(max, i - left[i]);
            } else {
                max = Math.max(Math.min(right[i] - i, i - left[i]), max);
            }
        }
        return max;
    }
}
