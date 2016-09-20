/**********************************************
 * ListSet.java
 * @author SarahGreen
 *********************************************/

package list_utilities;

/**
 * The {@link ListSet} class creates a ListSet object and specifies the methods
 * that can be applied to it. It implements the {@link Set} and
 * {@link IteratorInterface} interfaces. A ListSet is a wrapped ImmutableList
 * that implements methods from those interfaces.
 */

public class ListSet implements Set, IteratorInterface {

	/** instance variable */
	private ImmutableList list;

	/** constructor */
	public ListSet(ImmutableList a) {
		list = a;
	}

	/**
	 * Accesses the {@link ImmutableList} underlying a {@link ListSet}.
	 * 
	 * @return list the underlying {@link ImmutableList}
	 */
	public ImmutableList getList() {
		return list;
	}

	/**
	 * Calculates the size of the set by calling the length() method from
	 * {@link ImmutableList} class.
	 * 
	 * @return int representing the number of elements in the set
	 */
	public int size() {
		return list.length();
	}

	/**
	 * Checks if the set is empty or not by calling the isEmpty() method from
	 * {@link ImmutableList} class.
	 * 
	 * @return true if the set is empty, false if the set is not empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Checks whether a specified Object is a member of the set or not.
	 * 
	 * @param object
	 *            the Object to check whether or not a member of the set
	 * @return true if the Object is a member, false if the Object is not a
	 *         member
	 */
	public boolean isMember(Object object) {
		String b = object.toString();
		String a = this.toString();
		if (a.contains(b))
			return true;
		else
			return false;
	}

	/**
	 * Creates a new set with the union of this set and another set. Does not
	 * modify the current set.
	 * 
	 * @param otherSet
	 *            set to union with
	 * @return finalSet the union of this set and the other set
	 */
	public Set union(Set otherSet) {
		ListSet otherListSet = (ListSet) (otherSet);
		ImmutableList unionList = list;
		unionList = unionList.append(otherListSet.getList());
		unionList = unionList.purge();
		ListSet unionSet = new ListSet(unionList);
		Set finalSet = (Set) (unionSet);
		return finalSet;
	}

	/**
	 * Creates a new set with the intersection of this set and another set. Does
	 * not modify the current set.
	 * 
	 * @param otherSet
	 *            set to intersect with
	 * @return finalSet intersection of this set and the other set
	 */
	public Set intersection(Set otherSet) {
		ListSet otherListSet = (ListSet) (otherSet);
		ImmutableList otherList = otherListSet.getList();
		ImmutableList intersectionList = ImmutableList.NIL;
		for (int i = 0; i < otherSet.size(); i++) {
			if (isMember(otherList.nth(i)))
				intersectionList = intersectionList.push(otherList.nth(i));
		}
		intersectionList = intersectionList.purge();
		ListSet intersectionSet = new ListSet(intersectionList);
		Set finalSet = (Set) intersectionSet;
		return finalSet;
	}

	/**
	 * Creates a copy of the current set. Does not modify the current set.
	 * 
	 * @return finalSet the copy of this set
	 */
	public Set copy() {
		ListSet listCopy = this;
		Set finalSet = (Set) (listCopy);
		return finalSet;
	}

	/**
	 * Adds an Object to this set by calling the insert(Object object) method
	 * from the {@link ImmutableList} class.
	 * 
	 * @param object
	 *            object to add
	 */
	public void add(Object object) {
		list = list.insert(object);
	}

	/**
	 * Removes an Object from this set by calling the delete(Object object)
	 * method from the {@link ImmutableList} class.
	 * 
	 * @param object
	 *            object to delete
	 */
	public void remove(Object object) {
		list = list.delete(object);
	}

	/**
	 * Returns the {@link Iterator} that will iterate through the elements of
	 * this set.
	 * 
	 * @return {@link Iterator} for this set
	 */
	public Iterator iterator() {
		return new Iterator(this);
	}

	/**
	 * Checks if the set contains a next element by calling the hasNext() method
	 * from the {@link Iterator} class.
	 * 
	 * @return true if the set contains a next element, false otherwise
	 */
	public boolean hasNext() {
		return new Iterator(this).hasNext();
	}

	/**
	 * Accesses the next element of the set by calling the next() method from
	 * the {@link Iterator} class.
	 * 
	 * @return the next object
	 */
	public Object next() {
		return new Iterator(this).next();
	}

	/**
	 * Creates an empty copy of this set. Does not modify the current set.
	 * 
	 * @return emptySet an empty copy of this set
	 */
	public Set empty() {
		ListSet emptyList = new ListSet(ImmutableList.NIL);
		Set emptySet = (Set) emptyList;
		return emptySet;
	}

	/**
	 * Creates a String version of this set.
	 * 
	 * @return str the String representing this set.
	 */
	public String toString() {
		Object head = getList().head();
		ImmutableList tail = getList().tail();
		String s = getList().isEmpty() ? "{}" : "{" + head.toString()
				+ (tail.isEmpty() ? "" : " ") + tail.toString().substring(1);
		String str = s.substring(0, s.length() - 1) + "}";
		return str;
	}
}
