import java.util.Arrays;

/**
 * CyclicList is a circular version of a list. This version is a
 * single cyclic list, where the last item meets the first item.
 * This list does not keep track of size.
 * 
 * @author Carrie
 *
 * @param <T>
 */
public class CyclicList<T> {
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
	public int size() {
		return size;
	}
	
	/**
	 * Adds an item to the end of the array. It handles resizing the
	 * array, if necessary.
	 * @param item 
	 * 			item to add into the list
	 */
	public void add(T item) {
		ensureCapacity();
		checkValid(item);
		data[size] = item;
		size++;
	}
	
	/**
	 * Removes the item at the specified index, and shifts all the
	 * items down by one.
	 * @param i
	 * 		index of the item to be removed
	 * @return item that was previously at the index
	 */
	public T remove(int i) {
		return null;
	}
	
	public boolean contains(T item) {
		return false;
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
	
	/**
	 * Checks for and handles any exceptional behaviour.
	 * @param item
	 * 			item to check for
	 */
	private void checkValid(T item) {
		if (item == null)
			throw new IllegalArgumentException();
	}
}
