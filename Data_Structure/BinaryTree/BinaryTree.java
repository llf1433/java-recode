import java.util.LinkedList;
import java.util.Queue;

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

    //前序遍历
    void prevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }


    //中序遍历
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    //后序遍历
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    //获取结点个数
    int getNodeCount(TreeNode root) {
        /*
          子问题--(左结点个数 + 右结点个数)
         */
        if (root == null) {
            return 0;
        }
        return getNodeCount(root.left) + getNodeCount(root.right) + 1;

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

    //获取高度
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //重复递归
        /*return getHeight(root.left) > getHeight(root.right) ?
                getHeight(root.left) + 1 : getHeight(root.right) + 1;*/

        int lengthHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return lengthHeight > rightHeight ? lengthHeight + 1 : rightHeight + 1;
    }



    //检测value是否存在
    public boolean isExist(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return isExist(root.left, value) || isExist(root.right, value);
    }

    //层序遍历
    public void  levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        System.out.println(binaryTree.getKlevelNodeCount(root,3));
        binaryTree.prevOrder(root);
        System.out.println();
        /*binaryTree.inOrder(root);
        System.out.println();
        binaryTree.postOrder(root);
        System.out.println();
        System.out.println(“结点总数：” + binaryTree.getNodeCount(root));*/
        System.out.println("树的高度" + binaryTree.getHeight(root));
        binaryTree.levelOrder(root);
        System.out.println(binaryTree.isExist(root,1));
    }
}
