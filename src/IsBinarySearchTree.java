import java.util.Stack;

public class IsBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        TreeNode min = null;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(min != null && cur.val <= min.val)
                return false;
            min = cur;

            cur = cur.right;
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
