package lab2;

import java.util.*;
import java.lang.annotation.*;

//You are NOT allowed to add any "import" statement other than 
//the ones already in the starter files. 

///////////////////////////////////////////////////////////////////////////
//Full Name : MONARK PATEL
//Date : 2025-01-15
//Authenticity Declaration :
//I declare this submission is the result of my own work and has not been
//shared with any other student or 3rd party content provider.This submitted
//piece of work is entirely of my own creation.
//////////////////////////////
/*
 * <p>
 * Your implementation of this class or methods should not contains:
 * 1. No System.out.println statements should appear here. Instead, you need to
 * return the result. 2. No Scanner operations should appear here (e.g.,
 * input.nextInt()). Instead, refer to the input parameters of this method.
 * </p>
 */


public class YorkArrayList<E> implements List<E> {

	/**
	 * Initial size, default size, for the Array list
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	public static final int INITSIZE = 16;

	/**
	 * 
	 * Stores the elements of the array list Remember that you can not instantiate
	 * an array of E[], but you can instantiate an array of Object and then typecast
	 * it.
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private E[] data = (E[]) new Object[INITSIZE];

	/**
	 * current number of elements
	 */
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	private int size = 0;

	/**
	 * No argument constructor
	 */
	public YorkArrayList() {
		// TODO: Your implementation of this method starts here
		this.data = (E[]) new Object[0];
		this.size = 0;
		
	}
	
	/**
	 * Constructor takes array of elements and then add then to 
	 * the end of the Array list 
	 * @param objects
	 */
	
	public YorkArrayList(E[] objects) {
		// TODO: Your implementation of this method starts here
		this.data = (E[]) new Object[objects.length];
		
		for(int i=0; i<objects.length; i++) {
			this.data[i] = objects[i];
		}
		this.size = data.length;
	  }
	

	@Override
	public int size() {
		// TODO: Your implementation of this method starts here
		 return this.size;	
	}

	@Override
	public boolean isEmpty() {
		// TODO: Your implementation of this method starts here
		 return this.size == 0;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(1)")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		if(i >= this.size) {
			throw new IndexOutOfBoundsException("Index is greater than size");
		}
		 return this.data[i];

	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(1)")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
	    // Check both lower and upper bounds
	    if (i < 0 || i >= this.size) {
	        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds for size " + this.size);
	    }
	    // Replace the element at the specified index
	    E temp = data[i];
	    this.data[i] = e;
	    return temp;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(N)")
	@Override
	public void add(int i, E e) {
		// TODO: Your implementation of this method starts here
		 if (i > size) {
		        i = size; 
		        e = null;
		    }
		E[] temp = (E[]) new Object[this.size];
		for(int len=0; len<this.size; len++) {
			temp[len] = this.data[len];
		}
		this.data = (E[]) new Object[this.size+1];	
		for(int len=0; len<i; len++) {
			this.data[len] = temp[len];
		}
		this.data[i] = e;
		
		for(int len=i+1; len<this.size + 1; len++) {	
			this.data[len] = temp[len-1];
		}
		this.size++;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(N)")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		// TODO: Your implementation of this method starts here
		
		E[] temp = (E[]) new Object[this.size];
		for(int len=0; len<this.size; len++) {
			temp[len] = this.data[len];
		}
		this.data = (E[]) new Object[this.size-1];	
		for(int len=0; len<i; len++) {
			this.data[len] = temp[len];
		}
		E ele = temp[i];
		for(int len=i; len<this.size-1; len++) {
			this.data[len] = temp[len+1];
		}
		this.size--;
		return ele;
	}




	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean contains(E e) throws NullPointerException {
		// TODO: Your implementation of this method starts here
		if(e == null) {
			throw new NullPointerException();
		}
		for(E ele: this.data) {
			if(ele.equals(e)) {
				return true;
			}
		}
			return false;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "O(N^2)")
	@Override
	public boolean remove(E e) throws NullPointerException {
		// TODO Your implementation of this method starts here
		if(e == null) {
			throw new NullPointerException();
		}
		 for(int i=0; i<this.size; i++) {
			 if(this.data[i].equals(e)) {
				 remove(i);
				 return true;
			 }
		 }
		 return false;
	}
	
	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean addAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
		if(otherList == null) {
			throw new NullPointerException();
		}
		if(otherList.isEmpty()) {
			return false;
		}
		
		int temp=this.size;
		for(int i=0; i<otherList.size(); i++) {
			this.add(temp + i, otherList.get(i));
		}
		 return true;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean removeAll(List<E> otherList) throws NullPointerException {
		// TODO Your implementation of this method starts here
		if(otherList == null) {
			throw new NullPointerException();
		}
		if(otherList.isEmpty()) {
			return false;
		}
		for(E ele:otherList) {
			this.remove(ele);
		}
		 return true;
	}

	/*
	 * Add time complexity annotation taken by this method (@TimeComplexity). 
	 * Justify the time complexity inside the method body with TCJ
	 */
	@TimeComplexity(value = "")
	@Override
	public boolean retainAll(List<E> otherList) {
	    if (otherList == null) throw new NullPointerException();
	    if (isEmpty() || otherList.isEmpty()) return false;

	    E[] temp = (E[]) new Object[size];
	    int newSize = 0;

	    for (int i = 0; i < size; i++) {
	        if (otherList.contains(data[i])) {
	            temp[newSize++] = data[i];
	        }
	    }
	    if (newSize == size) return false; // No change

	    System.arraycopy(temp, 0, data, 0, newSize);
	    for (int i = newSize; i < size; i++) data[i] = null;
	    size = newSize;
	    return true;
	}

	
	/**
	 * Return String value represent the content of list as 
	 * example "[30, 110, -110, -2, 1322]"
	 */
	@Override
	public String toString() {
	    if (size < 0 || size > data.length) {
	        throw new IllegalStateException("Invalid size: " + size);
	    }

	    if (size == 0) {
	        return "[]"; // Handle empty list
	    }

	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (int i = 0; i < size; i++) {
	        sb.append(data[i]);
	        if (i < size - 1) {
	            sb.append(", ");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}
	
	@Override
	public Iterator<E> iterator() {
	    return new Iterator<E>() {
	        private int index = 0;

	        @Override
	        public boolean hasNext() {
	            return index < size;
	        }

	        @Override
	        public E next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            return data[index++];
	        }
	    };
	}

	
}
