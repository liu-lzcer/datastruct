import java.util.*;
import java.util.Map.Entry;
public class Dijkstra {

    public Node getMinAndUnlockedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> lockedNode) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for(Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!lockedNode.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public HashMap<Node, Integer> dijkstra(Node head) {
        HashSet<Node> lockedNode = new HashSet<>();
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        Node minNode = getMinAndUnlockedNode(distanceMap, lockedNode);
        while(minNode != null) {
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, edge.weight + distance);
                } else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            lockedNode.add(minNode);
            minNode = getMinAndUnlockedNode(distanceMap, lockedNode);
        }

        return distanceMap;
    }
}
