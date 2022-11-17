import java.util.Arrays;

public class practical13{
    public static void main(String[] args) {
        int[] numbers = {12,4,35,2,54,24,1,80};
        System.out.println("Unsorted: " + Arrays.toString(numbers));
        QuickSort(numbers, 0 , numbers.length-1);
        System.out.println("Sorted: " + Arrays.toString(numbers));
    }

    static void QuickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int start = left, end=right;
        int pivot=left++;
        while(left<right){
            while(arr[left]<arr[pivot] && left< end){
                left++;
            }
            while(arr[right] > arr[pivot] && right>start) {
                right--;
            }
            if(left < right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int temp = arr[right];
        arr[right] = arr[pivot];
        arr[pivot] = temp;

        QuickSort(arr, start, right-1);
        QuickSort(arr, right+1, end);
    }
}