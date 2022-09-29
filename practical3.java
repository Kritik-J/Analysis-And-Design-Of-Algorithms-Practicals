// Sort the given array using Insertion sort

class practical3 {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 15, 45, 31, 42, 11 };
        System.out.println("Array before sorting:");
        printArray(arr);
        System.out.println();
        insertionSort(arr);
        System.out.println("Array after sorting:");
        printArray(arr);
    }
}