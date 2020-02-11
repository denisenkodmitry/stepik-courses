package ga;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextLong();

        List<String> result = new LinkedList<>();
        var sum = 0;
        for (var i = 1; sum < n; i++) {
            if ((sum + i + i + 1) <= n || n == (sum + i)) {
                sum += i;
                result.add(String.valueOf(i));
            }
        }
        System.out.println(result.size());
        System.out.println(String.join(" ", result));
    }
}
