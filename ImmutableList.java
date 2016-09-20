/**********************************************
 * ImmutableList.java
 * @author SarahGreen
 *********************************************/

package list_utilities;

/**
 * The {@link ImmutableList} class creates an ImmutableList object and specifies
 * the methods that can be applied to it. An ImmutableList is a list of Objects
 * that cannot be modified once instantiated. It has a head, which is an Object,
 * and a tail, which is another ImmutableList.
 */

public class ImmutableList {

	/** instance variables */
	private final Object data;
	private final ImmutableList next;
	public static final ImmutableList NIL = new ImmutableList(null, null);

	/** constructor */
	public ImmutableList(Object d, ImmutableList n) {
		data = d;
		next = n;
	}

	/**
	 * Creates an ImmutableList with one Object.
	 * 
	 * @param d
	 *            Object to be the head of the list
	 * @return new ImmutableList with the Object as head and null tail
	 */
	public static ImmutableList list(Object d) {
		return new ImmutableList(d, NIL);
	}

	/**
	 * Pushes an Object as the head of a new list whose tail is this list.
	 * 
	 * @param d
	 *            an Object to be pushed
	 * @return new ImmutableList with the object pushed onto this
	 */
	public ImmutableList push(Object d) {
		return new ImmutableList(d, this);
	}

	/**
	 * Accesses the head of a list.
	 * 
	 * @return data the head of an ImmutableList
	 */
	public Object head() {
		return data;
	}

	/**
	 * Accesses the tail of a list.
	 * 
	 * @return next the tail of an ImmutableList
	 */
	public ImmutableList tail() {
		return next;
	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return b whether or not this list is empty (has null head and tail)
	 */
	public boolean isEmpty() {
		boolean b = (this == NIL);
		return b;
	}

	/**
	 * Checks the length of the ImmutableList.
	 * 
	 * Base case: empty ImmutableList with zero elements.
	 * 
	 * Otherwise: a list has one more element than its tail.
	 * 
	 * @return int the length of the ImmutableList
	 */
	public int length() {
		if (isEmpty())
			return 0;
		else
			return (1 + tail().length());
	}

	/**
	 * Returns null if the Object requested is not an element of the
	 * ImmutableList, and returns the sublist of the ImmutableList whose head is
	 * the element if it is an element of the ImmutableList.
	 * 
	 * Base case: return ImmutableList itself if it is empty or if its head
	 * equals the requested Object.
	 * 
	 * Otherwise: find the Object in the tail.
	 * 
	 * @param d
	 *            the Object to be found
	 */
	public ImmutableList find(Object d) {
		if (isEmpty() || d.equals(head()))
			return this;
		else
			return tail().find(d);
	}

	/**
	 * Returns a new ImmutableList with all elements of this followed by all
	 * elements of that.
	 * 
	 * Base case: appending that onto the empty ImmutableList is just that.
	 * 
	 * Otherwise: append that onto the tail of this and then push the head of
	 * this onto the result.
	 * 
	 * @param that
	 *            the ImmutableList to be appended onto this ImmutableList
	 */
	public ImmutableList append(ImmutableList that) {
		if (isEmpty())
			return that;
		else
			return tail().append(that).push(head());
	}

	/**
	 * Returns a list with all the elements reversed.
	 * 
	 * Base case: returns an empty ImmutableList is the empty ImmutableList.
	 * 
	 * Otherwise: reverses the tail, then appends a one-element ImmutableList
	 * containing the head onto the end.
	 */
	public ImmutableList reverse() {
		if (isEmpty())
			return this;
		else
			return (tail().reverse().append(ImmutableList.list(head())));
	}

	/**
	 * Accesses the nth element of a ImmutableList (indexed from zero).
	 * 
	 * Base case: if n is zero, returns the head.
	 * 
	 * Otherwise: returns the (n-1)st element of the tail.
	 */
	public Object nth(int n) {
		if (isEmpty() || n < 0)
			return null;
		else if (n == 0)
			return head();
		else
			return tail().nth(n - 1);
	}

	/**
	 * Deletes all instances of the specified Object from the list.
	 * 
	 * Base case: returns this if this is an empty list.
	 * 
	 * Otherwise: returns the tail with delete(d) called upon it if d is the
	 * head of the list.
	 * 
	 * Otherwise: returns the tail with delete(d) and push(head()) called upon
	 * it.
	 * 
	 * @param d
	 *            the Object to be deleted
	 */
	public ImmutableList delete(Object d) {
		if (this.isEmpty())
			return this;
		else if (d.equals(head()))
			return tail().delete(d);
		else
			return tail().delete(d).push(head());
	}

	/**
	 * Inserts an Object into the list in its properly sorted place.
	 * 
	 * Base case: return this with d pushed onto it if this is an empty list or
	 * d is less than the other elements in the list.
	 * 
	 * Otherwise: return the tail with insert(d) and push(head()) called upon
	 * it.
	 * 
	 * @param d
	 *            the Object to be inserted
	 */
	public ImmutableList insert(Object d) {
		Integer objAsInt = (Integer) d;
		Integer headAsInt = (Integer) (head());
		if (isEmpty() || objAsInt.compareTo(headAsInt) < 0)
			return push(d);
		else
			return tail().insert(d).push(head());
	}

	/**
	 * Creates a String version of the ImmutableList.
	 * 
	 * @return String representing the ImmutableList
	 */
	public String toString() {
		return this.isEmpty() ? "()" : "(" + head().toString()
				+ (tail().isEmpty() ? "" : " ")
				+ tail().toString().substring(1);
	}

	/**
	 * Parses a String into an ImmutableList.
	 * 
	 * @param s
	 *            the String to be parsed
	 * @return result the ImmutableList coming from the parsed String
	 */
	public static ImmutableList parseIntList(String s) {
		String[] intStrings = s.split(" ");
		ImmutableList result = NIL;
		for (int i = intStrings.length - 1; i >= 0; i--) {
			Object d = Integer.parseInt(intStrings[i]);
			result = result.push(d);
		}
		return result;
	}

	/**
	 * Removes all duplicate elements of an ImmutableList.
	 * 
	 * @return purgedList the ImmutableList with duplicate elements removed
	 */
	public ImmutableList purge() {
		ImmutableList temp = this;
		ImmutableList purgedList = NIL;
		while (!temp.isEmpty()) {
			Object d = temp.head();
			purgedList = purgedList.push(d);
			temp = temp.tail();
			temp = temp.delete(d);
		}
		return purgedList;
	}

	/**
	 * Creates the "left side" of an ImmutableList to be mergesorted.
	 * 
	 * @return left the left half of the ImmutableList.
	 */
	public ImmutableList splitLeft() {
		ImmutableList left = NIL;
		for (int i = 0; i < this.length(); i++) {
			if (i % 2 == 0)
				left = left.append(list(this.nth(i)));
		}
		return left;
	}

	/**
	 * Creates the "right side" of an ImmutableList to be mergesorted.
	 * 
	 * @return right the right half of the ImmutableList.
	 */
	public ImmutableList splitRight() {
		ImmutableList right = NIL;
		for (int i = 0; i < this.length(); i++) {
			if (i % 2 != 0)
				right = right.append(list(this.nth(i)));
		}
		return right;
	}

	/**
	 * Mergesorts an ImmutableList in conjunction with the merge method.
	 * 
	 * @return a mergesorted list
	 */
	public ImmutableList mergesort() {
		if (this.length() > 1) {
			ImmutableList leftList = this.splitLeft().mergesort();
			ImmutableList rightList = this.splitRight().mergesort();
			int mid = (int) (Math.ceil(this.length() / 2));
			ImmutableList fullList = leftList.append(rightList).merge(0, mid,
					this.length());
			return fullList;
		} else
			return this;
	}

	/**
	 * Mergesorts an ImmutableList in conjuction with the mergesort method.
	 * 
	 * @param top1
	 *            an int representing the start of the list
	 * @param top2
	 *            an int representing the halfway point of the list
	 * @param out
	 *            an int representing the outer limit of the list
	 * @return a merged list
	 */
	public ImmutableList merge(int top1, int top2, int out) {
		ImmutableList mergeList = NIL;
		int i = top1;
		int j = top2;
		while (j < out && i < top2) {
			int firstInt = ((Integer) this.nth(i));
			int secondInt = ((Integer) this.nth(j));
			if (firstInt < secondInt)
				mergeList = mergeList.append(list(this.nth(i++)));
			else
				mergeList = mergeList.append(list(this.nth(j++)));
		}
		while (i < top2)
			mergeList = mergeList.insert(this.nth(i++));
		while (j < out)
			mergeList = mergeList.insert(this.nth(j++));
		return mergeList;
	}

}