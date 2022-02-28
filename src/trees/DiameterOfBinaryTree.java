package trees;

//Let T be an undirected binary tree with n vertices. Create an algorithm to compute
//the diameter of T.
//
//Clearly explain how your algorithm works, why it guarantees
//the correct output, and determine the running time of your algorithm.

import com.sun.source.tree.Tree;

public class DiameterOfBinaryTree {

  public class TreeNode {

    TreeNode left;
    TreeNode right;
    char data;

    public TreeNode(TreeNode left, TreeNode right, char data) {
      this.left = left;
      this.right = right;
      this.data = data;
    }
  }

  public static void main(String[] args) {
    DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
    TreeNode root = diameterOfBinaryTree.createTree();
    int diameter = diameterOfBinaryTree.findDiameter(root);
    System.out.println(diameter);
  }

  private TreeNode createTree() {
    TreeNode d = new TreeNode(null, null, 'd');
    TreeNode e = new TreeNode(null, null, 'e');
    TreeNode l = new TreeNode(null, null, 'l');
    TreeNode q = new TreeNode(null, null, 'q');
    TreeNode i = new TreeNode(null, null, 'i');
    TreeNode n = new TreeNode(null, null, 'n');
    TreeNode o = new TreeNode(null, null, 'o');
    TreeNode p = new TreeNode(null, null, 'p');
    TreeNode j = new TreeNode(n, o, 'j');
    TreeNode k = new TreeNode(null, p, 'k');
    TreeNode g = new TreeNode(j, k, 'k');
    TreeNode m = new TreeNode(q, null, 'm');
    TreeNode h = new TreeNode(l, m, 'h');
    TreeNode f = new TreeNode(h, i, 'f');

    TreeNode b = new TreeNode(d, e, 'b');
    TreeNode c = new TreeNode(f, g, 'c');
    TreeNode root = new TreeNode(b, c, 'a');

    //    TreeNode d = new TreeNode(null, null, 'd');
    //    TreeNode c = new TreeNode(null, d, 'c');


//    TreeNode b = new TreeNode(null, null, 'b');
//    TreeNode d = new TreeNode(null, null, 'd');
//    TreeNode c = new TreeNode(null, d, 'c');
//    TreeNode root = new TreeNode(b, c, 'a');
    return root;
  }

  private int findDiameter(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = findDiameter(root.left);
    int rightHeight = findDiameter(root.right);

    return leftHeight + rightHeight + 1;

  }

}
