package chapter05.charenge1;

public class Challange01 {

    // Maximum value
    public static int getMax(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    // Minimum value
    public static int getMin(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    // Sum
    public static int getSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Average
    public static double getAverage(int[] numbers) {
        return (double) getSum(numbers) / numbers.length;
    }

    // Count even numbers
    public static int countEven(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Count odd numbers
    public static int countOdd(int[] numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // Check if target exists
    public static boolean contains(int[] numbers, int target) {
        for (int num : numbers) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Find index of target
    public static int findIndex(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Reverse array
    public static int[] reverse(int[] numbers) {
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }
        return reversed;
    }

    // Copy array
    public static int[] copyArray(int[] numbers) {
        int[] copy = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }
        return copy;
    }

    public static void main(String[] args) {

        int[] numbers = {70, 85, 100, 90, 85};

        System.out.println("Max: " + getMax(numbers));
        System.out.println("Min: " + getMin(numbers));
        System.out.println("Sum: " + getSum(numbers));
        System.out.println("Average: " + getAverage(numbers));
        System.out.println("Even Count: " + countEven(numbers));
        System.out.println("Odd Count: " + countOdd(numbers));
        System.out.println("Contains 90: " + contains(numbers, 90));
        System.out.println("Index of 90: " + findIndex(numbers, 90));

        int[] reversed = reverse(numbers);
        System.out.print("Reversed: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] copied = copyArray(numbers);
        System.out.print("Copied: ");
        for (int num : copied) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
    
