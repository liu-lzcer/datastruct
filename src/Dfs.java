import java.util.Stack;
import java.util.HashSet;

public class Dfs {
    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> visited = new HashSet<>();
        stack.push(node);
        visited.add(node);
        System.out.println(node.value);

        while(!stack.isEmpty()) {
            Node cur = stack.pop();

            for(Node next : cur.nexts) {
                if(!visited.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    visited.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
