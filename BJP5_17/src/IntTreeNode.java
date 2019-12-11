public class IntTreeNode {
  public int data; // data stored at this node
  public IntTreeNode left; // ref to the left subtree
  public IntTreeNode right; // ref to the right subtree

  // Constructs a leaf node with the given data
  public IntTreeNode(int data) {
    this(data, null, null);
  }

  // Constructs a branch node with the given data and links
  public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return "IntTreeNode{" +
            "data=" + data +
            ", left=" + left +
            ", right=" + right +
            '}';
  }
}
