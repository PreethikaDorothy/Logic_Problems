package tokenBucketFilter;

/**
 * @author SESA366037
 *
 */
public class Queue_incoming implements Runnable {
	/**
	 * lambda - Packet arrival rate at Q1
	 * Queueincoming- Q1
	 */
	private int lambda;
	private Queue<Packet> Queueincoming;

	public Queue_incoming(int packet_ArrivalRate, Queue<Packet> Q1) {
		lambda = packet_ArrivalRate;
		Queueincoming = Q1;

	}

	public void run() {
		

			while (true) {
				Packet packet = new Packet();
				packet.setRequiredToken(2);
				 Queueincoming.enqueue(packet);
					System.out.println("Packet "+packet.getPacketID()+"  arrived at Q1 at:  "+packet.getEntry_timestamp());
					try {
						Thread.sleep(lambda);
					} catch (InterruptedException e) {
						
						System.err.println("Error in Packet arrival");
					}
					
			}
	}
}			
				
				
			
	
