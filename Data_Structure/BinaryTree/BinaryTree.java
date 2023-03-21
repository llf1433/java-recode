public class BinaryTree {
    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int value) {
            this.value = value;
        }
    }


    TreeNode createTree() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        return t1;
    }

    TreeNode root = createTree();

    void prevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }




    //获取K层结点个数
    int getKlevelNodeCount(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (k == 1) {
            return k;
        }
        return getKlevelNodeCount(root.left, k--) + getKlevelNodeCount(root.left, k--);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        System.out.println(binaryTree.getKlevelNodeCount(root,3));
        binaryTree.prevOrder(root);
        System.out.println();
        binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
    }
}
