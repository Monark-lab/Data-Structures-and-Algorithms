package lab2;

import java.util.Iterator;

/**
 * A simplified version of the java.util.List interface.
 * 
 */
public interface List<E> extends Iterable<E> {
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	int size();

	/**
	 * Tests whether the list is empty.
	 * 
	 * @return true if the list is empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns (but does not remove) the element at index i.
	 * 
	 * @param i the index of the element to return
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()-1
	 */
	E get(int i) throws IndexOutOfBoundsException;

	/**
	 * Replaces the element at the specified index, and returns the element
	 * previously stored.
	 * 
	 * @param i the index of the element to replace
	 * @param e the new element to be stored
	 * @return the previously stored element
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()-1
	 */
	E set(int i, E e) throws IndexOutOfBoundsException;

	/**
	 * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     * 
     * Remember that You need to make sure you create a new larger array, 
     * double the current size + 1 if needed.
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 * 
	 */
	void add(int i, E e) ;

	/**
	 * Removes and returns the element at the given index, shifting all subsequent
	 * elements in the list one position closer to the front.
	 * 
	 * @param i the index of the element to be removed
	 * @return the element that had be stored at the given index
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()
	 */
	E remove(int i) throws IndexOutOfBoundsException;

	/**
	 * Returns {@code true} if this list contains the specified element. More
	 * formally, returns {@code true} if and only if this list contains at least one
	 * element {@code e} such that {@code equals(e, ArrayElement)}.
	 *
	 * @param e element whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified element
	 * 
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements
	 * 
	 */

	boolean contains(E e) throws NullPointerException;

	/**
	 * Removes the first occurrence of the specified element from this list, if it
	 * is present (optional operation). If this list does not contain the element,
	 * it is unchanged. More formally, removes the element with the lowest index
	 * {@code i} such that {@code equals(e, get(i))} (if such an element exists).
	 * Returns {@code true} if this list contained the specified element (or
	 * equivalently, if this list changed as a result of the call).
	 *
	 * @param e element to be removed from this list, if present
	 * @return {@code true} if this list contained the specified element
	 * 
	 * @throws NullPointerException if the specified element is null and this list
	 *                              does not permit null elements
	 * 
	 */

	boolean remove(E e) throws NullPointerException;

	/**
	 * Appends all of the elements in otherList to this list, in the order that they
	 * are returned by the iterator Returns true if this list changed as a result of
	 * the call
	 * 
	 * @param otherList List containing elements to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws NullPointerException if the specified otherList contains one or more
	 *                              null elements and this list does not permit null
	 *                              elements, or if the specified collection is null
	 */

	boolean addAll(List<E> otherList) throws NullPointerException;

	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified otherList
	 * 
	 * @param otherList list containing elements to be removed from this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws NullPointerException if this list contains a null element and the
	 *                              specified otherList does not permit null
	 *                              elements or if the specified otherList is null
	 */

	boolean removeAll(List<E> otherList) throws NullPointerException;;

	/**
	 * Retains only the elements in this list that are contained in the
     * specified otherList .  In other words, removes
     * from this list all of its elements that are not contained in the
     * specified otherList. Returns true if this list changed as a result of the call
	 * @param otherList  list containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws NullPointerException if this list contains a null element and the
     *         specified otherList does not permit null elements         
     *         or if the specified otherList is null
	 */
	boolean retainAll(List<E> otherList) throws NullPointerException;;

	
	
	
	/**
	 * Returns an iterator of the elements stored in the list.
	 * 
	 * @return iterator of the list's elements
	 */
	Iterator<E> iterator();
}
