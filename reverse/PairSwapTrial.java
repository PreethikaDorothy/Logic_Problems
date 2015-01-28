package reverse;

import reverse.LinkedList.Node;

public class PairSwapTrial<T> {
	
	public void pairSwap(LinkedList<T>.Node head_list, LinkedList<T> list) {

		LinkedList<T>.Node current = head_list;
		if (current.next == null)
			return;
		
		list.setHead(current.next);
		while (true) {
		
	 LinkedList<T>.Node forward = current.next.next;
			current.next.next = current;
			if (forward == null) {
				current.next = null;
				return;
			}
		
			if (forward.next == null) {
				current.next = forward;
				return;
			}

			current.next = forward.next;
			current = forward;
		}
		}
}
