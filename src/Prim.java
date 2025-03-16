import java.util.*;

public class Prim {

    public static class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            return e1.weight - e2.weight;
        }
    }

    public Set<Edge> prim(Graph graph) {
        // 如果图为空，返回空集合
        if (graph.nodes.isEmpty()) {
            return new HashSet<>();
        }
        
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> visited = new HashSet<>();
        Set<Edge> res = new HashSet<>();
        
        // 随机选择一个起始节点
        Node start = graph.nodes.values().iterator().next();
        visited.add(start);
        // 将起始节点的所有边加入优先队列
        priorityQueue.addAll(start.edges);
        
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!visited.contains(edge.to)) {
                visited.add(edge.to);
                res.add(edge);
                // 将新加入节点的所有边加入优先队列
                for (Edge nextEdge : edge.to.edges) {
                    if (!visited.contains(nextEdge.to)) {
                        priorityQueue.add(nextEdge);
                    }
                }
            }
        }
        
        return res;
    }
}
