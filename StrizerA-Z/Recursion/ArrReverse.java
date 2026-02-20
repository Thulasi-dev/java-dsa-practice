import java.util.Arrays;

class ArrReverse {

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 9, 1};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
