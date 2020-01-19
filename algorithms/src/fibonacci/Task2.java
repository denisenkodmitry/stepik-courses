package fibonacci;

import java.util.Scanner;

/**
 * @see <a href="https://stepik.org/lesson/13228/step/7?unit=3414">stepik task 2</a>
 */
public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        long[] fibArray = fib(value);
        System.out.println(fibArray[fibArray.length - 1]);
    }

    private static long[] fib(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10;
        }
        return arr;
    }
}
