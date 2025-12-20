package BinarySearch;

public class CuttingWood {

    public static int maxHeight(int[] trees, int k) {
        int left = 0, right = 0;
        for (int h : trees) right = Math.max(right, h);

        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long wood = 0;
            for (int h : trees) {
                if (h > mid) wood += (h - mid);
            }

            if (wood >= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
