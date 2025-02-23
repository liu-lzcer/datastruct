public class BinaryTreeSuccessorNode {
     public TreeNode BinaryTreeSuccessorNode(TreeNode head) {
         TreeNode parent = head.parent;
        if(head.right != null)
            return head.right;
        else
            while(parent != null && parent.left != head) {
                head = parent;
                parent = parent.parent;
            }

         return parent;
     }
}
