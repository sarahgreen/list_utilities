/**********************************************
 * IteratorInterface.java
 * @author SarahGreen
 *********************************************/

package list_utilities;

public interface IteratorInterface {

	/**
	 * Checks if there is a next element.
	 * 
	 * @return true if a next element exists, false otherwise
	 */
	public boolean hasNext();

	/**
	 * Gets the next element.
	 * 
	 * @return Object the next element
	 */
	public Object next();
}
