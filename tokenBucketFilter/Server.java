package tokenBucketFilter;

/**
 * @author SESA366037
 *
 */
public class Server implements Runnable {
/*
 * Mu- service rate by the server
 * waiting_state- waiting state of the server
 */
private Queue<Packet> Queue_outgoing;
 private int Mu;
 private boolean waiting_state=false;
	public Server(Queue<Packet> Q2,int Mu)
	{
		Queue_outgoing=Q2;
		this.Mu=Mu;
	}

	public boolean isWaiting_state() {
		return waiting_state;
	}

	public void setWaiting_state(boolean waiting_state) {
		this.waiting_state = waiting_state;
	}

	public void run() {
		

			while (true) {
				//If Q2 is empty, Server waits till a packet arrives in Q2 and then removes it from Q2
				if(Queue_outgoing.queueEmpty())
				{
					synchronized (Queue_outgoing) {
						try {
							System.out.println("Server is in wait as outgoing queue is empty");
							setWaiting_state(true);
							Queue_outgoing.wait();
							
						} catch (InterruptedException e) {
							System.err.println("Server is interrupted");
						}
					}
				}
                
				Packet packet=Queue_outgoing.dequeue();
				System.out.println("Packet "+packet.getPacketID()+" sent by server");
				try {
					Thread.sleep(Mu);
				} catch (InterruptedException e) {
					System.err.println("Error in the server operation");
				}
				
			}
			}}

			
				
				
			
	
