package tokenBucketFilter;

public class Queue_outgoing implements Runnable {
	private Queue<Packet> queue_incoming, queue_outgoing;
	private Bucket bucket;
	private Packet packet;
	private Server server;

	public Queue_outgoing(Bucket bucket, Queue<Packet> Q1, Queue<Packet> Q2,
			Server server) {
		this.bucket = bucket;
		queue_incoming = Q1;
		queue_outgoing = Q2;
		this.server = server;
	}

	public void run() {
		while (true) {
			
			if (!queue_incoming.queueEmpty()) {
				packet = queue_incoming.dequeue();
				packet.setExit_timestamp();
				// If the packet is eligible for transmission(enough tokens in
				// the token Bucket) dequeue packet from Q1 and
				// enqueue to Q2
				if (queue_outgoing.getSize() == 1) {
					//If the server is in waiting notify the server if Q2 is not empty 
					synchronized (queue_outgoing) {
						if (server.isWaiting_state()) {
							server.setWaiting_state(false);
							System.out.println("Server is notified");
							queue_outgoing.notify();
							
						}
					}

				}
				/*If there are enough number of tokens in the token_bucket,tokens are removed form token _bucket and packet is transmitted to Q2
				else the packet is added to Q1
				*/
				if (bucket.bucket_count() >= packet.getRequiredToken()) {
					int num_tokens = 0;
					while (num_tokens < packet.getRequiredToken()) {
						bucket.removeToken();
						num_tokens++;
					}
					queue_outgoing.enqueue(packet);
				
					System.out.println("Packet " + packet.getPacketID()
							+ " added to Q2 at :  "+packet.getExit_timestamp());

				} else
					queue_incoming.enqueue(packet);
				System.out
						.println("Packet "
								+ packet.getPacketID()
								+ " added back  to Q1 as it is not eligible for transmission");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}