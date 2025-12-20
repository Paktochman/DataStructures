package BinarySearch;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);

        int m = a.length, n = b.length;
        int left = 0, right = m;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int minRightA = (i == m) ? Integer.MAX_VALUE : a[i];

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : b[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(maxLeftA, maxLeftB) +
                            Math.min(minRightA, minRightB)) / 2.0;
                else
                    return Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return 0.0;
    }
}
