package reverse;

import reverse.LinkedList.Node;

public class PairSwap<T> {
	/**
	 * @param head_list
	 *            - The first element of the list
	 * @param list
	 *            - To access the list elements
	 */
	public void pairSwap(LinkedList<T>.Node head_list, LinkedList<T> list) {

		LinkedList<T>.Node current = head_list;
		if (current.next == null)
			return;
		// Set the second element as the first element of the list
		list.setHead(current.next);
		while (true) {
			// Swaps the pair of elements
			
			// forward is a reference to the next pair  in the list
			
			 LinkedList<T>.Node forward = current.next.next;
			 
		//Reverse the link of the second element in the pair to the first element (2->1)
			 
			current.next.next = current;
	
			//If there are no more pairs in the list set the link of the last element to null
			if (forward == null) {
				current.next = null;
				return;
			}
			// If there is a single element in end , set the link to the last element
			if (forward.next == null) {
				current.next = forward;
				return;
			}

			current.next = forward.next;
			current = forward;
		}
	}
}
