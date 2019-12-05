public class ListNode {
  int data;
  ListNode next;

  // construct a node with data 0 and null link
  public ListNode() {
    this(0, null);
  }

  // construct a node with given data and null link
  public ListNode(int data) {
    this(data, null);
  }

  // construct a node with given data & given link
  public ListNode(int data, ListNode next) {
    this.data = data;
    this.next = next;
  }
}
