import java.util.Scanner;

public class BinarySearch1 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] sortedArray = new int[size];

        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            sortedArray[i] = scanner.nextInt();
        }

        
        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        
        int result = binarySearch(sortedArray, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }

        scanner.close();
    }
}