package LQ_2024_java_B;

import java.util.*;

public class simulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 节点数量
        List<Integer> mainQueue = new ArrayList<>(); // 主节点的队列
        int[] followerIndices = new int[N - 1]; // 副节点的同步索引，初始为 0

        // 处理每一条操作
        while (scanner.hasNext()) {
            String command = scanner.next();

            if (command.equals("add")) {
                int element = scanner.nextInt();
                mainQueue.add(element); // 将元素添加到主节点的队列
            } else if (command.equals("sync")) {
                int followerId = scanner.nextInt() - 1; // 减去 1 以便于数组索引
                // 只在副节点的同步索引小于主队列长度时同步
                if (followerIndices[followerId] < mainQueue.size()) {
                    followerIndices[followerId]++; // 同步下一个元素
                }
            } else if (command.equals("query")) {
                // 计算当前可见的元素数量
                int visibleCount = 0;
                int minIndex = Integer.MAX_VALUE; // 找到所有副节点的最小同步索引

                for (int i = 0; i < followerIndices.length; i++) {
                    minIndex = Math.min(minIndex, followerIndices[i]);
                }

                // 只有当 minIndex 等于或大于元素的索引时，该元素才可见
                visibleCount = Math.min(minIndex, mainQueue.size());
                System.out.println(visibleCount); // 打印可见元素的数量
            }
        }

        scanner.close();
    }
}
