package threads;


public class ProducerConsumer<T>  {
	
		int data=0;
		Queue<Integer> queue =new Queue<Integer>();
	public ProducerConsumer(){
		Producer producer=new Producer();
		Consumer consumer=new Consumer();
		Thread p=new Thread(producer);
	    Thread c=new Thread(consumer);
		
		p.start();
		c.start();
		}
		public class Producer implements Runnable{
	
		
		public void run() {
			//Queue is synchronized to restrict simultaneous access by producer and  consumer
		 synchronized(queue)
		 {
			 
				 int i=0;
				 try{
				 while(true)
				 {
					 //If the queue is full the producer notifies the consumer and waits till it is notified by the consumer
					 if(queue.queueSize()>10)
				 {
					 	queue.notify();
					 	System.out.println("producer in wait");
					 	Thread.sleep(3000);
					 	queue.wait();
					}
				   //If the queue is not full, the producer adds elements are added to the queue   
				 else
				 { 
					 queue.enqueue(++i);
				 System.out.print("produced: "+i);
				 System.out.println();
				 queue.printQueue();
				 }
			 }
				 }
			 
			catch(InterruptedException e)
			 {
				 System.out.println("Interrupted exception");
			 }
			
		 }
		}
		 
	}
public class Consumer implements Runnable{
	
		
		public void run() {
		 synchronized(queue)
		 {
			 //If the queue is empty the consumer notifies the producer and waits till it is notified by the producer  
			 try
			 {
				 int i=0;
				 while(true)
				 {
				 if(queue.queueEmpty())
				 {
				    queue.notify();
				     System.out.println("consumer in wait");
				     Thread.sleep(3000);
				     queue.wait();
			 }
				 //If the queue is not empty, consumer removes the elements from the queue 
				 else
				 {
					 
					 System.out.print("Consumed:"+queue.dequeue());
					 System.out.println();
					 queue.printQueue();
					 
				 }
			 }
			 }
			 catch(InterruptedException e)
			 {
				 System.out.println("Interrupted exception");
			 }
			
		 }
		 }
		}
}



