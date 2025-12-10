public class Exercise4c_FloydHeapify {

    public static void floydHeapify(int[] arr, int n, int i) {
        int value = arr[i];
        int start = i;

        // Phase 1: descend
        while (2 * i + 1 < n) {
            int left = 2 * i + 1;
            int right = left + 1;
            int largerChild = left;

            if (right < n && arr[right] > arr[left]) largerChild = right;

            arr[i] = arr[largerChild];
            i = largerChild;
        }

        // Phase 2: bubble up
        while (i > start) {
            int parent = (i - 1) / 2;
            if (value <= arr[parent]) break;
            arr[i] = arr[parent];
            i = parent;
        }
        arr[i] = value;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        floydHeapify(arr, arr.length, 0);
        for (int num : arr) System.out.print(num + " ");
    }
}
