package trees;

class DiameterOfABinaryTree {
  public static class TreeNode {

    TreeNode left;
    TreeNode right;
    char data;

    public TreeNode(TreeNode left, TreeNode right, char data) {
      this.left = left;
      this.right = right;
      this.data = data;
    }
  }

  static class Output {
    int output = Integer.MIN_VALUE;
  }

  static int height(TreeNode root, Output a) {
    if (root == null) {
      return 0;
    }
    int left_height = height(root.left, a);
    int right_height = height(root.right, a);
    a.output = Math.max(a.output, 1 + left_height + right_height);
    return 1 + Math.max(left_height, right_height);
  }

  static int getDiameter(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Output a = new Output();
    height(root, a);
    return a.output - 1;
  }

  public static void main(String[] args) {
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

    //        TreeNode b = new TreeNode(null, null, 'b');
    //        TreeNode d = new TreeNode(null, null, 'd');
    //        TreeNode c = new TreeNode(null, d, 'c');
    //        TreeNode root = new TreeNode(b, c, 'a');

    System.out.println("Diameter is " + getDiameter(root));
  }
}
