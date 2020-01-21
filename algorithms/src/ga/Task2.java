package ga;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int w = scanner.nextInt();

        Pair[] pairs = new Pair[n];
        int i = 0;
        while (n > i) {
            int c = scanner.nextInt();
            int weight = scanner.nextInt();
            pairs[i] = new Pair(c, weight);
            i++;
        }

        Arrays.sort(pairs);

        double sum = 0;
        for (Pair pair : pairs) {
            if (w >= pair.getVolume()) {
                sum += pair.priceForOne() * pair.getVolume();
                w = w - pair.getVolume();
            } else {
                sum += pair.priceForOne() * w;
                w = 0;
            }
        }
        System.out.println(String.format("%.3f", sum));
    }

    static class Pair implements Comparable {
        private int price;
        private int volume;
        private double priceForOne;

        public Pair(int price, int volume) {
            this.price = price;
            this.volume = volume;
            this.priceForOne = (double) price / (double) volume;
        }

        public int getPrice() {
            return price;
        }

        public int getVolume() {
            return volume;
        }

        public double priceForOne() {
            return priceForOne;
        }

        @Override
        public int compareTo(Object o) {
            return Double.compare(((Pair) o).priceForOne(), priceForOne());
        }
    }
}
