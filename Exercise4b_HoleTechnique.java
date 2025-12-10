public class Exercise4b_HoleTechnique {

    public static void heapifyDownHole(int[] arr, int n, int i) {
        int value = arr[i];
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < n && arr[left] > value) largest = left;
            if (right < n && arr[right] > arr[largest]) largest = right;

            if (largest != i) {
                arr[i] = arr[largest]; // move child up
                i = largest;
            } else {
                break;
            }
        }
        arr[i] = value;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        heapifyDownHole(arr, arr.length, 0);
        for (int num : arr) System.out.print(num + " ");
    }
}
