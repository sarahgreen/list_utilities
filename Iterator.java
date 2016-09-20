/**********************************************
 * Iterator.java
 * @author SarahGreen
 *********************************************/

package list_utilities;

/**
 * The {@link Iterator} class implements the {@link IteratorInterface}
 * interface. An {@link Iterator} Object is a wrapped {@link ListSet}. The class
 * contains methods to check if a {@link ListSet} has a next element, and to
 * return the next element.
 */

public class Iterator implements IteratorInterface {

	/** instance variable */
	private ListSet listSet;

	/** constructor */
	public Iterator(ListSet a) {
		listSet = a;
	}

	/**
	 * Checks if there is a next element.
	 * 
	 * @return true if a next element exists, false otherwise
	 */
	public boolean hasNext() {
		if (listSet.getList().tail().equals(ImmutableList.NIL))
			return false;
		else
			return true;
	}

	/**
	 * Gets the next element.
	 * 
	 * @return Object the next element
	 */
	public Object next() {
		if (listSet.getList().tail().equals(ImmutableList.NIL))
			return null;
		else
			return listSet.getList().tail().head();
	}
}
