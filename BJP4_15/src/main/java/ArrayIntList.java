import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Class ArrayIntList can be used to store a list of integers.
public class ArrayIntList implements Iterable<Integer> {
    private int[] elementData;  // list of integers
    private int size = 0;       // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 10;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0
    // post: constructs an empty list with the given capacity
    private ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }
        elementData = new int[capacity];
    }

    /****START PRACTICE IT METHODS******/


    public ArrayIntList runningTotal() {
        // BJP4 Exercise 15.5: runningTotal

        // if list is empty, return an empty list
        if (size < 1) {
            return new ArrayIntList();
        }

        // initialize result list with original's capacity
        ArrayIntList result = new ArrayIntList(getCapacity());

        // track the running total given original list els
        // and add them to result list
        int total = elementData[0];
        for (int i = 1; i < size + 1; i++) {
            result.add(total);
            total += elementData[i];
        }

        return result;
    }

    public boolean isPairwiseSorted() {
        /*
        returns whether or not a list of integers
        is pairwise sorted (true if it is, false
        otherwise). A list is considered pairwise
        sorted if each successive pair of numbers
        is in sorted (non-decreasing) order.
         */

        // if no pairs, return true
        if (size < 2) {
            return true;
        }


        // if odd num of els, discount last el from loop
        if (size % 2 != 0) {
            size = size - 1;
        }

        boolean flag = true;
        // loop through els, flagging unsorted pairs
        for (int i = 1; i < size; i+=2) {
            if (elementData[i] < elementData[i-1]) {
                flag = false;
            }
        }

        return flag;
    }

    public int longestSortedSequence() {
        /*
        returns the length of the longest sorted
        sequence within a list of integers.
         */
        if (size < 1) {
            return 0;
        }

        // total will be at least 1
        int runningTotal = 1;
        int total = 1;

        for (int i = 1; i < size; i++) {
            // if current el is greater than prev el, add to total
            if (elementData[i] >= elementData[i - 1]) {
                runningTotal += 1;
            } else { // else, reset the total
                runningTotal = 1;
            }

            // if running total greater than 1,
            // total equal to running total
            if (runningTotal > total) {
                total = runningTotal;
            }
        }

        return total;
    }

    public void removeFront(int n) {
        /*
        takes an integer n as a parameter
        and that removes the first n values
        from a list of integers.
        */

        // we place n in a var outside the loop
        // so we can use it as the limit of our
        // for loop statement AND use it to track
        // the values we want to remain in the list
        int count = n;
        for (int i = 0; i < count; i++) {
            elementData[i] = elementData[n];
            n++;
            size--;
        }
    }

    public void removeAll(int n) {
        /*
        takes an integer value as a parameter
        and that removes all occurrences of
        the given value from the list. You can
        assume that a method called remove
        exists that takes an index as a
        parameter and that removes the value
        at the given index.
         */

        for (int i = 0; i < size; i++) {
            if (elementData[i] == n) {
                remove(i);
                i--;
            }
        }
    }

    public void printInversions() {
        /*
        lists all inversions in a list of integers.
        An inversion is defined as a pair of numbers
        where the first appears before the second in
        the list, but the first is greater than the
        second.
         */
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (elementData[i] > elementData[j]) {
                    System.out.println("(" + elementData[i] +
                            ", " + elementData[j] + ")");
                }
            }

        }
    }

    public void mirror() {
        /*
        doubles the size of a list of integers
        by appending the mirror image of the
        original sequence to the end of the list.
        The mirror image is the same sequence of
        values in reverse order.
         */

        // ensure list has enough space for mirroring
        ensureCapacity(size * 2);

        int oSize = size;
        for (int i = 1; i < oSize + 1; i++) {
            add(elementData[oSize - i]);
        }
    }

    public void stretch(int n) {
        /*
        increases a list of integers by a
        factor of n by replacing each
        integer in the original list with n
        copies of that integer.
         */

        if (n <= 0) {
            clear();
        }

        ensureCapacity(size * n);
        int oSize = size;

        // loop through size-of-list-*-n times
        for (int i = 0; i < oSize * n; i+=n) {
            // loop again n-less-one times
            // (less one to account for
            // original value we're stretching
            for (int j = 0; j < n - 1; j++) {
                // stretch the list by one el
                add(i, elementData[i]);
            }
        }
    }
    /*****END PRACTICE IT METHODS******/


    // for creating test cases more easily
    public ArrayIntList(int... elements) {
        this(Math.max(DEFAULT_CAPACITY, elements.length * 2));
        for (int n : elements) {
            add(n);
        }
    }

    // for creating test cases more easily (a dupe of the above constructor)
    public static ArrayIntList withValues(int... elements) {
        ArrayIntList list = new ArrayIntList(Math.max(DEFAULT_CAPACITY, elements.length * 2));
        for (int n : elements) {
            list.add(n);
        }
        return list;
    }

    // for creating test cases more easily
    public ArrayIntList(int element, boolean notCapacity) {
        this();
        add(element);
    }

    // for creating test cases more easily
    public ArrayIntList(Collection<Integer> elements) {
        this(Math.max(DEFAULT_CAPACITY, elements.size() * 2));
        for (int n : elements) {
            add(n);
        }
    }

    // copy constructor; for creating test cases more easily
    public ArrayIntList(ArrayIntList list) {
        this(Math.max(DEFAULT_CAPACITY, list.size() * 2));
        addAll(list);
    }

    // pre : size() < capacity (elementData.length)
    // post: appends the given value to the end of the list
    public void add(int value) {
        add(size, value);
    }

    // pre: size() < capacity (elementData.length) && 0 <= index <= size()
    // post: inserts the given value at the given index, shifting subsequent
    //     values right
    public void add(int index, int value) {
        checkIndex(index, 0, size);
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayIntList other) {
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post: list is empty
    public void clear() {
        size = 0;
    }

    // post: returns true if the given value is contained in the list, false otherwise
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // post: ensures that the underlying array has the given capacity; if not,
    // the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            int[] newList = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                newList[i] = elementData[i];
            }
            elementData = newList;
        }
    }

    // returns true if o is an ArrayIntList with the same size and elements as this one
    public boolean equals(Object o) {
        if (!(o instanceof ArrayIntList)) {
            return false;
        }

        ArrayIntList other = (ArrayIntList) o;
        if (this.size != other.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (elementData[i] != other.elementData[i]) {
                return false;
            }
        }

        return true;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: returns capacity of this list's underlying array
    public int getCapacity() {
        return elementData.length;
    }

    // post : returns the position of the first occurence of the given
    //      value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns an iterator for this list
    public Iterator<Integer> iterator() {
        return new ArrayIntListIterator(this);
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // post: removes all occurrences of the values in the given list from this list
    public void removeAll(ArrayIntList other) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!other.contains(elementData[i])) {
                elementData[newSize] = elementData[i];
                newSize++;
            }
            size = newSize;
        }
    }

    // pre : 0 <= index < size()
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // post: returns an array version of the contents of this list
    public int[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ", ";
            }
            if (i < elementData.length) {
                result += elementData[i];
            } else {
                // student's code is bogus; OOB
                result += "OOB!";
            }
        }
        result += "]";
        return result;
    }

    // helpers to make sure indexes do not fall out of bounds
    private void checkIndex(int index) {
        checkIndex(index, 0, size - 1);
    }

    private void checkIndex(int index, int min, int max) {
        if (!(min <= index && index <= max)) {
            throw new ArrayIndexOutOfBoundsException("Illegal index " + index +
                    "; must be between " + min + " and " + max + "\n"
                    + "list : " + toString() + " (size=" + size + ")\n"
                    + "array: " + Arrays.toString(elementData) + " (capacity=" + elementData.length + ")");
        }
    }




    // Stuart Reges
    // 4/4/05
    //
    // The ArrayIntListIterator class provides a set of utilities for iterating
    // over an ArrayIntList and possibly removing values from the list.

    private static class ArrayIntListIterator implements Iterator<Integer> {
        private ArrayIntList list;    // list to iterate over
        private int position;          // current position within the list
        private boolean removeOK;      // whether it's okay to remove now

        // pre : list != null
        // post: constructs an iterator for the given list
        public ArrayIntListIterator(ArrayIntList list) {
            this.list = list;
            position = 0;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < list.size();
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int result = list.get(position);
            position++;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most one
        //     call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK)
                throw new IllegalStateException();
            list.remove(position - 1);
            position--;
            removeOK = false;
        }
    }

// YOUR CODE GOES HERE

}
