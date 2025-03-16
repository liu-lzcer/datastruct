package LQ_2024_java_B;

import java.util.*;

public class simulation {

    static class Pair {
        int node;
        int count;
        Pair(int node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p1.count - p2.count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.next();


        int counts = 0;
        while(scanner.hasNext()) {
            String string = scanner.next();
            if(string.equals("add")) {
                counts++;
            }
            if(string.contains("sync")) {
                scanner.next();
            }
        }
    }
}
