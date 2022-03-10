/**
*DoubleLinkedList.java
*
*Implementation for a DoubleLinkedList<E>
*
*@author Katarina Cohen
*@version 1.2
*
*/

import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
  private Node<E> head = null;   // points to the head of the list
  private Node<E> tail = null;   //points to the tail of the list
  private int size = 0;    // the number of items in the list
  
  /**
   *Default constructor initializes the head and tail of the list to 
   *null and the size to 0.
   */
  public DoubleLinkedList() {
	  this.setAll(null, null, 0);
  }
  
  /**
   *Sets the head and tail nodes and the size of list.
   *
   *@param head   the node at the head of the list
   *@param tail   the node at the tail of the list
   *@param size   the integer length of the list
   */
  public void setAll(Node<E> head, Node<E> tail, int size) {
	  this.head = head;
	  this.tail = tail;
	  this.size = size;
  }
  
  /**
   *toString() that iterates through the whole list, formats, and returns
   *the list.
   *
   *@return   the string containing the list's items
   */
  @Override
  public String toString() {
	  ListIterator<E> iter = listIterator();
	  String list = "[";
	  
	  while (iter.hasNext()) {
		  list += iter.next().toString();
		  if (iter.hasNext()) {
			  list += ", ";
		  }
	  }
	  
	  return list + "]";
  }
  
  /**
   *Locates the selected index and adds the desired object at this location.
   *
   *@param index   the integer index where user wants to add new object
   *@param obj   the element that we want to add at the given location
   */
  public void add(int index, E obj)
  { 
	  listIterator(index).add(obj);
   }
  
  /**
   *Appends the given element to the end of the list.
   *
   *@param e   the element we are adding to the list
   *
   *@return   returns boolean true 
   */
  public boolean add(E e) {
	  listIterator(this.size).add(e);
	  return true;
  }
  
  /**
   *Adds the specified element to the front of the list.
   *
   *@param obj   the element that we want to add 
   */
  public void addFirst(E obj) { 
	  listIterator(0).add(obj);
  }
  
  /**
   *Adds the specified element to the current end of the list (index =
   *size - 1).
   *
   *@param obj   the element that we want to add 
   */
  public void addLast(E obj) { 
	  listIterator(size - 1).add(obj);
  }
  
  /**
   *Removes all elements from the list by setting the head and tail nodes to
   *null and the size to 0.
   */
  public void clear() {
	  this.head = null;
	  this.tail = null;
	  this.size = 0;
  }
  
  /**
   *Compares the specified object with the list for equality.
   *
   *@param o   the object we are comparing the list to
   *
   *@return   returns boolean true or false depending on equality
   */
  public boolean equals(Object o) {
	  if (o == null || this.getClass() != o.getClass()) {
		  return false;
	  }
	  else {
		  DoubleLinkedList list = (DoubleLinkedList) o;
		  return this.toString() == list.toString();
	  }
  }
  
  /**
   *If the list is not empty, iterates the list to see if it contains the 
   *specified object.
   *
   *@param o   the object we are looking for in the list
   *
   *@return   returns boolean true if the list contains the object
   */
  public boolean contains(Object o) {
	  //here
	  if (this.size() == 0) {
		  return false;
	  }
	  
	  ListIterator<E> iter = listIterator();
	  
	  while (iter.hasNext()) {
		  Object objNext = iter.next();
		  
		  if (objNext.equals(o)) {
			  return true;
		  }
	  }
	  return false;
  }

  /**
   *Iterator retrieves value, if it exists, from the specified location.
   *
   *@param index   the integer of the location in the list we are looking at
   *
   *@return   returns element at the specified location
   */
  public E get(int index) { 	
	  E returnValue = null;
	  ListIterator<E> iter = listIterator(index); 
  	  if (iter.hasNext()) {
  		  returnValue = iter.next();
  	  }
  	  else {
  		  throw new IndexOutOfBoundsException();
  	  }
      return returnValue;
  }  
  
  /**
   *Retrieves the data from the first item in the list, at the head node.
   *
   *@return   returns the value of the first list item
   */
  public E getFirst() { 
	  return head.data;  
  }
  
  /**
   *Retrieves the data from the last item in the list, at the tail node.
   *
   *@return   returns the value of the last list item
   */
  public E getLast() { 
	  return tail.data;  
  }
  
  /**
   *If list is not empty, iterates through and compares each element to the specified
   *one. Returns index once the list object equals the specified object. 
   *
   *@param o   the object we are locating the index of
   *
   *@return   returns index of item or -1 if list does not contain element
   */
  public int indexOf(Object o) {
	  int i;
	  
	  if (size != 0) {
		  i = 0;
		  ListIterator <E> iter = listIterator();
		  
		  while (iter.hasNext()) {
			  Object other = iter.next();
			  if (other.equals(o)) {
				  return i;
			  }
			  
			  i++;
		  }
	  }
	  
	  return -1;
  }
  
  /**
   *If list is not empty, iterates through starting at the end of the list and 
   *compares each element to the specified one. Returns index once the list object 
   *equals the specified object. 
   *
   *@param o   the object we are locating the index of
   *
   *@return   returns index of last occurrence of item or -1 if list does not contain 
   *element
   */
  public int lastIndexOf(Object o) {
	  int i;
	  
	  if (size != 0) {
		  i = this.size() - 1;
		  ListIterator <E> iter = listIterator(this.size());
		  
		  while (iter.hasPrevious()) {
			  Object other = iter.previous();
			  
			  if (other.equals(o)) {
				  return i;
			  }
			  
			  i--;
		  }
		  
	  }
	  
	  return -1;
  }
  
  /**
   *If head node is null, the list is empty, and the method returns true.
   *
   *@return   returns true if the list contains no elements
   */
  public boolean isEmpty() {
	  return head == null;
  }

  /**
   *Retrieves the number of elements in the list.
   *
   *@return   returns the number of list elements
   */
  public int size() {  
	  return this.size;  
  } 

  /**
   *Removes the element at the specified position in the list. 
   *
   *@param index   the integer of the location at which we are removing the term
   *
   *@return   returns the element we're removing
   */
  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }
  
  /**
   *If the list is not empty, iterates through the list, locates the first instance
   *of the specified element (if present), and removes it from the list. 
   *
   *@param o   the object we are removing
   *
   *@return   returns boolean true if item located and removed
   */
  public boolean remove(Object o) {
	  //here
	  ListIterator <E> iter = listIterator();
	  Object other;
	  
	  if (this.size() == 0) {
		  return false;
	  }
	  else {
		  while (iter.hasNext()) {
			  other = iter.next();
			  
			  if (other.equals(o)) {
				  iter.remove();
				  return true;
			  }
		  }
		  return false;
	  }
  }
  
  /**
   *If list is not empty, locates element at index and replaces it with specific element. 
   *
   *@param index   the integer of the position for replacement
   *@param e   the element we're setting at the location
   *
   *@return   returns the element we are replacing at the location
   */
  public E set(int index, E e) {
	  //here
	  E returnedElement = null;
	  if (index < 0 || index >= this.size) {
		  throw new IndexOutOfBoundsException();
	  }
	  else {
		  if (this.size != 0) {
			  ListIterator <E> iter = listIterator(index);
			  
			  
			  returnedElement = (E) iter.next();
			  iter.set(e);	 
		  }
		 
		return returnedElement;
	  }
	   
  }

  /**
   *@return   returns an iterator over the elements in the list in proper sequence
   */
  public Iterator<E> iterator() { 
	  return new ListIter(0);  
  }
  
  /**
   *@return   returns a list iterator over the elements in the list in proper sequence
   */
  public ListIterator<E> listIterator() { 
	  return new ListIter(0);
  }
  
  /**
   *@param index   the integer for the specified position to start at
   *@return   returns a list iterator over the elements in the list starting at the 
   *specified position in the list
   */
  public ListIterator<E> listIterator(int index) {
	  return new ListIter(index);
  }
  
  public ListIterator<E> listIterator(ListIterator<E> iter){     
	  return new ListIter( (ListIter) iter);  
  }

  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
  }  // end class Node

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i)  // constructor for ListIter class
    {   if (i < 0 || i > size)
        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
        lastItemReturned = null;
 
        if (i == size)     // Special case of last item
        {     index = size;     nextItem = null;      }
        else          // start at the beginning
        {   nextItem = head;
            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
        }// end else
    }  // end constructor

    public ListIter(ListIter other)
    {   nextItem = other.nextItem;
        index = other.index;    }

    /**
     * Method checks if the list has the next element in the forward direction.
     * 
     *@return   returns boolean true if list iterator finds more elements while 
     *traversing list in the forward direction
     */
    public boolean hasNext() {   
    	return nextItem!= null;    
    } 
    
    /**
     * Method checks if the list has the next element in the reverse direction. If the
     * list is empty, returns false. If the current node is empty but the list is not 
     * empty, or if the node is not null, it returns true.
     * 
     *@return   returns boolean true if list iterator finds more elements while 
     *traversing list in the reverse direction
     */
    public boolean hasPrevious() { 
    	
    	if (size == 0) {
    		return false;
    	}
    	
    	return ((nextItem == null && size != 0) || nextItem.prev != null);
    }
    
    /**
     * Returns the calculated previous index.
     * 
     *@return   returns index of the element that would be returned by a subsequent call
     *to previous()
     */
    public int previousIndex() {     
    	return index - 1;
    } 
    
    /**
     * Returns the current index.
     * 
     *@return   returns index of the element that would be returned by a subsequent call
     *to next()
     */
    public int nextIndex() {  
    	return index;    
    } 
    
    /**
     * Replaces the last element returned by next() or previous() with the specified element.
     * 
     *@param o   the element we are setting
     */
    public void set(E o)  { 
    	if (lastItemReturned == null) {
    		throw new IllegalStateException();
    	}
    	else {
    		lastItemReturned.data = o;
    		lastItemReturned = null;
    	}
    }  // not implemented
   
    /**
     * Removes the last element returned by next() or previous() from the list. Links applicable
     * previous and next elements and sets last element returned to null.
     */
    public void remove(){
    	if (isEmpty() || lastItemReturned == null) {
    		throw new IllegalStateException();
    	}
    	//If item is at head, link head to next item and remove previous
    	else if (lastItemReturned == head) { 
    		head = nextItem;
    		head.prev = null;
    	}
    	//If item is at tail, link previous item to the ail and remove the prior item
    	else if (lastItemReturned == tail) {
    		lastItemReturned.prev.next = null;
    		tail = lastItemReturned.prev;
    		tail.next = null;
    	}
    	//If item is in the middle of the list, link previous item to next item
    	else if (lastItemReturned != head && lastItemReturned != tail) {
    		lastItemReturned.next.prev = lastItemReturned.prev;
    		lastItemReturned.prev.next = lastItemReturned.next;
    	}
    	size--;
    	lastItemReturned = null;
    	
    	
    }  // not implemented

    /**
     * Returns next element in list and advances the iterator.
     * 
     * @return   returns next element in list
     */
    public E next()
    {  
        if (!hasNext()) {
        	throw new NoSuchElementException();
        }
        lastItemReturned = nextItem;
        nextItem = nextItem.next;
        index++;
    	return lastItemReturned.data;
    }

    /**
     * Returns previous element in list and moves the iterator backwards.
     * 
     * @return   returns previous element in list
     */
    public E previous() {  
    	if (!hasPrevious()) {
    		throw new NoSuchElementException();
    	}
    	if (nextItem == null) {
    		nextItem = tail;
    	} else {
    		nextItem = nextItem.prev;
    	}
    	lastItemReturned = nextItem;
    	index--;
    	
    	return lastItemReturned.data; 
    }

    /**
     * Inserts the specified element into the list.
     * 
     * @param obj   the element being added
     */
    public void add(E obj) {
    	//Empty list
    	if (head == null) {
    		head = new Node<>(obj);
    		tail = head;
    	}
    	//Adding at the head, link new to previous head
    	else if (nextItem == head) {
    		Node<E> newNode = new Node<>(obj);
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    		head = newNode;
    	}
    	//Adding at the tail, link new to tail
    	else if (nextItem == null) {
    		Node<E> newNode = new Node<>(obj);
    		tail.next = newNode;
    		newNode.prev = tail;
    		tail = newNode;
    	}
    	//Adding in the middle of the list, link previous to new to next
    	else {
    		Node<E> newNode = new Node<>(obj);
    		newNode.prev = nextItem.prev;
    		nextItem.prev.next = newNode;
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    	}
    	size++;
    	index++;
    	lastItemReturned = null;
    
    }
  }// end of inner class ListIter
}// end of class DoubleLinkedList

