package BinarySearch;

import java.util.Random;

public class WeightedRandomPick {

    private int[] prefix;
    private int total;
    private Random rand = new Random();

    public WeightedRandomPick(int[] weights) {
        prefix = new int[weights.length];
        prefix[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            prefix[i] = prefix[i - 1] + weights[i];
        }
        total = prefix[prefix.length - 1];
    }

    public int pickIndex() {
        int target = rand.nextInt(total) + 1;
        int left = 0, right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefix[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
