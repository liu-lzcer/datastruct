import java.util.*;
public class kruskalMST {

    HashMap<Node, HashSet<Node>> myMaps = new HashMap<>();

    public void MySets(List<Node> val) {
        for (Node it : val) {
            HashSet<Node> set1 = new HashSet<>();
            set1.add(it);
            myMaps.put(it, set1);
        }
    }

    public boolean isSameSet(Node from, Node to) {
        HashSet<Node> fromSet = myMaps.get(from);
        HashSet<Node> toSet = myMaps.get(to);

        return fromSet == toSet;
    }

    public void union(Node from, Node to) {
        HashSet<Node> fromSet = myMaps.get(from);
        HashSet<Node> toSet = myMaps.get(to);
        
        // 始终将较小的集合合并到较大的集合中以提高效率
        if (fromSet.size() > toSet.size()) {
            HashSet<Node> temp = fromSet;
            fromSet = toSet;
            toSet = temp;
        }
        
        // 创建fromSet的副本以避免ConcurrentModificationException
        HashSet<Node> fromSetCopy = new HashSet<>(fromSet);
        
        // 将fromSet中的所有节点添加到toSet中
        for (Node node : fromSetCopy) {
            toSet.add(node);
            // 更新每个节点的集合引用
            myMaps.put(node, toSet);
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public Set<Edge> MainFuc(List<Node> val, Graph graph) {
        MySets(val);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        
        for (Edge edge : graph.edges) { // 将所有边添加到优先队列
            priorityQueue.add(edge); // O(logM)
        }
        
        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            
            if(!isSameSet(edge.from, edge.to)) {
                result.add(edge);
                union(edge.from, edge.to);
            }
        }
        
        return result;
    }
}


