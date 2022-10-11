import java.util.Arrays;

class practical07{
    public static void main(String[] args) {
        int max = 9;
        int[] count = new int[max+1];
        int[] numbers = {3,4,2,3,2,2,0,1,7,6,8,9,1};
        int[] result = new int[numbers.length];

        System.out.println("Unsorted array: " + Arrays.toString(numbers));

        for(int num: numbers){
            count[num]++;
        }

        count[0]=0;
        for(int i=1; i< count.length;i++){
            count[i] += count[i-1];
        }
        System.out.println("Count array:    " + Arrays.toString(count));

        for(int j= result.length-1; j>=0;j--){
            result[count[numbers[j]]] = numbers[j];
            count[numbers[j]]--;
        }

        System.out.println("Sorted array:   " + Arrays.toString(result));
    }
}