public class Exercise4a_IterativeHeapify {

    public static void heapifyDownIterative(int[] arr, int n, int i) {
        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[left] > arr[largest]) largest = left;
            if (right < n && arr[right] > arr[largest]) largest = right;

            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i = largest; // move down
            } else {
                break; // heap property satisfied
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        heapifyDownIterative(arr, arr.length, 0);
        for (int num : arr) System.out.print(num + " ");
    }
}
