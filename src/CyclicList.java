import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * CyclicList is a circular version of a list. This version is a
 * single cyclic list, where the last item meets the first item.
 * This list does not keep track of size, and allows duplicates.
 * 
 * @author Carrie
 *
 * @param <T>
 */
public class CyclicList<T> implements Iterable<T> {
	private static final int SIZE = 10;
	
	private T[] data;
	private int size;
	
	/**
	 * Create a new cyclic list.
	 */
	public CyclicList(){
		data = (T[]) new Object[SIZE];
		size = 0;
	}
	
	/**
	 * Gets the no. of items in the cyclic list
	 * @return 
	 * 		no. of items in list
	 */
	public int size() { return size; }
	
	/**
	 * Checks whether or not this CyclicList is empty.
	 * @return
	 * 		true if nothing in the list, false otherwise
	 */
	public boolean isEmpty() { return data[0] == null; }
	
	/**
	 * Adds an item to the end of the array. It handles resizing the
	 * array, if necessary.
	 * @param item 
	 * 			item to add into the list
	 */
	public void add(T item) {
		if (item == null)
			throw new IllegalArgumentException();
		// check for class types?
		
		ensureCapacity();
		data[size] = item;
		size++;
	}
	
	/**
	 * Uses binary search to find the index, and get the element at
	 * that index
	 * 
	 * @param i 
	 * 		index to search for
	 * @return
	 * 		element at the index
	 */
	public T get(int i) {
	int low = 0, high = size;
		
		T res = null;
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (mid == i) {		// found the index
				res = data[mid];
				break;
			}
			else if (i < mid) {		// index in left part of array
				high = mid;
			}
			else {		// otherwise it's in the right part
				low = mid;
			}
		}
		
		return res;	
	}
	
	/**
	 * Removes the item at the specified index, and shifts all the
	 * items down by one.
	 * @param i
	 * 		index of the item to be removed
	 * @return 
	 * 		item that was previously at the index
	 */
	public T remove(int i) {
		if (i<0 || i>data.length) return null;
		
		T remove = get(i);	// get the value at the index
		shiftItems(i);		// shift items down
		
		return remove;
	}
	
	/**
	 * Secondary remove method that removes the item from the array.
	 * After removal, shifts all items down.
	 * @param item
	 * @return
	 */
	public T remove(T item) {
		int i;
		if ((i = contains(item)) == -1) return null;
		
		T res = data[i];	// get the value at the index
		shiftItems(i);		// shift items down
		return res;
	}
	
	/**
	 * Shifts items down from the specified index.
	 * @param ind
	 * 			starting index to shift items from
	 */
	private void shiftItems(int i) {
		for (int ind=i; ind<data.length-1; ind++) 
			data[ind] = data[ind+1];
		data[size] = null;		// handle last element
		size--;
	}
	
	/**
	 * Finds whether the item exists in the array, and returns the
	 * index position of the first occurrence.
	 * @param item
	 * 		item to look for
	 * @return
	 * 		index position of item in array, -1 if it doesn't exist
	 */
	public int contains(T item) {
		for (int i=0; i<data.length; i++) {
			if (data[i].equals(item)) return i;
		}
		
		return -1;
	}
	
	/**
	 * Gets the next item from the given index. 
	 * eg) index = 0, get item at index 1
	 * Since it's a cyclic list, if the index is the last element, 
	 * the first item will be returned.
	 * 
	 * @param index
	 * 			position to get next item from
	 * @return
	 * 		item at the next given position
	 */
	public T next(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		
		if (index == size)	// returns first item if it's the last item
			return data[0];
		
		return data[index+1];	// otherwise return the next item
	}
	
	/**
	 * Randomly assort the contents of the list -- but only the areas
	 * of the array that are actually occupied. Otherwise, we'll end
	 * up with empty slots peppered over the list. 
	 */
	public void shuffle() {
		// nothing in the list
		if (data == null || isEmpty()) return;
		
		// shuffle only the areas that are occupied
		List<T> temp = new ArrayList<>(Arrays.asList(
				Arrays.copyOfRange(data, 0, size)));
		Collections.shuffle(temp);	// shuffle as list
		data = temp.toArray(data);	// convert list back to array
	}
	
	/**
	 * Method to facilitate the 'growing' list. If there's no more
	 * space in the array, the array is doubled the size.
	 */
	private void ensureCapacity() {
		if (size < data.length) return;	// still space remaining
		
		// create a new array, and copy items over
		T[] temp = (T[]) Arrays.copyOf(data, data.length*2);
		data = temp;
	}

	@Override
	public Iterator iterator() {
		return new CyclicListIterator<T>(this);
	}
	
	//================================================================================
	// private iterator class - CyclicIterator
	//================================================================================

	private class CyclicListIterator<T> implements Iterator<T>{
		private CyclicList list;
		private int index;
		
		/**
		 * Create the cyclic list iterator.
		 */
		public CyclicListIterator(CyclicList c) {
			list = c;
			index = 0;
		}

		/**
		 * Checks whether or not there is an element left
		 */
		@Override
		public boolean hasNext() {
			if (index < 0 || index > list.size()) return false;
			return true;
		}

		/**
		 * Returns the element at the current index position, and
		 * shifts pointer to point to next index.
		 */
		@Override
		public T next() {
			T res = (T) list.get(index);
			index++;
			return res;
		}
		
	}
}
