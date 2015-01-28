package reverse;

import reverse.LinkedList.Node;

public class MergeList<T> {
	// To merge the end of second list to a mergePosition in the first list
	/**
	 * @param list1
	 *            - To access the list List1
	 * @param head_list2
	 *            -start of the second List
	 * @param mergePosition
	 *            -Merging point of both the lists
	 **/
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void merge(LinkedList<T> list1, LinkedList<T>.Node head_list2,
			int mergePosition) {
		Node current = head_list2;
		while (current.next != null)
			current = current.next;
		// Links the second list to the first list at mergePosition
		current.next = (Node) list1.getNodeAt(mergePosition);

	}

	// To find the merging point
	/**
	 * @param list1
	 *            - The first list
	 * @param list2
	 *            -The second list
	 * @param head_list1
	 *            - First element of the first list
	 * @param head_list2
	 *            - First element of the second list
	 * @return
	 */
	public int mergePosition(LinkedList<T> list1, LinkedList<T> list2,
			LinkedList<T>.Node head_list1, LinkedList<T>.Node head_list2) {
		int count = 0;
		int lag = 0;
		int mergePosition = 1;
		Node current_list1 = head_list1;
		Node current_list2 = head_list2;

		// Traverse both the lists till the end of any one of the lists is
		// reached

		while (current_list1 != null && current_list2 != null) {

			current_list1 = current_list1.getNext();
			current_list2 = current_list2.getNext();
		}
		// Lag is size difference between the second list and the first list
		if (current_list1 == null) {

			while (current_list2 != null) {
				current_list2 = current_list2.getNext();
				lag++;
			}
	

			current_list1 = head_list1;
			current_list2 = head_list2;
			// Traverse the longer list to the Nth position (N=lag)
			current_list2 = head_list2;
			current_list1 = head_list1;
			while (count != lag) {
				current_list2 = current_list2.next;
				count++;
			
			}
		} else {
			// Lag is size difference between the first list and the second list
			while (current_list1 != null) {
				current_list1 = current_list1.getNext();
				lag++;
			}
			// Traverse the longer list to the Nth position and set current
			// (N=lag)
			current_list2 = head_list2;
			current_list1 = head_list1;
			while (count != lag) {
				current_list1 = current_list1.next;
				count++;
			}
		}

		/* After setting the reference in the longer list to lag traverse both
		the lists one element at a time and check if they are equal.
		 The point at which they meet is the mergePosition*/

		while (!current_list1.equals(current_list2)) {
			current_list1 = current_list1.getNext();
			current_list2 = current_list2.getNext();

			mergePosition++;
		}

		return mergePosition;
	}
}
