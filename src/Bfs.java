import java.util.*;

public class Bfs {
    public void bfs(Node node) {
        if(node == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        queue.add(node);
        visited.add(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next : cur.nexts) {
                if(!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

    }
}
