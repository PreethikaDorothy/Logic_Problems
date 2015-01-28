package tokenBucketFilter;

/**
 * @author SESA366037
 *
 */
public class Main_TBF {

	public static void main(String args[]) {

		Queue<Packet> Q1 = new Queue<Packet>();
		Queue<Packet> Q2 = new Queue<Packet>();

		Bucket bucket = new Bucket(20);

		TokenBucket tokenBucket = new TokenBucket(bucket, 1000);
		Queue_incoming incoming = new Queue_incoming(2000, Q1);
		Server server = new Server(Q2, 2000);
		Thread server_thread = new Thread(server);
		Queue_outgoing outgoing = new Queue_outgoing(bucket, Q1, Q2, server);
		Thread token_bucket = new Thread(tokenBucket);
		Thread incoming_thread = new Thread(incoming);
		Thread outgoing_thread = new Thread(outgoing);
		/*
		 * token_bucket thread adds tokens to the token_bucket at rate r
		 * incoming_thread adds packets to Q1 at rate lambda
		 * outgoing_thread adds packets eligible for transmission to Q2
		 * Server removes packets that are ready for transmission to be  from Q2 
		 */
		token_bucket.start();
		incoming_thread.start();
		outgoing_thread.start();
		server_thread.start();

	}
}
