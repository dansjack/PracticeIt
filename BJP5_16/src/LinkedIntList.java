import java.util.NoSuchElementException;

public class LinkedIntList {
  private ListNode front;

  public LinkedIntList() {
    front = null; // empty list
  }

  public void firstLast() {
    if (front == null || front.next == null) {
      return;
    }
    ListNode back = front;
    front = front.next;
    back.next = null;
    ListNode current = front;
    while (current.next != null) {
      current = current.next;
    }
    current.next = back;
  }

  public void add(int value) {
    if (front == null) {
      // adding to an empty list
      front = new ListNode(value);
    } else {
      // adding to the end of an existing list
      ListNode current = front;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new ListNode(value);
    }
  }

  public void add(int index, int value) {
    if (index == 0) {
      // adding to an empty list
      front = new ListNode(value, front);
    } else {
      // inserting into an existing list
      ListNode current = front;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      current.next = new ListNode(value, current.next);
    }

  }

  // Adds given value to list in sorted order.
  // Precondition: Existing elements are sorted
  public void addSorted(int value) {
    if (front == null || value <= front.data) {
      // insert at front of list
      front = new ListNode(value, front);
    } else {
      // insert in middle of list
      ListNode current = front;
      while (current.next != null &&
          current.next.data < value) {
        current = current.next;
      }
    }
  }

  public int get(int index) {
    ListNode current = front;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.data;
  }

  // Removes and returns the first value
  // Throws a NoSuchElementException inn empty list
  public int remove() {
    if (front == null) {
      throw new NoSuchElementException();
    } else {
      int result = front.data;
      front = front.next;
      return result;
    }
  }

  // removes value at given index from list
  // precondition: 0 <= index < size()
  public void remove(int index) {
    if(index == 0) {
      // special case: removing first element
      front = front.next;
    } else {
      // removing from elsewhere in the list
      ListNode current = front;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      current.next = current.next.next;
    }
  }




  public String toString() {
    if (front == null) { // empty list
      return "[]";
    } else { // not an empty list
      String result = "[" + front.data;
      ListNode current = front.next;

      while (current != null) {
        result += ", " + current.data;
        current = current.next;
      }

      result += "]";
      return result;
    }
  }

}
