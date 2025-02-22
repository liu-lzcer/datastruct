public class LowestCommonAncestor {
//    TreeNode treenode;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null)
//            return null;
//        treenode = root;
//        isCommon(root, p, q);
//
//        return treenode;
//
//    }
//    boolean isCommon(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null)
//            return false;
//        boolean t = root == p || root == q;
//        boolean l = isCommon(root.left, p, q);
//        boolean r = isCommon(root.right, p, q);
//        if(t ? (l || r) : (l && r)) {
//            treenode = root;
//            return false;
//        }
//        return t || l || r;
//    }

    public TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q) {
        if(head == null || head == p || head == q) {
            return head;
        }

        TreeNode left = lowestCommonAncestor(head.left, p, q);
        TreeNode right = lowestCommonAncestor(head.right, p, q);
        if(left != null && right != null)
            return head;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lo = new LowestCommonAncestor();
        TreeNode root = new TreeNode(3);

        // 创建第二层节点
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        // 创建第三层节点
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        // 创建第四层节点
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        //System.out.println(lo.lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }
}
