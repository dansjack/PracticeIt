public class IntTree {
  private IntTreeNode overallRoot;
  // pre: max > 0
  // post: constructs a sequential tree with given number of nodes
  public IntTree(int max) {
    if (max <= 0) {
      throw new IllegalArgumentException("max: " + max);
    }
    overallRoot = buildTree(1, max);
  }

  // post: returns a sequential tree with n as its root unless n is greater
  // than max, in which case it returns an empty tree
  private IntTreeNode buildTree(int n, int max) {
    if (n > max) {
      return null;
    } else {
      return new IntTreeNode(n, buildTree(2 * n, max),
          buildTree(2 * n + 1, max));
    }
  }

  public int size() {
    return(size(overallRoot));
  }


  private int size(IntTreeNode root) {
    // Not my original code. Found solution here:
    // https://stackoverflow.com/questions/19166510/size-method-for-binary-trees
    if (root == null) {
      return 0;
    } else {
      return 1 + size(root.left) + size(root.right);
    }
  }

  public int countLeftNodes() {
    return(countLeftNodes(overallRoot));
  }

  private int countLeftNodes(IntTreeNode root) {
    if (root.left == null) {
      return 0;
    } else {
      return 1 + countLeftNodes(root.left);
    }
  }
  // post: prints the tree contents using a pre-order traversal
  public void printPreorder() {
    System.out.print("pre-order: ");
    printPreorder(overallRoot);
    System.out.println();
  }

  // post: prints the tree contents using a pre-order traversal
  private void printPreorder(IntTreeNode root) {
    if (root != null) {
      System.out.print(" " + root.data);
      printPreorder(root.left);
      printPreorder(root.right);
    }
  }

  // post: prints the tree contents using an inorder traversal
  public void printInOrder() {
    System.out.print("inorder:");
    printInOrder(overallRoot);
    System.out.println();
  }

  // post: prints in inorder the tree with given root
  private void printInOrder(IntTreeNode root) {
    if (root != null) {
      printInOrder(root.left);
      System.out.print(" " + root.data);
      printInOrder(root.right);
    }
  }

  public void printPostOrder() {
    System.out.print("postorder:");
    printPostOrder(overallRoot);
    System.out.println();
  }

  // post: prints the tree contents using a post-order traversal
  private void printPostOrder(IntTreeNode root) {
    if (root != null) {
      printPostOrder(root.left);
      printPostOrder(root.right);
      System.out.print(" " + root.data);
    }
  }

  // Prints the tree in a sideways indented format
  public void printSideways() {
    printSideways(overallRoot, "");
  }

  private void printSideways(IntTreeNode root, String indent) {
    if (root != null) {
      printSideways(root.right, indent + "    ");
      System.out.println(indent + root.data);
      printSideways(root.left, indent + "    ");
    }
  }

  public int sum() {
    return sum(overallRoot);
  }

  private int sum(IntTreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return root.data + sum(root.left) + sum(root.right);
    }
  }

  public int countLevel() {
    return countLevel(overallRoot);
  }

  private int countLevel(IntTreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(countLevel(root.left), countLevel(root.right));
    }
  }

  public int countLeaves() {
    return countLeaves(overallRoot);
  }

  private int countLeaves(IntTreeNode root) {
    if (root == null) { // tree is empty, so no nodes at all
      return 0;
    } else if (root.left == null && root.right == null) {
      return 1; // this node is itself a leaf node
    } else {
      return countLeaves(root.left) + countLeaves(root.right);
    }
  }

  public boolean contains(int value) {
    return contains(overallRoot, value);
  }

  private boolean contains(IntTreeNode root, int value) {
    if (root == null) {
      return false;
    } else if (root.data == value) {
      return true;
    } else if (root.data > value) {
      return contains(root.left, value);
    } else { // root.data < value
      return contains(root.right, value);
    }
  }

  // Adds the given value to the BST in sorted order
  public void add(int value) {
    overallRoot = add(overallRoot, value);
  }

  private IntTreeNode add(IntTreeNode root, int value) {
    if (root == null) {
      root = new IntTreeNode(value);
    } else if (root.data > value) {
      root.left = add(root.left, value);
    } else if (root.data < value) {
      root.right = add(root.right, value);
    } // else, a duplicate
    return root;
  }
}
