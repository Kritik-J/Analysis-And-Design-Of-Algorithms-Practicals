// Linear Time Sort :Counting Sort

public class practical7 {
    static void countSort(int[] arr, int n, int k) {
        int[] count = new int[k + 1];

        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.out.println("Sorted Array is :");
        for (int i = 0; i < n; i++) {
            System.out.print(output[i] + " ");
        }

        System.out.println();

        System.out.println("Count Array is :");
        for (int i = 0; i < n; i++) {
            System.out.print(count[i] + " ");
        }
    }

    public static void main(String[] args) {
        // array

        int arr[] = { 1, 4, 1, 2, 7, 5, 2 };

        // length of array

        int n = arr.length;

        // max element in the array
        int k = 7;

        countSort(arr, n, k);
    }
}
