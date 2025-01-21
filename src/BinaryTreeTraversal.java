import java.util.*;

public class BinaryTreeTraversal {

    // 先序遍历（根 -> 左 -> 右）
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            // 先压右子树，再压左子树
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 中序遍历（左 -> 根 -> 右）
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 先遍历左子树
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 访问根节点
            curr = stack.pop();
            System.out.print(curr.val + " ");

            // 遍历右子树
            curr = curr.right;
        }
    }

    // 后序遍历（左 -> 右 -> 根）
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node);

            // 先压左子树，再压右子树
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // 输出结果
        while (!output.isEmpty()) {
            System.out.print(output.pop().val + " ");
        }
    }

    // 层次遍历（广度优先遍历）
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            // 先压左子树，再压右子树
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("先序遍历:");
        preOrderTraversal(root);
        System.out.println();

        System.out.println("中序遍历:");
        inOrderTraversal(root);
        System.out.println();

        System.out.println("后序遍历:");
        postOrderTraversal(root);
        System.out.println();

        System.out.println("层次遍历:");
        levelOrderTraversal(root);
        System.out.println();
    }
}
