package proj3;
/////////////////////////////////////////////////////////////////////
public class BagArray <T> implements BagInterface<T>{
	private T [] arr; 
	private static final int DEFAULT_SIZE = 10;
	private static final int MAX_SIZE = 200; 
	private int numOfEntries;
	//-------------------------------------------------------------------
	/** Default Constructor of size 10*/
	@SuppressWarnings("unchecked")
	public BagArray(){
		arr = (T[])new Object [DEFAULT_SIZE];
		numOfEntries = 0;
	}
	
	/** Constructor
	 @param size of array*/
	@SuppressWarnings("unchecked")
	public BagArray(int size){
		if(size > 200){
			System.out.println("Max size reached, setting to 200");
			size = 200;
		}
		arr = (T[])new Object [size];
		numOfEntries = 0;
	}
	
	/** Gets the current number of entries in this bag.
    @return  The integer number of entries currently in the bag. */
	public int getCurrentSize() {
		 return numOfEntries;
	}
	
	/** Sees whether this bag is empty.
    @return  True if the bag is empty, or false if not. */
	public boolean isEmpty() {
		 return numOfEntries == 0;
	}
	
	/** Adds a new entry to this bag.
    @param newEntry  The object to be added as a new entry.
    @return  True if the addition is successful, or false if not. */
	@SuppressWarnings("unchecked")
	public boolean add(T newEntry) {
		try{if(numOfEntries + 10 > 200){
			System.out.println("Max size reached");
			return false;
		}
		else if(arr.length == numOfEntries){
			this.arr = (T[])new Object[numOfEntries + 10];
		}
		arr[numOfEntries] = newEntry;
		numOfEntries++;
		return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/** Removes a specific entry from this bag, if possible.
    @param anEntry  The entry to be removed.
   @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry) {
		for(int i=0; i<numOfEntries;i++){
			if(arr[i]==anEntry){
				arr[i] = this.remove();
				return true;
			}
		}
		return false;
	}

	/** Removes one unspecified entry from this bag, if possible.
    @return  Either the removed entry, if the removal
    was successful, or null. */
	public T remove() {
		 
		if(!this.isEmpty()){
			T element = arr[numOfEntries-1];
			arr[numOfEntries-1] = null;
			numOfEntries--;
			return element;
		}
		else
			return null;
	}

	/** Removes all entries from this bag. */
	public void clear() {
		 
		while(!this.isEmpty()){
			this.remove();
		}
		if(!this.isEmpty())
			System.out.println("Did not clear");
		else
			numOfEntries = 0;
		
	}
	
	/** Prints all values*/
	public void print() {
		for(int i = 0; i<numOfEntries;i++)
			System.out.print(arr[i]+" ");
			System.out.println();
	}

	/** Tests whether this bag contains a given entry.
    @param anEntry  The entry to locate.
    @return  True if the bag contains anEntry, or false if not. */

	public boolean contains(T anEntry) {
		 
		for(int i = 0; i < numOfEntries;i++){
			if(arr[i] == anEntry)
				return true;
		}
		return false;
	}

	/** Retrieves all entries that are in this bag.
	@return  A newly allocated array of all the entries in the bag. */
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		 
		T[] newArr = (T[])new Object[arr.length];
		for(int i=0; i <numOfEntries;i++){
			newArr[i] = arr[i];
		}
		return newArr;
	}
	/** Counts the number of times a given entry appears in this bag.
	 @param anEntry  The entry to be counted.
	 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for(int i = 0; i < numOfEntries;i++){
			if(arr[i] == anEntry)
				counter++;
		}
		return counter;
	}
	//-------------------------------------------------------------------
}
/////////////////////////////////////////////////////////////////////
