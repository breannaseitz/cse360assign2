package cse360assign2;

/**
 *This File contains methods for creating a SimpleList 
 * which is an integer array of length 10.
 * 
 * @author Breanna Seitz
 * @ClassID 323
 * @Assignment1
 *
 */

/**
 * The SimpleList class creates an array of length 10 to which elements
 * can be added, removed, and searched for. The user can also obtain the
 *number of elements as well as a string version of the list.
 */


public class SimpleList{

	/**
	 * variables
	 */
	private int[] list;
	private int count;

	/**
	 * methods
	 */

	/** 
	 * SimpleList is the constructor method. It initializes the list
	 * array to have 10 elements and initializes count to 0.
	 */
	public SimpleList(){
		list = new int[10];
		count = 0;
	}


	/**
	 * add takes in an integer 'beg' and adds it to the beginning
	 * of the list array. If it is full, the last element 'falls off'.
	 * @param beg
	 */
	public void add(int beg){

		/**
		 * this loop shifts each element to the right. i is decremented if the list
		 * is full to allow the last element to fall off.
		 */
		for(int index = count; index > 0; index--){
			if(index == 10) {
				index--;
			}
			list[index] = list[index-1];
		}
		list[0] = beg;

		/**
		 * count does not increment when the list is full.
		 */
		if(count < 10) {
			count++;
		}
	}

	/**
	 * remove takes in an integer, searches to see if it is on the list, and removes it
	 * if it is. Each element after is shifted down prevent gaps in list.
	 * 
	 * @param rem
	 */
	public void remove(int rem){
		int index = search(rem);
		if(index > -1){

			/**
			 * shifts each element down after rem, then replaces the last digit with 0.
			 */
			for(int inc = index; inc < count - 1; inc++){
				list[inc] = list[inc+1];
			}
			list[count - 1] = 0;
			count--;
		}
	}

	/**
	 * count returns the number of elements on the list.
	 * @return count
	 */
	public int count(){
		return count;
	}


	/**
	 * toString creates a string version of list
	 * where there is a space between each element
	 * but not before or after the list.
	 * 
	 * @return listStr
	 */
	public String toString(){
		int index = 0;
		String listStr = "";

		/**
		 * adds each element to the string except for the last one to prevent
		 * the space at the end.
		 */
		
		while(index < count-1){
			listStr += list[index] + " ";
			index++;

		}

		/**
		 *makes sure not to add anything if the list is empty. 
		 */

		if(count > 0) {
			listStr += list[count-1];
		}
		return listStr;
	}

	/**
	 * search takes in a value and parses through the list. it returns the first
	 * instance of an element and -1 if the element is not on the list.
	 * 
	 * @param find
	 * @return
	 */
	public int search(int find){
		int index = -1;
		boolean found = false;

		/**
		 * looks through array; the boolean allows us to get the index of the first instance only
		 */
		for(int inc = 0; inc < count; inc++){
			if(list[inc] == find && !found){
				index = inc;
				found = true;
			}
		}
		return index;
	}

}
