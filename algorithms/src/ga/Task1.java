package ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Task1 {

    public static void main(String[] args) {

        Cut[] cuts = getCuts();

        Arrays.sort(cuts);

        List<String> result = getResult(cuts);

        System.out.println(result.size());
        System.out.println(String.join(" ", result));
    }

    private static List<String> getResult(Cut[] cuts) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < cuts.length) {
            result.add(String.valueOf(cuts[i].getY()));
            i++;
            Integer r = Integer.valueOf(result.get(result.size() - 1));
            while (i < cuts.length && cuts[i].getX() <= r) {
                i++;
            }
        }
        return result;
    }

    private static Cut[] getCuts() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Cut[] cuts = new Cut[n];

        int y = 0;
        while (n > y) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            cuts[y] = new Cut(l, r);
            y++;
        }
        return cuts;
    }


    static class Cut implements Comparable {
        private int x;
        private int y;

        public Cut(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Object o) {
            return this.y - ((Cut) o).getY();
        }

        @Override
        public String toString() {
            return "Cut{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
