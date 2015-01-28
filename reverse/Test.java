package reverse;

import reverse.LinkedList;

public class Test {
	/**
	 * @param
	 */
	public static void main(String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		// Loop_check loop = new Loop_check();
		// List functions
		list.addAtStart(3);
		list.addAtEnd(4);
		list.addAtEnd(5);
		list.addAtStart(2);
		list.addAtStart(1);
		list.addAtEnd(6);
		// list.addAloop(2);
		// list.display();
		list2.addAtStart(3);
		list2.addAtEnd(4);
		list2.addAtEnd(5);
		list2.addAtStart(2);
		list2.addAtStart(1);
		list2.addAtEnd(6);
		list2.addAtEnd(7);
		
		 list2.addAtEnd(8);
		 list2.addAtEnd(9);
		list2.addAtEnd(10);
		 

		// list2.addAloop(2);
		list2.display();
		IteratorCustomized<Integer> itr1 = list.iterator();
		IteratorCustomized<Integer> itr2 = list.iterator();
		IteratorCustomized<Integer> itr3 = list.iterator();
		IteratorCustomized<Integer> itr4 = list.iterator();
		/*
		 * Check if loop exists int n=loop.loopExists(itr1, itr2,itr3);
		 * if(n==-1) System.out.println("Loop does not exists"); else
		 * System.out.println("Loop at "+n);
		 */
		// list2.display();
		PairSwap<Integer> ps = new PairSwap();
		//ps.pairSwap(list2.getHead(), list2);
		 PairSwapTrial<Integer> ps1=new PairSwapTrial();
		 ps1.pairSwap(list2.getHead(), list2);
		list2.display();
		Reverse_iterative<Integer> reverse_iterative = new Reverse_iterative<Integer>();
		Reverse_recursive<Integer> reverse_recursive = new Reverse_recursive<Integer>();
		// reverse_iterative.reverse(list.getHead(),list);
		// reverse_recursive.reverse(list.getHead(), list);
		// list.display();
		/*
		 * int position=4; MergeList<Integer> merge=new MergeList<Integer>();
		 * merge.merge(list, list2.getHead(), position); list.display();
		 * list2.display(); //
		 * System.out.println("Merge Position :"+merge.mergePosition(list,
		 * list2, list.getHead(), list2.getHead()));
		 */

	}
}
