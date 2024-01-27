import java.util.Scanner;

public class Min_Max{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        Pair minMax = findMinMax(array, 0, size - 1);

        System.out.println("Minimum element: " + minMax.min);
        System.out.println("Maximum element: " + minMax.max);

        scanner.close();
    }

    public static Pair findMinMax(int[] arr, int left, int right) {
        if (left == right) {
            // Base case: Single element in the array
            return new Pair(arr[left], arr[left]);
        } else if (right - left == 1) {
            // Base case: Two elements in the array
            return new Pair(Math.min(arr[left], arr[right]), Math.max(arr[left], arr[right]));
        } else {
            // Recursive case: Divide the array and find min/max in each half
            int mid = left + (right - left) / 2;
            Pair leftPair = findMinMax(arr, left, mid);
            Pair rightPair = findMinMax(arr, mid + 1, right);

            // Combine results
            int overallMin = Math.min(leftPair.min, rightPair.min);
            int overallMax = Math.max(leftPair.max, rightPair.max);

            return new Pair(overallMin, overallMax);
        }
    }

    static class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}