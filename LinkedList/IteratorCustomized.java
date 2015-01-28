package LinkedList;
import java.util.Iterator;
public interface IteratorCustomized<E> extends Iterator<E> {
	    
		void traverse();
	//To traverse p passes in the list 
	    void pass(int p); 
	    E getValue();
	}


