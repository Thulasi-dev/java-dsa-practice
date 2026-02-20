public class SecondHighest {
    public static void main(String[] args) {
        int[] numbers = {12, 35, 1, 10, 34, 1};
        
        int secondHighest = findSecondHighest(numbers);

        if (secondHighest != Integer.MIN_VALUE) {
            System.out.println("The second highest number is: " + secondHighest);
        } else {
            System.out.println("The second highest number doesn't exist.");
        }
    }

    public static int findSecondHighest(int[] arr) {
        if (arr.length < 2) {
            return Integer.MIN_VALUE; // Not enough elements to find the second highest
        }

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > highest) {
                secondHighest = highest; // Update second highest
                highest = num;           // Update highest
            } else if (num > secondHighest && num != highest) {
                secondHighest = num; // Update second highest
            }
        }

        return secondHighest;
    }
}
