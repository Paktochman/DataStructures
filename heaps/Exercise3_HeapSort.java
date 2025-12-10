public class Exercise3_HeapSort {

    public static void heapifyDown(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyDown(arr, n, largest);
        }
    }

    public static void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(arr, n, i);
        }
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapifyDown(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 5, 2, 4};
        heapSort(arr);
        for (int num : arr) System.out.print(num + " ");
    }
}
