package Loop;

import java.util.NoSuchElementException;

/**
 * @author SESA366037
 * 
 * @param <T>
 *            Generic type
 */
public class Loop_check<T> {

	/**
	 * @param slow
	 *            - Iterator Object to traverse the list
	 * @param fast
	 * @param list
	 *            - List object to get the list size
	 * @return
	 * @throws NoSuchElementException
	 */
	public int loopExists(IteratorCustomized<T> slow,
			IteratorCustomized<T> fast, IteratorCustomized<T> loopPtr)
			throws NoSuchElementException

	{
		
		int flag = 0;
		int loopSize = 0;
		int position=1;
		//Check if the slow iterator and fast iterator meet.
		while (fast.hasNext()) {
			slow.pass(1);
			fast.pass(2);
			if (fast != null) {
				if (slow.getCurrent().equals(fast.getCurrent())) {
					do{
						// Iterate loopPtr through the loop till you reach the point at the iterators 
						loopPtr=fast;
						loopPtr.traverse();
						loopSize++;
						//Break when loopPtr meets the slow iterator 
						if(loopPtr.getCurrent().equals(slow.getCurrent()))
							break;
						
					}while(true);
				      
					slow.setToHead();
					fast.setToHead();
					//Set fastIterator to the Nth node(N=loopSize)
					fast.pass(loopSize);
					while(!slow.getCurrent().equals(fast.getCurrent()))
					{
						
						slow.traverse();
						fast.traverse();
						position++;
					}
					return position;
				}
			}

		}
		return -1;

	}
}
